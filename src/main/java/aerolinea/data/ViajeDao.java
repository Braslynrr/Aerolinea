package aerolinea.data;

import aerolinea.logic.Avion;
import aerolinea.logic.Viaje;
import aerolinea.logic.Vuelo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class ViajeDao  extends ViajeJpaController{

    private ViajeDao() {
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static ViajeDao getInstance() {
        return ViajeDaoHolder.INSTANCE;
    }

    private static class ViajeDaoHolder {
        private static final ViajeDao INSTANCE = new ViajeDao();
    }
    
    public void update(Viaje obj)
   {
       EntityManager em = getEntityManager();
       Viaje object = em.find(Viaje.class, obj.getCodigo());

        em.getTransaction().begin();

        object.setDregreso(obj.getDregreso());
        object.setDsalida(obj.getDsalida());
        object.setIda(obj.getIda());
        object.setRegreso(obj.getRegreso());
        
         em.getTransaction().commit();
         
         em.close();
   }
    
    
    public List<Viaje> SearchViaje(ArrayList<Object> array)
    {
        EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Viaje p WHERE cast(p.ida.identificador as char) like :ida "
      +"AND cast(p.regreso.identificador as char) like :regresov "
      +"AND cast(p.dsalida as char) like :salida "
      +"AND cast(p.dregreso as char) like :regreso"
      )
              
        .setParameter("ida","%"+array.get(0)+"%")
        .setParameter("regresov", "%"+array.get(1)+ "%")
        .setParameter("salida","%"+array.get(2)+"%")
        .setParameter("regreso","%"+array.get(3)+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
    }
 }
