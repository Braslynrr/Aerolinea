/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import aerolinea.logic.Avion;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Viaje;
import aerolinea.logic.Vuelo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin2
 */
public class VueloJpaController implements Serializable {

    public VueloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vuelo vuelo) {
        if (vuelo.getViajeList() == null) {
            vuelo.setViajeList(new ArrayList<Viaje>());
        }
        if (vuelo.getViajeList1() == null) {
            vuelo.setViajeList1(new ArrayList<Viaje>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Avion avion = vuelo.getAvion();
            if (avion != null) {
                avion = em.getReference(avion.getClass(), avion.getIdentificador());
                vuelo.setAvion(avion);
            }
            Ciudad origen = vuelo.getOrigen();
            if (origen != null) {
                origen = em.getReference(origen.getClass(), origen.getCodigo());
                vuelo.setOrigen(origen);
            }
            Ciudad destino = vuelo.getDestino();
            if (destino != null) {
                destino = em.getReference(destino.getClass(), destino.getCodigo());
                vuelo.setDestino(destino);
            }
            List<Viaje> attachedViajeList = new ArrayList<Viaje>();
            for (Viaje viajeListViajeToAttach : vuelo.getViajeList()) {
                viajeListViajeToAttach = em.getReference(viajeListViajeToAttach.getClass(), viajeListViajeToAttach.getCodigo());
                attachedViajeList.add(viajeListViajeToAttach);
            }
            vuelo.setViajeList(attachedViajeList);
            List<Viaje> attachedViajeList1 = new ArrayList<Viaje>();
            for (Viaje viajeList1ViajeToAttach : vuelo.getViajeList1()) {
                viajeList1ViajeToAttach = em.getReference(viajeList1ViajeToAttach.getClass(), viajeList1ViajeToAttach.getCodigo());
                attachedViajeList1.add(viajeList1ViajeToAttach);
            }
            vuelo.setViajeList1(attachedViajeList1);
            em.persist(vuelo);
            if (avion != null) {
                avion.getVueloList().add(vuelo);
                avion = em.merge(avion);
            }
            if (origen != null) {
                origen.getVueloList().add(vuelo);
                origen = em.merge(origen);
            }
            if (destino != null) {
                destino.getVueloList().add(vuelo);
                destino = em.merge(destino);
            }
            for (Viaje viajeListViaje : vuelo.getViajeList()) {
                Vuelo oldIdaOfViajeListViaje = viajeListViaje.getIda();
                viajeListViaje.setIda(vuelo);
                viajeListViaje = em.merge(viajeListViaje);
                if (oldIdaOfViajeListViaje != null) {
                    oldIdaOfViajeListViaje.getViajeList().remove(viajeListViaje);
                    oldIdaOfViajeListViaje = em.merge(oldIdaOfViajeListViaje);
                }
            }
            for (Viaje viajeList1Viaje : vuelo.getViajeList1()) {
                Vuelo oldRegresoOfViajeList1Viaje = viajeList1Viaje.getRegreso();
                viajeList1Viaje.setRegreso(vuelo);
                viajeList1Viaje = em.merge(viajeList1Viaje);
                if (oldRegresoOfViajeList1Viaje != null) {
                    oldRegresoOfViajeList1Viaje.getViajeList1().remove(viajeList1Viaje);
                    oldRegresoOfViajeList1Viaje = em.merge(oldRegresoOfViajeList1Viaje);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vuelo vuelo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vuelo persistentVuelo = em.find(Vuelo.class, vuelo.getIdentificador());
            Avion avionOld = persistentVuelo.getAvion();
            Avion avionNew = vuelo.getAvion();
            Ciudad origenOld = persistentVuelo.getOrigen();
            Ciudad origenNew = vuelo.getOrigen();
            Ciudad destinoOld = persistentVuelo.getDestino();
            Ciudad destinoNew = vuelo.getDestino();
            List<Viaje> viajeListOld = persistentVuelo.getViajeList();
            List<Viaje> viajeListNew = vuelo.getViajeList();
            List<Viaje> viajeList1Old = persistentVuelo.getViajeList1();
            List<Viaje> viajeList1New = vuelo.getViajeList1();
            List<String> illegalOrphanMessages = null;
            for (Viaje viajeListOldViaje : viajeListOld) {
                if (!viajeListNew.contains(viajeListOldViaje)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Viaje " + viajeListOldViaje + " since its ida field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (avionNew != null) {
                avionNew = em.getReference(avionNew.getClass(), avionNew.getIdentificador());
                vuelo.setAvion(avionNew);
            }
            if (origenNew != null) {
                origenNew = em.getReference(origenNew.getClass(), origenNew.getCodigo());
                vuelo.setOrigen(origenNew);
            }
            if (destinoNew != null) {
                destinoNew = em.getReference(destinoNew.getClass(), destinoNew.getCodigo());
                vuelo.setDestino(destinoNew);
            }
            List<Viaje> attachedViajeListNew = new ArrayList<Viaje>();
            for (Viaje viajeListNewViajeToAttach : viajeListNew) {
                viajeListNewViajeToAttach = em.getReference(viajeListNewViajeToAttach.getClass(), viajeListNewViajeToAttach.getCodigo());
                attachedViajeListNew.add(viajeListNewViajeToAttach);
            }
            viajeListNew = attachedViajeListNew;
            vuelo.setViajeList(viajeListNew);
            List<Viaje> attachedViajeList1New = new ArrayList<Viaje>();
            for (Viaje viajeList1NewViajeToAttach : viajeList1New) {
                viajeList1NewViajeToAttach = em.getReference(viajeList1NewViajeToAttach.getClass(), viajeList1NewViajeToAttach.getCodigo());
                attachedViajeList1New.add(viajeList1NewViajeToAttach);
            }
            viajeList1New = attachedViajeList1New;
            vuelo.setViajeList1(viajeList1New);
            vuelo = em.merge(vuelo);
            if (avionOld != null && !avionOld.equals(avionNew)) {
                avionOld.getVueloList().remove(vuelo);
                avionOld = em.merge(avionOld);
            }
            if (avionNew != null && !avionNew.equals(avionOld)) {
                avionNew.getVueloList().add(vuelo);
                avionNew = em.merge(avionNew);
            }
            if (origenOld != null && !origenOld.equals(origenNew)) {
                origenOld.getVueloList().remove(vuelo);
                origenOld = em.merge(origenOld);
            }
            if (origenNew != null && !origenNew.equals(origenOld)) {
                origenNew.getVueloList().add(vuelo);
                origenNew = em.merge(origenNew);
            }
            if (destinoOld != null && !destinoOld.equals(destinoNew)) {
                destinoOld.getVueloList().remove(vuelo);
                destinoOld = em.merge(destinoOld);
            }
            if (destinoNew != null && !destinoNew.equals(destinoOld)) {
                destinoNew.getVueloList().add(vuelo);
                destinoNew = em.merge(destinoNew);
            }
            for (Viaje viajeListNewViaje : viajeListNew) {
                if (!viajeListOld.contains(viajeListNewViaje)) {
                    Vuelo oldIdaOfViajeListNewViaje = viajeListNewViaje.getIda();
                    viajeListNewViaje.setIda(vuelo);
                    viajeListNewViaje = em.merge(viajeListNewViaje);
                    if (oldIdaOfViajeListNewViaje != null && !oldIdaOfViajeListNewViaje.equals(vuelo)) {
                        oldIdaOfViajeListNewViaje.getViajeList().remove(viajeListNewViaje);
                        oldIdaOfViajeListNewViaje = em.merge(oldIdaOfViajeListNewViaje);
                    }
                }
            }
            for (Viaje viajeList1OldViaje : viajeList1Old) {
                if (!viajeList1New.contains(viajeList1OldViaje)) {
                    viajeList1OldViaje.setRegreso(null);
                    viajeList1OldViaje = em.merge(viajeList1OldViaje);
                }
            }
            for (Viaje viajeList1NewViaje : viajeList1New) {
                if (!viajeList1Old.contains(viajeList1NewViaje)) {
                    Vuelo oldRegresoOfViajeList1NewViaje = viajeList1NewViaje.getRegreso();
                    viajeList1NewViaje.setRegreso(vuelo);
                    viajeList1NewViaje = em.merge(viajeList1NewViaje);
                    if (oldRegresoOfViajeList1NewViaje != null && !oldRegresoOfViajeList1NewViaje.equals(vuelo)) {
                        oldRegresoOfViajeList1NewViaje.getViajeList1().remove(viajeList1NewViaje);
                        oldRegresoOfViajeList1NewViaje = em.merge(oldRegresoOfViajeList1NewViaje);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vuelo.getIdentificador();
                if (findVuelo(id) == null) {
                    throw new NonexistentEntityException("The vuelo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vuelo vuelo;
            try {
                vuelo = em.getReference(Vuelo.class, id);
                vuelo.getIdentificador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vuelo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Viaje> viajeListOrphanCheck = vuelo.getViajeList();
            for (Viaje viajeListOrphanCheckViaje : viajeListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vuelo (" + vuelo + ") cannot be destroyed since the Viaje " + viajeListOrphanCheckViaje + " in its viajeList field has a non-nullable ida field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Avion avion = vuelo.getAvion();
            if (avion != null) {
                avion.getVueloList().remove(vuelo);
                avion = em.merge(avion);
            }
            Ciudad origen = vuelo.getOrigen();
            if (origen != null) {
                origen.getVueloList().remove(vuelo);
                origen = em.merge(origen);
            }
            Ciudad destino = vuelo.getDestino();
            if (destino != null) {
                destino.getVueloList().remove(vuelo);
                destino = em.merge(destino);
            }
            List<Viaje> viajeList1 = vuelo.getViajeList1();
            for (Viaje viajeList1Viaje : viajeList1) {
                viajeList1Viaje.setRegreso(null);
                viajeList1Viaje = em.merge(viajeList1Viaje);
            }
            em.remove(vuelo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vuelo> findVueloEntities() {
        return findVueloEntities(true, -1, -1);
    }

    public List<Vuelo> findVueloEntities(int maxResults, int firstResult) {
        return findVueloEntities(false, maxResults, firstResult);
    }

    private List<Vuelo> findVueloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vuelo.class));
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

    public Vuelo findVuelo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vuelo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVueloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vuelo> rt = cq.from(Vuelo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
