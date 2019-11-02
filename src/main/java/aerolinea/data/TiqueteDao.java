package aerolinea.data;

public class TiqueteDao {
    
    private TiqueteDao() {
    }
    
    public static TiqueteDao getInstance() {
        return TiqueteDaoHolder.INSTANCE;
    }
    
    private static class TiqueteDaoHolder {

        private static final TiqueteDao INSTANCE = new TiqueteDao();
    }
    
    
    
}
