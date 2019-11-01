/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.exceptions.PreexistingEntityException;
import aerolinea.logic.Avion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import aerolinea.logic.TipoAvion;
import aerolinea.logic.Vuelo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin2
 */
public class AvionJpaController implements Serializable {

    public AvionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Avion avion) throws PreexistingEntityException, Exception {
        if (avion.getVueloList() == null) {
            avion.setVueloList(new ArrayList<Vuelo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoAvion tipoA = avion.getTipoA();
            if (tipoA != null) {
                tipoA = em.getReference(tipoA.getClass(), tipoA.getIdentificador());
                avion.setTipoA(tipoA);
            }
            List<Vuelo> attachedVueloList = new ArrayList<Vuelo>();
            for (Vuelo vueloListVueloToAttach : avion.getVueloList()) {
                vueloListVueloToAttach = em.getReference(vueloListVueloToAttach.getClass(), vueloListVueloToAttach.getIdentificador());
                attachedVueloList.add(vueloListVueloToAttach);
            }
            avion.setVueloList(attachedVueloList);
            em.persist(avion);
            if (tipoA != null) {
                tipoA.getAvionList().add(avion);
                tipoA = em.merge(tipoA);
            }
            for (Vuelo vueloListVuelo : avion.getVueloList()) {
                Avion oldAvionOfVueloListVuelo = vueloListVuelo.getAvion();
                vueloListVuelo.setAvion(avion);
                vueloListVuelo = em.merge(vueloListVuelo);
                if (oldAvionOfVueloListVuelo != null) {
                    oldAvionOfVueloListVuelo.getVueloList().remove(vueloListVuelo);
                    oldAvionOfVueloListVuelo = em.merge(oldAvionOfVueloListVuelo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAvion(avion.getIdentificador()) != null) {
                throw new PreexistingEntityException("Avion " + avion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Avion avion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Avion persistentAvion = em.find(Avion.class, avion.getIdentificador());
            TipoAvion tipoAOld = persistentAvion.getTipoA();
            TipoAvion tipoANew = avion.getTipoA();
            List<Vuelo> vueloListOld = persistentAvion.getVueloList();
            List<Vuelo> vueloListNew = avion.getVueloList();
            List<String> illegalOrphanMessages = null;
            for (Vuelo vueloListOldVuelo : vueloListOld) {
                if (!vueloListNew.contains(vueloListOldVuelo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vuelo " + vueloListOldVuelo + " since its avion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (tipoANew != null) {
                tipoANew = em.getReference(tipoANew.getClass(), tipoANew.getIdentificador());
                avion.setTipoA(tipoANew);
            }
            List<Vuelo> attachedVueloListNew = new ArrayList<Vuelo>();
            for (Vuelo vueloListNewVueloToAttach : vueloListNew) {
                vueloListNewVueloToAttach = em.getReference(vueloListNewVueloToAttach.getClass(), vueloListNewVueloToAttach.getIdentificador());
                attachedVueloListNew.add(vueloListNewVueloToAttach);
            }
            vueloListNew = attachedVueloListNew;
            avion.setVueloList(vueloListNew);
            avion = em.merge(avion);
            if (tipoAOld != null && !tipoAOld.equals(tipoANew)) {
                tipoAOld.getAvionList().remove(avion);
                tipoAOld = em.merge(tipoAOld);
            }
            if (tipoANew != null && !tipoANew.equals(tipoAOld)) {
                tipoANew.getAvionList().add(avion);
                tipoANew = em.merge(tipoANew);
            }
            for (Vuelo vueloListNewVuelo : vueloListNew) {
                if (!vueloListOld.contains(vueloListNewVuelo)) {
                    Avion oldAvionOfVueloListNewVuelo = vueloListNewVuelo.getAvion();
                    vueloListNewVuelo.setAvion(avion);
                    vueloListNewVuelo = em.merge(vueloListNewVuelo);
                    if (oldAvionOfVueloListNewVuelo != null && !oldAvionOfVueloListNewVuelo.equals(avion)) {
                        oldAvionOfVueloListNewVuelo.getVueloList().remove(vueloListNewVuelo);
                        oldAvionOfVueloListNewVuelo = em.merge(oldAvionOfVueloListNewVuelo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = avion.getIdentificador();
                if (findAvion(id) == null) {
                    throw new NonexistentEntityException("The avion with id " + id + " no longer exists.");
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
            Avion avion;
            try {
                avion = em.getReference(Avion.class, id);
                avion.getIdentificador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The avion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Vuelo> vueloListOrphanCheck = avion.getVueloList();
            for (Vuelo vueloListOrphanCheckVuelo : vueloListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Avion (" + avion + ") cannot be destroyed since the Vuelo " + vueloListOrphanCheckVuelo + " in its vueloList field has a non-nullable avion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            TipoAvion tipoA = avion.getTipoA();
            if (tipoA != null) {
                tipoA.getAvionList().remove(avion);
                tipoA = em.merge(tipoA);
            }
            em.remove(avion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Avion> findAvionEntities() {
        return findAvionEntities(true, -1, -1);
    }

    public List<Avion> findAvionEntities(int maxResults, int firstResult) {
        return findAvionEntities(false, maxResults, firstResult);
    }

    private List<Avion> findAvionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Avion.class));
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

    public Avion findAvion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Avion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAvionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Avion> rt = cq.from(Avion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
