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
            return em.createQuery("SELECT u FROM Usuario u WHERE u.cod like codigo AND u.password like pass")
                    .setParameter("cod", "%"+codigo+"%")
                    .setParameter("pass", "%"+password+"%")
                    .getResultList();
        } finally {
            em.close();
        }
    }

  public List<Usuario> FindUser(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT u FROM Usuario u WHERE u.codigo like :pepito")
        .setParameter("pepito", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  
  
  public void update(Usuario obj)
   {
       EntityManager em = getEntityManager();
       Usuario user = em.find(Usuario.class, obj.getCodigo());

         em.getTransaction().begin();
         user.setNombre(obj.getNombre());
         user.setApellido(obj.getApellido());
         user.setCorreoE(obj.getCorreoE());
         user.setTelefono(obj.getTelefono());
         user.setFnacimiento(obj.getFnacimiento());
         user.setPassword(obj.getPassword());
         user.setDireccion(obj.getDireccion());
         em.getTransaction().commit();
         
         em.close();
   }
}
