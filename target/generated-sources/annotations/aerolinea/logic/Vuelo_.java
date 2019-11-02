package aerolinea.logic;

import aerolinea.logic.Avion;
import aerolinea.logic.Ciudad;
import aerolinea.logic.Viaje;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-02T15:44:53")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, Double> precio;
    public static volatile SingularAttribute<Vuelo, BigDecimal> descuento;
    public static volatile ListAttribute<Vuelo, Viaje> viajeList1;
    public static volatile SingularAttribute<Vuelo, Date> llegada;
    public static volatile SingularAttribute<Vuelo, Date> duracion;
    public static volatile SingularAttribute<Vuelo, Ciudad> origen;
    public static volatile SingularAttribute<Vuelo, Ciudad> destino;
    public static volatile SingularAttribute<Vuelo, String> dia;
    public static volatile SingularAttribute<Vuelo, Avion> avion;
    public static volatile SingularAttribute<Vuelo, Date> salida;
    public static volatile SingularAttribute<Vuelo, Integer> identificador;
    public static volatile ListAttribute<Vuelo, Viaje> viajeList;

}