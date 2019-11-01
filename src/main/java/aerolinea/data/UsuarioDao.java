package aerolinea.data;

public class UsuarioDao extends UsuarioJpaController{
    
    private UsuarioDao() {
         super(PersistenceManager.getInstance().getEntityManagerFactory());
    }
    
    public static UsuarioDao getInstance() {
        return UsuarioDaoHolder.INSTANCE;
    }
    
    private static class UsuarioDaoHolder {
        private static final UsuarioDao INSTANCE = new UsuarioDao();
    }
}
