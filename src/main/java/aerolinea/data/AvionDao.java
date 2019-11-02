package aerolinea.data;

import aerolinea.logic.Avion;
import java.util.List;
import javax.persistence.EntityManager;

public class AvionDao  extends AvionJpaController {

    private AvionDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static AvionDao getInstance() {
        return AvionDaoHolder.INSTANCE;
    }

    private static class AvionDaoHolder {
        private static final AvionDao INSTANCE = new AvionDao();
    }
    
    public List<Avion> findByIdentifier(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Avion p WHERE p.identificador like :pepito")
        .setParameter("pepito", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
    public List<Avion> findByTipoAvion(String identifier)
    {
        EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Avion p WHERE p.tipoA.marca like :variable")
        .setParameter("variable",identifier)
        .getResultList();
    }
    finally
    {
      em.close();
    }
    }
    
    public List<Avion> findByModelo(String identifier)
    {
        EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Avion p WHERE p.tipoA.modelo like :variable")
        .setParameter("variable",identifier)
        .getResultList();
    }
    finally
    {
      em.close();
    }
    }
    
    public List<Avion> findByAño(String identifier)
    {
        EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Avion p WHERE p.tipoA.año like :variable")
        .setParameter("variable",identifier)
        .getResultList();
    }
    finally
    {
      em.close();
    }
    }
    
    public void update(Avion obj)
   {
       EntityManager em = getEntityManager();
       Avion avion = em.find(Avion.class, obj.getIdentificador());

        em.getTransaction().begin();

         avion.setTipoA(obj.getTipoA());
         em.getTransaction().commit();
         
         em.close();
   }
    
    
 }
