package aerolinea.logic;

import aerolinea.logic.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-01T22:53:24")
@StaticMetamodel(Tiquete.class)
public class Tiquete_ { 

    public static volatile SingularAttribute<Tiquete, Integer> codigo;
    public static volatile SingularAttribute<Tiquete, String> personaNombre;
    public static volatile SingularAttribute<Tiquete, String> fila;
    public static volatile SingularAttribute<Tiquete, String> asiento;
    public static volatile SingularAttribute<Tiquete, Reserva> reserva;

}