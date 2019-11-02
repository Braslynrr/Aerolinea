package aerolinea.data;

import aerolinea.logic.Vuelo;
import javax.persistence.EntityManager;

public class VueloDao  extends VueloJpaController  {

    private VueloDao(){
        super(PersistenceManager.getInstance().getEntityManagerFactory());
    }

    public static VueloDao getInstance() {
        return VueloDaoHolder.INSTANCE;
    }

    private static class VueloDaoHolder {
        private static final VueloDao INSTANCE = new VueloDao();
    }
    
    public void clearCache(Vuelo object) 
    {
        EntityManager em = getEntityManager();
        try 
        {
            em.getEntityManagerFactory().getCache().evictAll();
        }
        finally
        {
            em.close();
        }
    }
    
    public void update(Vuelo obj)
   {
       EntityManager em = getEntityManager();
       Vuelo vuelo = em.find(Vuelo.class, obj.getIdentificador());

        em.getTransaction().begin();

        vuelo.setDescuento(obj.getDescuento());
        vuelo.setDia("");
        vuelo.setAvion(obj.getAvion());
        vuelo.setDestino(obj.getDestino());
        vuelo.setDia(obj.getDia());
        vuelo.setDuracion(obj.getDuracion());
        vuelo.setOrigen(obj.getOrigen());
        vuelo.setPrecio(obj.getPrecio());
        vuelo.setSalida(obj.getSalida());
         em.getTransaction().commit();
         
         em.close();
   }
    
 }
