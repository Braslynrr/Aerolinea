/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.exceptions.PreexistingEntityException;
import aerolinea.logic.TipoAvion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Mario
 */
public class TipoAvionJpaController implements Serializable {

    public TipoAvionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoAvion tipoAvion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoAvion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoAvion(tipoAvion.getIdentificador()) != null) {
                throw new PreexistingEntityException("TipoAvion " + tipoAvion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoAvion tipoAvion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoAvion = em.merge(tipoAvion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipoAvion.getIdentificador();
                if (findTipoAvion(id) == null) {
                    throw new NonexistentEntityException("The tipoAvion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoAvion tipoAvion;
            try {
                tipoAvion = em.getReference(TipoAvion.class, id);
                tipoAvion.getIdentificador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoAvion with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoAvion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoAvion> findTipoAvionEntities() {
        return findTipoAvionEntities(true, -1, -1);
    }

    public List<TipoAvion> findTipoAvionEntities(int maxResults, int firstResult) {
        return findTipoAvionEntities(false, maxResults, firstResult);
    }

    private List<TipoAvion> findTipoAvionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoAvion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoAvion findTipoAvion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoAvion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoAvionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoAvion> rt = cq.from(TipoAvion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
