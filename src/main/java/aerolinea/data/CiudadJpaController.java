/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import aerolinea.exceptions.PreexistingEntityException;
import aerolinea.logic.Ciudad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import aerolinea.logic.Pais;
import aerolinea.logic.Vuelo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin2
 */
public class CiudadJpaController implements Serializable {

    public CiudadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ciudad ciudad) throws PreexistingEntityException, Exception {
        if (ciudad.getVueloList() == null) {
            ciudad.setVueloList(new ArrayList<Vuelo>());
        }
        if (ciudad.getVueloList1() == null) {
            ciudad.setVueloList1(new ArrayList<Vuelo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pais pais = ciudad.getPais();
            if (pais != null) {
                pais = em.getReference(pais.getClass(), pais.getCodigo());
                ciudad.setPais(pais);
            }
            List<Vuelo> attachedVueloList = new ArrayList<Vuelo>();
            for (Vuelo vueloListVueloToAttach : ciudad.getVueloList()) {
                vueloListVueloToAttach = em.getReference(vueloListVueloToAttach.getClass(), vueloListVueloToAttach.getIdentificador());
                attachedVueloList.add(vueloListVueloToAttach);
            }
            ciudad.setVueloList(attachedVueloList);
            List<Vuelo> attachedVueloList1 = new ArrayList<Vuelo>();
            for (Vuelo vueloList1VueloToAttach : ciudad.getVueloList1()) {
                vueloList1VueloToAttach = em.getReference(vueloList1VueloToAttach.getClass(), vueloList1VueloToAttach.getIdentificador());
                attachedVueloList1.add(vueloList1VueloToAttach);
            }
            ciudad.setVueloList1(attachedVueloList1);
            em.persist(ciudad);
            if (pais != null) {
                pais.getCiudadList().add(ciudad);
                pais = em.merge(pais);
            }
            for (Vuelo vueloListVuelo : ciudad.getVueloList()) {
                Ciudad oldOrigenOfVueloListVuelo = vueloListVuelo.getOrigen();
                vueloListVuelo.setOrigen(ciudad);
                vueloListVuelo = em.merge(vueloListVuelo);
                if (oldOrigenOfVueloListVuelo != null) {
                    oldOrigenOfVueloListVuelo.getVueloList().remove(vueloListVuelo);
                    oldOrigenOfVueloListVuelo = em.merge(oldOrigenOfVueloListVuelo);
                }
            }
            for (Vuelo vueloList1Vuelo : ciudad.getVueloList1()) {
                Ciudad oldDestinoOfVueloList1Vuelo = vueloList1Vuelo.getDestino();
                vueloList1Vuelo.setDestino(ciudad);
                vueloList1Vuelo = em.merge(vueloList1Vuelo);
                if (oldDestinoOfVueloList1Vuelo != null) {
                    oldDestinoOfVueloList1Vuelo.getVueloList1().remove(vueloList1Vuelo);
                    oldDestinoOfVueloList1Vuelo = em.merge(oldDestinoOfVueloList1Vuelo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCiudad(ciudad.getCodigo()) != null) {
                throw new PreexistingEntityException("Ciudad " + ciudad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ciudad ciudad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad persistentCiudad = em.find(Ciudad.class, ciudad.getCodigo());
            Pais paisOld = persistentCiudad.getPais();
            Pais paisNew = ciudad.getPais();
            List<Vuelo> vueloListOld = persistentCiudad.getVueloList();
            List<Vuelo> vueloListNew = ciudad.getVueloList();
            List<Vuelo> vueloList1Old = persistentCiudad.getVueloList1();
            List<Vuelo> vueloList1New = ciudad.getVueloList1();
            List<String> illegalOrphanMessages = null;
            for (Vuelo vueloListOldVuelo : vueloListOld) {
                if (!vueloListNew.contains(vueloListOldVuelo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vuelo " + vueloListOldVuelo + " since its origen field is not nullable.");
                }
            }
            for (Vuelo vueloList1OldVuelo : vueloList1Old) {
                if (!vueloList1New.contains(vueloList1OldVuelo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vuelo " + vueloList1OldVuelo + " since its destino field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (paisNew != null) {
                paisNew = em.getReference(paisNew.getClass(), paisNew.getCodigo());
                ciudad.setPais(paisNew);
            }
            List<Vuelo> attachedVueloListNew = new ArrayList<Vuelo>();
            for (Vuelo vueloListNewVueloToAttach : vueloListNew) {
                vueloListNewVueloToAttach = em.getReference(vueloListNewVueloToAttach.getClass(), vueloListNewVueloToAttach.getIdentificador());
                attachedVueloListNew.add(vueloListNewVueloToAttach);
            }
            vueloListNew = attachedVueloListNew;
            ciudad.setVueloList(vueloListNew);
            List<Vuelo> attachedVueloList1New = new ArrayList<Vuelo>();
            for (Vuelo vueloList1NewVueloToAttach : vueloList1New) {
                vueloList1NewVueloToAttach = em.getReference(vueloList1NewVueloToAttach.getClass(), vueloList1NewVueloToAttach.getIdentificador());
                attachedVueloList1New.add(vueloList1NewVueloToAttach);
            }
            vueloList1New = attachedVueloList1New;
            ciudad.setVueloList1(vueloList1New);
            ciudad = em.merge(ciudad);
            if (paisOld != null && !paisOld.equals(paisNew)) {
                paisOld.getCiudadList().remove(ciudad);
                paisOld = em.merge(paisOld);
            }
            if (paisNew != null && !paisNew.equals(paisOld)) {
                paisNew.getCiudadList().add(ciudad);
                paisNew = em.merge(paisNew);
            }
            for (Vuelo vueloListNewVuelo : vueloListNew) {
                if (!vueloListOld.contains(vueloListNewVuelo)) {
                    Ciudad oldOrigenOfVueloListNewVuelo = vueloListNewVuelo.getOrigen();
                    vueloListNewVuelo.setOrigen(ciudad);
                    vueloListNewVuelo = em.merge(vueloListNewVuelo);
                    if (oldOrigenOfVueloListNewVuelo != null && !oldOrigenOfVueloListNewVuelo.equals(ciudad)) {
                        oldOrigenOfVueloListNewVuelo.getVueloList().remove(vueloListNewVuelo);
                        oldOrigenOfVueloListNewVuelo = em.merge(oldOrigenOfVueloListNewVuelo);
                    }
                }
            }
            for (Vuelo vueloList1NewVuelo : vueloList1New) {
                if (!vueloList1Old.contains(vueloList1NewVuelo)) {
                    Ciudad oldDestinoOfVueloList1NewVuelo = vueloList1NewVuelo.getDestino();
                    vueloList1NewVuelo.setDestino(ciudad);
                    vueloList1NewVuelo = em.merge(vueloList1NewVuelo);
                    if (oldDestinoOfVueloList1NewVuelo != null && !oldDestinoOfVueloList1NewVuelo.equals(ciudad)) {
                        oldDestinoOfVueloList1NewVuelo.getVueloList1().remove(vueloList1NewVuelo);
                        oldDestinoOfVueloList1NewVuelo = em.merge(oldDestinoOfVueloList1NewVuelo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ciudad.getCodigo();
                if (findCiudad(id) == null) {
                    throw new NonexistentEntityException("The ciudad with id " + id + " no longer exists.");
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
            Ciudad ciudad;
            try {
                ciudad = em.getReference(Ciudad.class, id);
                ciudad.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Vuelo> vueloListOrphanCheck = ciudad.getVueloList();
            for (Vuelo vueloListOrphanCheckVuelo : vueloListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ciudad (" + ciudad + ") cannot be destroyed since the Vuelo " + vueloListOrphanCheckVuelo + " in its vueloList field has a non-nullable origen field.");
            }
            List<Vuelo> vueloList1OrphanCheck = ciudad.getVueloList1();
            for (Vuelo vueloList1OrphanCheckVuelo : vueloList1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ciudad (" + ciudad + ") cannot be destroyed since the Vuelo " + vueloList1OrphanCheckVuelo + " in its vueloList1 field has a non-nullable destino field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pais pais = ciudad.getPais();
            if (pais != null) {
                pais.getCiudadList().remove(ciudad);
                pais = em.merge(pais);
            }
            em.remove(ciudad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ciudad> findCiudadEntities() {
        return findCiudadEntities(true, -1, -1);
    }

    public List<Ciudad> findCiudadEntities(int maxResults, int firstResult) {
        return findCiudadEntities(false, maxResults, firstResult);
    }

    private List<Ciudad> findCiudadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciudad.class));
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

    public Ciudad findCiudad(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciudad.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiudadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciudad> rt = cq.from(Ciudad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
