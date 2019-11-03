package aerolinea.logic;

import aerolinea.logic.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-02T22:38:52")
@StaticMetamodel(MetodoPago.class)
public class MetodoPago_ { 

    public static volatile SingularAttribute<MetodoPago, String> descripcion;
    public static volatile SingularAttribute<MetodoPago, Integer> codigo;
    public static volatile ListAttribute<MetodoPago, Reserva> reservaList;

}