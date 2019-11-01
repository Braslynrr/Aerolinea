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
import aerolinea.logic.Vuelo;
import aerolinea.logic.Reserva;
import aerolinea.logic.Viaje;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin2
 */
public class ViajeJpaController implements Serializable {

    public ViajeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Viaje viaje) throws PreexistingEntityException, Exception {
        if (viaje.getReservaList() == null) {
            viaje.setReservaList(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vuelo ida = viaje.getIda();
            if (ida != null) {
                ida = em.getReference(ida.getClass(), ida.getIdentificador());
                viaje.setIda(ida);
            }
            Vuelo regreso = viaje.getRegreso();
            if (regreso != null) {
                regreso = em.getReference(regreso.getClass(), regreso.getIdentificador());
                viaje.setRegreso(regreso);
            }
            List<Reserva> attachedReservaList = new ArrayList<Reserva>();
            for (Reserva reservaListReservaToAttach : viaje.getReservaList()) {
                reservaListReservaToAttach = em.getReference(reservaListReservaToAttach.getClass(), reservaListReservaToAttach.getCodigo());
                attachedReservaList.add(reservaListReservaToAttach);
            }
            viaje.setReservaList(attachedReservaList);
            em.persist(viaje);
            if (ida != null) {
                ida.getViajeList().add(viaje);
                ida = em.merge(ida);
            }
            if (regreso != null) {
                regreso.getViajeList().add(viaje);
                regreso = em.merge(regreso);
            }
            for (Reserva reservaListReserva : viaje.getReservaList()) {
                Viaje oldViajeOfReservaListReserva = reservaListReserva.getViaje();
                reservaListReserva.setViaje(viaje);
                reservaListReserva = em.merge(reservaListReserva);
                if (oldViajeOfReservaListReserva != null) {
                    oldViajeOfReservaListReserva.getReservaList().remove(reservaListReserva);
                    oldViajeOfReservaListReserva = em.merge(oldViajeOfReservaListReserva);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViaje(viaje.getCodigo()) != null) {
                throw new PreexistingEntityException("Viaje " + viaje + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Viaje viaje) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Viaje persistentViaje = em.find(Viaje.class, viaje.getCodigo());
            Vuelo idaOld = persistentViaje.getIda();
            Vuelo idaNew = viaje.getIda();
            Vuelo regresoOld = persistentViaje.getRegreso();
            Vuelo regresoNew = viaje.getRegreso();
            List<Reserva> reservaListOld = persistentViaje.getReservaList();
            List<Reserva> reservaListNew = viaje.getReservaList();
            List<String> illegalOrphanMessages = null;
            for (Reserva reservaListOldReserva : reservaListOld) {
                if (!reservaListNew.contains(reservaListOldReserva)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reserva " + reservaListOldReserva + " since its viaje field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idaNew != null) {
                idaNew = em.getReference(idaNew.getClass(), idaNew.getIdentificador());
                viaje.setIda(idaNew);
            }
            if (regresoNew != null) {
                regresoNew = em.getReference(regresoNew.getClass(), regresoNew.getIdentificador());
                viaje.setRegreso(regresoNew);
            }
            List<Reserva> attachedReservaListNew = new ArrayList<Reserva>();
            for (Reserva reservaListNewReservaToAttach : reservaListNew) {
                reservaListNewReservaToAttach = em.getReference(reservaListNewReservaToAttach.getClass(), reservaListNewReservaToAttach.getCodigo());
                attachedReservaListNew.add(reservaListNewReservaToAttach);
            }
            reservaListNew = attachedReservaListNew;
            viaje.setReservaList(reservaListNew);
            viaje = em.merge(viaje);
            if (idaOld != null && !idaOld.equals(idaNew)) {
                idaOld.getViajeList().remove(viaje);
                idaOld = em.merge(idaOld);
            }
            if (idaNew != null && !idaNew.equals(idaOld)) {
                idaNew.getViajeList().add(viaje);
                idaNew = em.merge(idaNew);
            }
            if (regresoOld != null && !regresoOld.equals(regresoNew)) {
                regresoOld.getViajeList().remove(viaje);
                regresoOld = em.merge(regresoOld);
            }
            if (regresoNew != null && !regresoNew.equals(regresoOld)) {
                regresoNew.getViajeList().add(viaje);
                regresoNew = em.merge(regresoNew);
            }
            for (Reserva reservaListNewReserva : reservaListNew) {
                if (!reservaListOld.contains(reservaListNewReserva)) {
                    Viaje oldViajeOfReservaListNewReserva = reservaListNewReserva.getViaje();
                    reservaListNewReserva.setViaje(viaje);
                    reservaListNewReserva = em.merge(reservaListNewReserva);
                    if (oldViajeOfReservaListNewReserva != null && !oldViajeOfReservaListNewReserva.equals(viaje)) {
                        oldViajeOfReservaListNewReserva.getReservaList().remove(reservaListNewReserva);
                        oldViajeOfReservaListNewReserva = em.merge(oldViajeOfReservaListNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = viaje.getCodigo();
                if (findViaje(id) == null) {
                    throw new NonexistentEntityException("The viaje with id " + id + " no longer exists.");
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
            Viaje viaje;
            try {
                viaje = em.getReference(Viaje.class, id);
                viaje.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viaje with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Reserva> reservaListOrphanCheck = viaje.getReservaList();
            for (Reserva reservaListOrphanCheckReserva : reservaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Viaje (" + viaje + ") cannot be destroyed since the Reserva " + reservaListOrphanCheckReserva + " in its reservaList field has a non-nullable viaje field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Vuelo ida = viaje.getIda();
            if (ida != null) {
                ida.getViajeList().remove(viaje);
                ida = em.merge(ida);
            }
            Vuelo regreso = viaje.getRegreso();
            if (regreso != null) {
                regreso.getViajeList().remove(viaje);
                regreso = em.merge(regreso);
            }
            em.remove(viaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Viaje> findViajeEntities() {
        return findViajeEntities(true, -1, -1);
    }

    public List<Viaje> findViajeEntities(int maxResults, int firstResult) {
        return findViajeEntities(false, maxResults, firstResult);
    }

    private List<Viaje> findViajeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Viaje.class));
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

    public Viaje findViaje(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Viaje.class, id);
        } finally {
            em.close();
        }
    }

    public int getViajeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Viaje> rt = cq.from(Viaje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
