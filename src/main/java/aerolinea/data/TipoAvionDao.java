package aerolinea.data;

import aerolinea.logic.TipoAvion;
import java.util.List;
import javax.persistence.EntityManager;

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
    
   public List<TipoAvion> findByIdentifier(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM TipoAvion p WHERE p.identificador like :pepito")
        .setParameter("pepito", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
    
     public void update(TipoAvion obj)
   {
       EntityManager em = getEntityManager();
       TipoAvion avion = em.find(TipoAvion.class, obj.getIdentificador());

        em.getTransaction().begin();
         avion.setAño(obj.getAño());
         avion.setModelo(obj.getModelo());
         avion.setMarca(obj.getMarca());
         avion.setAsientos(obj.getAsientos());
         avion.setFilas(obj.getFilas());
         em.getTransaction().commit();
         
         em.close();
   }
     
     public List<TipoAvion> findByAño(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM TipoAvion p WHERE p.año like :pepito")
        .setParameter("pepito", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
     
     public List<TipoAvion> findByModelo(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM TipoAvion p WHERE p.modelo like :pepito")
        .setParameter("pepito", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
     
     public List<TipoAvion> findByMarca(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM TipoAvion p WHERE p.marca like :pepito")
        .setParameter("pepito", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
     
     
     public List<TipoAvion> findByFilas(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM TipoAvion p WHERE cast(p.filas as char) like :year")
        .setParameter("year", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
     
     public List<TipoAvion> findByAsientos(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM TipoAvion p WHERE cast(p.asientos as char) like :year")
        .setParameter("year", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
}


