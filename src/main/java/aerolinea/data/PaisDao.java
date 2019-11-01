package aerolinea.data;
public class PaisDao extends PaisJpaController {

    private PaisDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static PaisDao getInstance() {
        return PaisDaoHolder.INSTANCE;
    }

    private static class PaisDaoHolder {
        private static final PaisDao INSTANCE = new PaisDao();
    }
 }
