/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import aerolinea.logic.Avion;
import aerolinea.logic.TipoAvion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin2
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
        if (tipoAvion.getAvionList() == null) {
            tipoAvion.setAvionList(new ArrayList<Avion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Avion> attachedAvionList = new ArrayList<Avion>();
            for (Avion avionListAvionToAttach : tipoAvion.getAvionList()) {
                avionListAvionToAttach = em.getReference(avionListAvionToAttach.getClass(), avionListAvionToAttach.getIdentificador());
                attachedAvionList.add(avionListAvionToAttach);
            }
            tipoAvion.setAvionList(attachedAvionList);
            em.persist(tipoAvion);
            for (Avion avionListAvion : tipoAvion.getAvionList()) {
                TipoAvion oldTipoAOfAvionListAvion = avionListAvion.getTipoA();
                avionListAvion.setTipoA(tipoAvion);
                avionListAvion = em.merge(avionListAvion);
                if (oldTipoAOfAvionListAvion != null) {
                    oldTipoAOfAvionListAvion.getAvionList().remove(avionListAvion);
                    oldTipoAOfAvionListAvion = em.merge(oldTipoAOfAvionListAvion);
                }
            }
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

    public void edit(TipoAvion tipoAvion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoAvion persistentTipoAvion = em.find(TipoAvion.class, tipoAvion.getIdentificador());
            List<Avion> avionListOld = persistentTipoAvion.getAvionList();
            List<Avion> avionListNew = tipoAvion.getAvionList();
            List<String> illegalOrphanMessages = null;
            for (Avion avionListOldAvion : avionListOld) {
                if (!avionListNew.contains(avionListOldAvion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Avion " + avionListOldAvion + " since its tipoA field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Avion> attachedAvionListNew = new ArrayList<Avion>();
            for (Avion avionListNewAvionToAttach : avionListNew) {
                avionListNewAvionToAttach = em.getReference(avionListNewAvionToAttach.getClass(), avionListNewAvionToAttach.getIdentificador());
                attachedAvionListNew.add(avionListNewAvionToAttach);
            }
            avionListNew = attachedAvionListNew;
            tipoAvion.setAvionList(avionListNew);
            tipoAvion = em.merge(tipoAvion);
            for (Avion avionListNewAvion : avionListNew) {
                if (!avionListOld.contains(avionListNewAvion)) {
                    TipoAvion oldTipoAOfAvionListNewAvion = avionListNewAvion.getTipoA();
                    avionListNewAvion.setTipoA(tipoAvion);
                    avionListNewAvion = em.merge(avionListNewAvion);
                    if (oldTipoAOfAvionListNewAvion != null && !oldTipoAOfAvionListNewAvion.equals(tipoAvion)) {
                        oldTipoAOfAvionListNewAvion.getAvionList().remove(avionListNewAvion);
                        oldTipoAOfAvionListNewAvion = em.merge(oldTipoAOfAvionListNewAvion);
                    }
                }
            }
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

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Avion> avionListOrphanCheck = tipoAvion.getAvionList();
            for (Avion avionListOrphanCheckAvion : avionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TipoAvion (" + tipoAvion + ") cannot be destroyed since the Avion " + avionListOrphanCheckAvion + " in its avionList field has a non-nullable tipoA field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
