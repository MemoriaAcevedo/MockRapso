package entities;

import entities.Casoprueba;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Estadoc.class)
public class Estadoc_ { 

    public static volatile SingularAttribute<Estadoc, Integer> idEstadoC;
    public static volatile ListAttribute<Estadoc, Casoprueba> casopruebaList;
    public static volatile SingularAttribute<Estadoc, String> nombre;

}