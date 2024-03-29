package aerolinea.logic;

import aerolinea.data.AvionDao;
import aerolinea.data.CiudadDao;
import aerolinea.data.MetodoPagoDao;
import aerolinea.data.PaisDao;
import aerolinea.data.TipoAvionDao;
import aerolinea.data.VueloDao;
import aerolinea.exceptions.IllegalOrphanException;
import aerolinea.exceptions.NonexistentEntityException;
import java.util.List;

public class Modelo {

    private Modelo() {
    }

    public static Modelo getInstance() {
        return ModeloHolder.INSTANCE;
    }

    private static class ModeloHolder {
        private static final Modelo INSTANCE = new Modelo();
    }
    
    // Tipos de avion metodos...............
    
    public void Eliminar(TipoAvion object) throws NonexistentEntityException, IllegalOrphanException
    {
        TipoAvionDao.getInstance().destroy(object.getIdentificador());
    }
    
    public List<TipoAvion> GetLista()
    {
      return  TipoAvionDao.getInstance().findTipoAvionEntities();
    }
    
    public List<TipoAvion> Search(String search, int index)
    {
        switch(index)
        {
            case 0:  return TipoAvionDao.getInstance().findTipoAvionEntities();
         
            case 1:  return TipoAvionDao.getInstance().findByIdentifier(search);
  
            case 2:  return TipoAvionDao.getInstance().findByAño(search);
    
            case 3:  return TipoAvionDao.getInstance().findByModelo(search);
 
            case 4:  return TipoAvionDao.getInstance().findByMarca(search);

            case 5:  return TipoAvionDao.getInstance().findByAsientos(search);
    
            case 6:  return TipoAvionDao.getInstance().findByFilas(search);
        }
        return null;
    }     
        public List<TipoAvion> GetAll()
        {
            return TipoAvionDao.getInstance().findTipoAvionEntities();
        }
        
        public void Añadir(TipoAvion object) throws Exception
    {
        TipoAvionDao.getInstance().create(object);

    }
    
    public void Modifcar(TipoAvion object) throws Exception
    {
        TipoAvionDao.getInstance().update(object);

    }

        //END tipoaviones
        
        //Codigos para Aviones
        
        
        public void Eliminar(Avion object) throws NonexistentEntityException, IllegalOrphanException
    {
        AvionDao.getInstance().destroy(object.getIdentificador());
    }
    
    public List<Avion> GetListaAviones()
    {
      return  AvionDao.getInstance().findAvionEntities();
    }
    
    public List<Avion> SearchAvion(String search, int index)
    {
        switch(index)
        {
            case 0:  return AvionDao.getInstance().findAvionEntities();
         
            case 1:  return AvionDao.getInstance().findByIdentifier(search);
  
            case 2:  return AvionDao.getInstance().findByTipoAvion(search);
    
            case 3:  return AvionDao.getInstance().findByModelo(search);
 
            case 4:  return AvionDao.getInstance().findByAño(search);
        }
        return null;
    }     
        public List<Avion> GetAllAviones()
        {
            return AvionDao.getInstance().findAvionEntities();
        }
        
        public void Añadir(Avion object) throws Exception
    {
        AvionDao.getInstance().create(object);

    }
    
    public void Modifcar(Avion object) throws Exception
    {
        AvionDao.getInstance().edit(object);

    }
    
    // END AVIONES
    
    // INICIO PAISES  
    
    public void Eliminar(Pais object) throws NonexistentEntityException, IllegalOrphanException
    {
        PaisDao.getInstance().destroy(object.getCodigo());
    }
    
    public List<Pais> GetListaPais()
    {
      return  PaisDao.getInstance().findPaisEntities();
    }
    
    public List<Pais> SearchPais(String search, int index)
    {
        switch(index)
        {
            case 0:  return PaisDao.getInstance().findPaisEntities();
         
            case 1:  return PaisDao.getInstance().findByCodigo(search);
  
            case 2:  return PaisDao.getInstance().findByNombre(search);
   
        }
        return null;
    }     
        public List<Pais> GetAllPais()
        {
            return PaisDao.getInstance().findPaisEntities();
        }
        
        public void Añadir(Pais object) throws Exception
    {
        PaisDao.getInstance().create(object);

    }
    
    public void Modifcar(Pais object) throws Exception
    {
        PaisDao.getInstance().update(object);

    }
    
    // END PAISES
    
    // INICIO CIUDADES  
    
    public void Eliminar(Ciudad object) throws NonexistentEntityException, IllegalOrphanException
    {
        CiudadDao.getInstance().destroy(object.getCodigo());
    }
    
    public List<Ciudad> GetListaCiudad()
    {
      return  CiudadDao.getInstance().findCiudadEntities();
    }
    
    public List<Ciudad> SearchCiudad(String search, int index)
    {
        switch(index)
        {
            case 0:  return CiudadDao.getInstance().findCiudadEntities();
         
            case 1:  return CiudadDao.getInstance().findByCodigo(search);
  
            case 2:  return CiudadDao.getInstance().findByNombre(search);
            
            case 3: return CiudadDao.getInstance().findByPais(search);
   
        }
        return null;
    }     
        public List<Ciudad> GetAllCiudad()
        {
            return CiudadDao.getInstance().findCiudadEntities();
        }
        
        public void Añadir(Ciudad object) throws Exception
    {
        CiudadDao.getInstance().create(object);

    }
    
    public void Modifcar(Ciudad object) throws Exception
    {
        CiudadDao.getInstance().edit(object);

    }
    
     // END CIUDADES
    
    // INICIO METODOS DE PAGO
    
    public void Eliminar(MetodoPago object) throws NonexistentEntityException, IllegalOrphanException
    {
        MetodoPagoDao.getInstance().destroy(object.getCodigo());
    }
    
    public List<MetodoPago> GetListaMetodos()
    {
      return  MetodoPagoDao.getInstance().findMetodoPagoEntities();
    }
    
    public List<MetodoPago> SearchMetodo(String search, int index)
    {
        switch(index)
        {
            case 0:  return MetodoPagoDao.getInstance().findMetodoPagoEntities();
         
            case 1:  return MetodoPagoDao.getInstance().findByCodigo(search);
  
            case 2:  return MetodoPagoDao.getInstance().findByDescripcion(search);
   
        }
        return null;
    }     
        public List<MetodoPago> GetAllMetodos()
        {
            return MetodoPagoDao.getInstance().findMetodoPagoEntities();
        }
        
        public void Añadir(MetodoPago object) throws Exception
    {
        MetodoPagoDao.getInstance().create(object);
        

    }
    
    public void Modifcar(MetodoPago object) throws Exception
    {
        MetodoPagoDao.getInstance().edit(object);

    }
    
    // Inicio vuelos
    
    public void Eliminar(Vuelo object) throws NonexistentEntityException, IllegalOrphanException
    {
//        VueloDao.getInstance().clearCache(object);
        VueloDao.getInstance().destroy(object.getIdentificador());
        
    }
    
    public List<Vuelo> GetListaVuelos()
    {
      return  VueloDao.getInstance().findVueloEntities();
    }
    
    public List<Vuelo> SearchVuelo(String search, int index)
    {
//        switch(index)
//        {
//            case 0:  return TipoAvionDao.getInstance().findTipoAvionEntities();
//         
//            case 1:  return TipoAvionDao.getInstance().findByIdentifier(search);
//  
//            case 2:  return TipoAvionDao.getInstance().findByAño(search);
//    
//            case 3:  return TipoAvionDao.getInstance().findByModelo(search);
// 
//            case 4:  return TipoAvionDao.getInstance().findByMarca(search);
//
//            case 5:  return TipoAvionDao.getInstance().findByAsientos(search);
//    
//            case 6:  return TipoAvionDao.getInstance().findByFilas(search);
//        }
        return null;
    }     
        public List<Vuelo> GetAllVuelo()
        {
            return VueloDao.getInstance().findVueloEntities();
        }
        
        public void Añadir(Vuelo object) throws Exception
    {
        VueloDao.getInstance().create(object);
        VueloDao.getInstance().clearCache(object);
        

    }
    
    public void Modifcar(Vuelo object) throws Exception
    {
        VueloDao.getInstance().edit(object);
        VueloDao.getInstance().clearCache(object);

    }
 }
