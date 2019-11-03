package aerolinea.logic;

import aerolinea.logic.TipoAvion;
import aerolinea.logic.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-02T22:38:52")
@StaticMetamodel(Avion.class)
public class Avion_ { 

    public static volatile ListAttribute<Avion, Vuelo> vueloList;
    public static volatile SingularAttribute<Avion, TipoAvion> tipoA;
    public static volatile SingularAttribute<Avion, String> identificador;

}