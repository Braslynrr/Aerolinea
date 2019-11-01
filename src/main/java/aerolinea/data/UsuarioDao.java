package aerolinea.data;

import aerolinea.logic.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

public class UsuarioDao extends UsuarioJpaController {

    private UsuarioDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static UsuarioDao getInstance() {
        return UsuarioDaoHolder.INSTANCE;
    }

    private static class UsuarioDaoHolder {

        private static final UsuarioDao INSTANCE = new UsuarioDao();
    }

    public List<Usuario> Access(String codigo, String password) {
        EntityManager em = getEntityManager();
        try {
            return   em.createQuery("SELECT u FROM Usuario u WHERE u.codigo=:codigo AND u.password=:password")
                    .setParameter("codigo", codigo)
                    .setParameter("password", password)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
