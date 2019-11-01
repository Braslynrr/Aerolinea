package aerolinea.data;

import aerolinea.logic.Pais;
import aerolinea.logic.TipoAvion;
import java.util.List;
import javax.persistence.EntityManager;

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
    
    public void update(Pais obj)
   {
       EntityManager em = getEntityManager();
       Pais pais = em.find(Pais.class, obj.getCodigo());

        em.getTransaction().begin();
        pais.setNombre(obj.getNombre());
        
         em.getTransaction().commit();
         
         em.close();
   }
    
    public List<Pais> findByCodigo(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Pais p WHERE p.codigo like :variable")
        .setParameter("variable", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
    
    public List<Pais> findByNombre(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Pais p WHERE p.nombre like :variable")
        .setParameter("variable", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
 }
