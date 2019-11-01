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
import aerolinea.logic.MetodoPago;
import aerolinea.logic.Reserva;
import aerolinea.logic.Usuario;
import aerolinea.logic.Viaje;
import aerolinea.logic.Tiquete;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin2
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        if (reserva.getTiqueteList() == null) {
            reserva.setTiqueteList(new ArrayList<Tiquete>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MetodoPago metodoPagoCodigo = reserva.getMetodoPagoCodigo();
            if (metodoPagoCodigo != null) {
                metodoPagoCodigo = em.getReference(metodoPagoCodigo.getClass(), metodoPagoCodigo.getCodigo());
                reserva.setMetodoPagoCodigo(metodoPagoCodigo);
            }
            Usuario usuarioID = reserva.getUsuarioID();
            if (usuarioID != null) {
                usuarioID = em.getReference(usuarioID.getClass(), usuarioID.getCodigo());
                reserva.setUsuarioID(usuarioID);
            }
            Viaje viaje = reserva.getViaje();
            if (viaje != null) {
                viaje = em.getReference(viaje.getClass(), viaje.getCodigo());
                reserva.setViaje(viaje);
            }
            MetodoPago pago = reserva.getPago();
            if (pago != null) {
                pago = em.getReference(pago.getClass(), pago.getCodigo());
                reserva.setPago(pago);
            }
            Usuario usuario = reserva.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getCodigo());
                reserva.setUsuario(usuario);
            }
            List<Tiquete> attachedTiqueteList = new ArrayList<Tiquete>();
            for (Tiquete tiqueteListTiqueteToAttach : reserva.getTiqueteList()) {
                tiqueteListTiqueteToAttach = em.getReference(tiqueteListTiqueteToAttach.getClass(), tiqueteListTiqueteToAttach.getCodigo());
                attachedTiqueteList.add(tiqueteListTiqueteToAttach);
            }
            reserva.setTiqueteList(attachedTiqueteList);
            em.persist(reserva);
            if (metodoPagoCodigo != null) {
                metodoPagoCodigo.getReservaList().add(reserva);
                metodoPagoCodigo = em.merge(metodoPagoCodigo);
            }
            if (usuarioID != null) {
                usuarioID.getReservaList().add(reserva);
                usuarioID = em.merge(usuarioID);
            }
            if (viaje != null) {
                viaje.getReservaList().add(reserva);
                viaje = em.merge(viaje);
            }
            if (pago != null) {
                pago.getReservaList().add(reserva);
                pago = em.merge(pago);
            }
            if (usuario != null) {
                usuario.getReservaList().add(reserva);
                usuario = em.merge(usuario);
            }
            for (Tiquete tiqueteListTiquete : reserva.getTiqueteList()) {
                Reserva oldReservaCodigoOfTiqueteListTiquete = tiqueteListTiquete.getReservaCodigo();
                tiqueteListTiquete.setReservaCodigo(reserva);
                tiqueteListTiquete = em.merge(tiqueteListTiquete);
                if (oldReservaCodigoOfTiqueteListTiquete != null) {
                    oldReservaCodigoOfTiqueteListTiquete.getTiqueteList().remove(tiqueteListTiquete);
                    oldReservaCodigoOfTiqueteListTiquete = em.merge(oldReservaCodigoOfTiqueteListTiquete);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getCodigo());
            MetodoPago metodoPagoCodigoOld = persistentReserva.getMetodoPagoCodigo();
            MetodoPago metodoPagoCodigoNew = reserva.getMetodoPagoCodigo();
            Usuario usuarioIDOld = persistentReserva.getUsuarioID();
            Usuario usuarioIDNew = reserva.getUsuarioID();
            Viaje viajeOld = persistentReserva.getViaje();
            Viaje viajeNew = reserva.getViaje();
            MetodoPago pagoOld = persistentReserva.getPago();
            MetodoPago pagoNew = reserva.getPago();
            Usuario usuarioOld = persistentReserva.getUsuario();
            Usuario usuarioNew = reserva.getUsuario();
            List<Tiquete> tiqueteListOld = persistentReserva.getTiqueteList();
            List<Tiquete> tiqueteListNew = reserva.getTiqueteList();
            List<String> illegalOrphanMessages = null;
            for (Tiquete tiqueteListOldTiquete : tiqueteListOld) {
                if (!tiqueteListNew.contains(tiqueteListOldTiquete)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tiquete " + tiqueteListOldTiquete + " since its reservaCodigo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (metodoPagoCodigoNew != null) {
                metodoPagoCodigoNew = em.getReference(metodoPagoCodigoNew.getClass(), metodoPagoCodigoNew.getCodigo());
                reserva.setMetodoPagoCodigo(metodoPagoCodigoNew);
            }
            if (usuarioIDNew != null) {
                usuarioIDNew = em.getReference(usuarioIDNew.getClass(), usuarioIDNew.getCodigo());
                reserva.setUsuarioID(usuarioIDNew);
            }
            if (viajeNew != null) {
                viajeNew = em.getReference(viajeNew.getClass(), viajeNew.getCodigo());
                reserva.setViaje(viajeNew);
            }
            if (pagoNew != null) {
                pagoNew = em.getReference(pagoNew.getClass(), pagoNew.getCodigo());
                reserva.setPago(pagoNew);
            }
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getCodigo());
                reserva.setUsuario(usuarioNew);
            }
            List<Tiquete> attachedTiqueteListNew = new ArrayList<Tiquete>();
            for (Tiquete tiqueteListNewTiqueteToAttach : tiqueteListNew) {
                tiqueteListNewTiqueteToAttach = em.getReference(tiqueteListNewTiqueteToAttach.getClass(), tiqueteListNewTiqueteToAttach.getCodigo());
                attachedTiqueteListNew.add(tiqueteListNewTiqueteToAttach);
            }
            tiqueteListNew = attachedTiqueteListNew;
            reserva.setTiqueteList(tiqueteListNew);
            reserva = em.merge(reserva);
            if (metodoPagoCodigoOld != null && !metodoPagoCodigoOld.equals(metodoPagoCodigoNew)) {
                metodoPagoCodigoOld.getReservaList().remove(reserva);
                metodoPagoCodigoOld = em.merge(metodoPagoCodigoOld);
            }
            if (metodoPagoCodigoNew != null && !metodoPagoCodigoNew.equals(metodoPagoCodigoOld)) {
                metodoPagoCodigoNew.getReservaList().add(reserva);
                metodoPagoCodigoNew = em.merge(metodoPagoCodigoNew);
            }
            if (usuarioIDOld != null && !usuarioIDOld.equals(usuarioIDNew)) {
                usuarioIDOld.getReservaList().remove(reserva);
                usuarioIDOld = em.merge(usuarioIDOld);
            }
            if (usuarioIDNew != null && !usuarioIDNew.equals(usuarioIDOld)) {
                usuarioIDNew.getReservaList().add(reserva);
                usuarioIDNew = em.merge(usuarioIDNew);
            }
            if (viajeOld != null && !viajeOld.equals(viajeNew)) {
                viajeOld.getReservaList().remove(reserva);
                viajeOld = em.merge(viajeOld);
            }
            if (viajeNew != null && !viajeNew.equals(viajeOld)) {
                viajeNew.getReservaList().add(reserva);
                viajeNew = em.merge(viajeNew);
            }
            if (pagoOld != null && !pagoOld.equals(pagoNew)) {
                pagoOld.getReservaList().remove(reserva);
                pagoOld = em.merge(pagoOld);
            }
            if (pagoNew != null && !pagoNew.equals(pagoOld)) {
                pagoNew.getReservaList().add(reserva);
                pagoNew = em.merge(pagoNew);
            }
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getReservaList().remove(reserva);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getReservaList().add(reserva);
                usuarioNew = em.merge(usuarioNew);
            }
            for (Tiquete tiqueteListNewTiquete : tiqueteListNew) {
                if (!tiqueteListOld.contains(tiqueteListNewTiquete)) {
                    Reserva oldReservaCodigoOfTiqueteListNewTiquete = tiqueteListNewTiquete.getReservaCodigo();
                    tiqueteListNewTiquete.setReservaCodigo(reserva);
                    tiqueteListNewTiquete = em.merge(tiqueteListNewTiquete);
                    if (oldReservaCodigoOfTiqueteListNewTiquete != null && !oldReservaCodigoOfTiqueteListNewTiquete.equals(reserva)) {
                        oldReservaCodigoOfTiqueteListNewTiquete.getTiqueteList().remove(tiqueteListNewTiquete);
                        oldReservaCodigoOfTiqueteListNewTiquete = em.merge(oldReservaCodigoOfTiqueteListNewTiquete);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reserva.getCodigo();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
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
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Tiquete> tiqueteListOrphanCheck = reserva.getTiqueteList();
            for (Tiquete tiqueteListOrphanCheckTiquete : tiqueteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Reserva (" + reserva + ") cannot be destroyed since the Tiquete " + tiqueteListOrphanCheckTiquete + " in its tiqueteList field has a non-nullable reservaCodigo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            MetodoPago metodoPagoCodigo = reserva.getMetodoPagoCodigo();
            if (metodoPagoCodigo != null) {
                metodoPagoCodigo.getReservaList().remove(reserva);
                metodoPagoCodigo = em.merge(metodoPagoCodigo);
            }
            Usuario usuarioID = reserva.getUsuarioID();
            if (usuarioID != null) {
                usuarioID.getReservaList().remove(reserva);
                usuarioID = em.merge(usuarioID);
            }
            Viaje viaje = reserva.getViaje();
            if (viaje != null) {
                viaje.getReservaList().remove(reserva);
                viaje = em.merge(viaje);
            }
            MetodoPago pago = reserva.getPago();
            if (pago != null) {
                pago.getReservaList().remove(reserva);
                pago = em.merge(pago);
            }
            Usuario usuario = reserva.getUsuario();
            if (usuario != null) {
                usuario.getReservaList().remove(reserva);
                usuario = em.merge(usuario);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
