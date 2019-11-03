package aerolinea.logic;

import aerolinea.logic.Reserva;
import aerolinea.logic.Vuelo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-02T23:39:58")
@StaticMetamodel(Viaje.class)
public class Viaje_ { 

    public static volatile SingularAttribute<Viaje, String> codigo;
    public static volatile SingularAttribute<Viaje, Vuelo> regreso;
    public static volatile ListAttribute<Viaje, Reserva> reservaList;
    public static volatile SingularAttribute<Viaje, Vuelo> ida;
    public static volatile SingularAttribute<Viaje, Date> dregreso;
    public static volatile SingularAttribute<Viaje, Date> dsalida;

}