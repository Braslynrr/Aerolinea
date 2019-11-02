package aerolinea.data;

public class ReservaDao extends ReservaJpaController{
    
    private ReservaDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }
    
    public static ReservaDao getInstance() {
        return ReservaDaoHolder.INSTANCE;
    }
    
    private static class ReservaDaoHolder {

        private static final ReservaDao INSTANCE = new ReservaDao();
    }
}
