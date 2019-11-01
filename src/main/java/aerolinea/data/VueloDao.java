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
 }
