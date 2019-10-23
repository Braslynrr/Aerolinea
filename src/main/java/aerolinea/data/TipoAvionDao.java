package aerolinea.data;

public class TipoAvionDao extends TipoAvionJpaController {
    
    private TipoAvionDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }
    
    public static TipoAvionDao getInstance() {
        return TipoAvionDaoHolder.INSTANCE;
    }
    
    private static class TipoAvionDaoHolder {

        private static final TipoAvionDao INSTANCE = new TipoAvionDao();
    }
}
