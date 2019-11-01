package aerolinea.logic;

import aerolinea.logic.Avion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-01T02:02:50")
@StaticMetamodel(TipoAvion.class)
public class TipoAvion_ { 

    public static volatile SingularAttribute<TipoAvion, String> marca;
    public static volatile ListAttribute<TipoAvion, Avion> avionList;
    public static volatile SingularAttribute<TipoAvion, Integer> filas;
    public static volatile SingularAttribute<TipoAvion, Integer> asientos;
    public static volatile SingularAttribute<TipoAvion, String> modelo;
    public static volatile SingularAttribute<TipoAvion, String> año;
    public static volatile SingularAttribute<TipoAvion, String> identificador;

}