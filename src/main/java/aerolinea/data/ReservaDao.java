package aerolinea.data;

import aerolinea.logic.Reserva;
import java.util.List;
import javax.persistence.EntityManager;

public class ReservaDao extends ReservaJpaController {

    private ReservaDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static ReservaDao getInstance() {
        return ReservaDaoHolder.INSTANCE;
    }

    private static class ReservaDaoHolder {

        private static final ReservaDao INSTANCE = new ReservaDao();
    }

    public List<Reserva> getReservasViaje(String codigo) {

        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Reserva r WHERE r.viaje.codigo like :viaj")
                    .setParameter("viaj", "%" + codigo + "%")
                    .getResultList();
        } finally {
            em.close();
        }

    }
    
    public List<Reserva> getReservasViaje(String viaje,String user){
         EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Reserva r WHERE r.viaje.codigo like :viaj AND r.usuario.codigo like :user")
                    .setParameter("viaj", "%" + viaje + "%")
                    .setParameter("user", "%"+user+"%")
                    .getResultList();
        } finally {
            em.close();
        }

    }
    
}
