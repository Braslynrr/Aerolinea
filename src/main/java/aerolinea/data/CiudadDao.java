package aerolinea.data;

import aerolinea.logic.Ciudad;
import java.util.List;
import javax.persistence.EntityManager;

public class CiudadDao extends CiudadJpaController {

    private CiudadDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static CiudadDao getInstance() {
        return CiudadDaoHolder.INSTANCE;
    }

    private static class CiudadDaoHolder {
        private static final CiudadDao INSTANCE = new CiudadDao();
    }
    
    public List<Ciudad> findByCodigo(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Ciudad p WHERE p.codigo like :variable")
        .setParameter("variable", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
    
    public List<Ciudad> findByNombre(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Ciudad p WHERE p.nombre like :variable")
        .setParameter("variable", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
    
    public List<Ciudad> findByPais(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Ciudad p WHERE p.pais.nombre like :var")
        .setParameter("var", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
 }
