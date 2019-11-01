package aerolinea.data;
public class MetodoPagoDao extends MetodoPagoJpaController{

    private MetodoPagoDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static MetodoPagoDao getInstance() {
        return MetodoPagoDaoHolder.INSTANCE;
    }

    private static class MetodoPagoDaoHolder {
        private static final MetodoPagoDao INSTANCE = new MetodoPagoDao();
    }
 }
