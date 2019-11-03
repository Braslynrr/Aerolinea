package aerolinea.data;

import aerolinea.logic.Tiquete;
import java.util.List;
import javax.persistence.EntityManager;

public class TiqueteDao extends TiqueteJpaController {

    private TiqueteDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static TiqueteDao getInstance() {
        return TiqueteDaoHolder.INSTANCE;
    }

    private static class TiqueteDaoHolder {

        private static final TiqueteDao INSTANCE = new TiqueteDao();
    }
    
    
    
    public  List<Tiquete> findTikectReserva(int code){
        
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Tiquete t WHERE t.reserva like :code ")
                    .setParameter("code", "%"+code+"%" )
                    .getResultList();
        } finally {
             em.close();
        }
    }

    public List<Tiquete> findAsiento(String code ,int fila, int asiento) {

        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Tiquete t WHERE t.codigo like :code "
                    + "AND t.fila like :Fil "
                    + "AND t.asiento like :Asi")
                    .setParameter("Fil","%"+fila+"%" )
                    .setParameter("Asi","%"+ asiento+"%")
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
