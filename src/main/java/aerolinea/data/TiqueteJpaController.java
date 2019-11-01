/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.data;

import aerolinea.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import aerolinea.logic.Reserva;
import aerolinea.logic.Tiquete;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin2
 */
public class TiqueteJpaController implements Serializable {

    public TiqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tiquete tiquete) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reservaCodigo = tiquete.getReservaCodigo();
            if (reservaCodigo != null) {
                reservaCodigo = em.getReference(reservaCodigo.getClass(), reservaCodigo.getCodigo());
                tiquete.setReservaCodigo(reservaCodigo);
            }
            Reserva reserva = tiquete.getReserva();
            if (reserva != null) {
                reserva = em.getReference(reserva.getClass(), reserva.getCodigo());
                tiquete.setReserva(reserva);
            }
            em.persist(tiquete);
            if (reservaCodigo != null) {
                reservaCodigo.getTiqueteList().add(tiquete);
                reservaCodigo = em.merge(reservaCodigo);
            }
            if (reserva != null) {
                reserva.getTiqueteList().add(tiquete);
                reserva = em.merge(reserva);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tiquete tiquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tiquete persistentTiquete = em.find(Tiquete.class, tiquete.getCodigo());
            Reserva reservaCodigoOld = persistentTiquete.getReservaCodigo();
            Reserva reservaCodigoNew = tiquete.getReservaCodigo();
            Reserva reservaOld = persistentTiquete.getReserva();
            Reserva reservaNew = tiquete.getReserva();
            if (reservaCodigoNew != null) {
                reservaCodigoNew = em.getReference(reservaCodigoNew.getClass(), reservaCodigoNew.getCodigo());
                tiquete.setReservaCodigo(reservaCodigoNew);
            }
            if (reservaNew != null) {
                reservaNew = em.getReference(reservaNew.getClass(), reservaNew.getCodigo());
                tiquete.setReserva(reservaNew);
            }
            tiquete = em.merge(tiquete);
            if (reservaCodigoOld != null && !reservaCodigoOld.equals(reservaCodigoNew)) {
                reservaCodigoOld.getTiqueteList().remove(tiquete);
                reservaCodigoOld = em.merge(reservaCodigoOld);
            }
            if (reservaCodigoNew != null && !reservaCodigoNew.equals(reservaCodigoOld)) {
                reservaCodigoNew.getTiqueteList().add(tiquete);
                reservaCodigoNew = em.merge(reservaCodigoNew);
            }
            if (reservaOld != null && !reservaOld.equals(reservaNew)) {
                reservaOld.getTiqueteList().remove(tiquete);
                reservaOld = em.merge(reservaOld);
            }
            if (reservaNew != null && !reservaNew.equals(reservaOld)) {
                reservaNew.getTiqueteList().add(tiquete);
                reservaNew = em.merge(reservaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tiquete.getCodigo();
                if (findTiquete(id) == null) {
                    throw new NonexistentEntityException("The tiquete with id " + id + " no longer exists.");
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
            Tiquete tiquete;
            try {
                tiquete = em.getReference(Tiquete.class, id);
                tiquete.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiquete with id " + id + " no longer exists.", enfe);
            }
            Reserva reservaCodigo = tiquete.getReservaCodigo();
            if (reservaCodigo != null) {
                reservaCodigo.getTiqueteList().remove(tiquete);
                reservaCodigo = em.merge(reservaCodigo);
            }
            Reserva reserva = tiquete.getReserva();
            if (reserva != null) {
                reserva.getTiqueteList().remove(tiquete);
                reserva = em.merge(reserva);
            }
            em.remove(tiquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tiquete> findTiqueteEntities() {
        return findTiqueteEntities(true, -1, -1);
    }

    public List<Tiquete> findTiqueteEntities(int maxResults, int firstResult) {
        return findTiqueteEntities(false, maxResults, firstResult);
    }

    private List<Tiquete> findTiqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tiquete.class));
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

    public Tiquete findTiquete(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tiquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tiquete> rt = cq.from(Tiquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
