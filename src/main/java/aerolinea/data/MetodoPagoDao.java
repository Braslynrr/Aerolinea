package aerolinea.data;

import aerolinea.logic.MetodoPago;
import java.util.List;
import javax.persistence.EntityManager;

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
    
    public List<MetodoPago> findByCodigo(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM MetodoPago p WHERE cast(p.codigo as char) like :variable")
        .setParameter("variable", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
    
    public List<MetodoPago> findByDescripcion(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM MetodoPago p WHERE p.descripcion like :variable")
        .setParameter("variable", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
 }
