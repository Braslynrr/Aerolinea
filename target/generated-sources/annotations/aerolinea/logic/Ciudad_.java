package aerolinea.logic;

import aerolinea.logic.Pais;
import aerolinea.logic.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-01T17:32:11")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> codigo;
    public static volatile ListAttribute<Ciudad, Vuelo> vueloList;
    public static volatile ListAttribute<Ciudad, Vuelo> vueloList1;
    public static volatile SingularAttribute<Ciudad, String> nombre;
    public static volatile SingularAttribute<Ciudad, Pais> pais;

}