/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.exceptions.PreexistingEntityException;
import aerolinea.logic.MetodoPago;
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
public class MetodoPagoJpaController implements Serializable {

    public MetodoPagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MetodoPago metodoPago) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(metodoPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMetodoPago(metodoPago.getCodigo()) != null) {
                throw new PreexistingEntityException("MetodoPago " + metodoPago + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MetodoPago metodoPago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            metodoPago = em.merge(metodoPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = metodoPago.getCodigo();
                if (findMetodoPago(id) == null) {
                    throw new NonexistentEntityException("The metodoPago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MetodoPago metodoPago;
            try {
                metodoPago = em.getReference(MetodoPago.class, id);
                metodoPago.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The metodoPago with id " + id + " no longer exists.", enfe);
            }
            em.remove(metodoPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MetodoPago> findMetodoPagoEntities() {
        return findMetodoPagoEntities(true, -1, -1);
    }

    public List<MetodoPago> findMetodoPagoEntities(int maxResults, int firstResult) {
        return findMetodoPagoEntities(false, maxResults, firstResult);
    }

    private List<MetodoPago> findMetodoPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MetodoPago.class));
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

    public MetodoPago findMetodoPago(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MetodoPago.class, id);
        } finally {
            em.close();
        }
    }

    public int getMetodoPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MetodoPago> rt = cq.from(MetodoPago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
