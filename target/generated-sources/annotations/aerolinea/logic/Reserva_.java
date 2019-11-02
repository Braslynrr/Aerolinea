package aerolinea.logic;

import aerolinea.logic.MetodoPago;
import aerolinea.logic.Tiquete;
import aerolinea.logic.Usuario;
import aerolinea.logic.Viaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-02T15:21:35")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Integer> codigo;
    public static volatile ListAttribute<Reserva, Tiquete> tiqueteList;
    public static volatile SingularAttribute<Reserva, Viaje> viaje;
    public static volatile SingularAttribute<Reserva, Usuario> usuario;
    public static volatile SingularAttribute<Reserva, MetodoPago> pago;

}