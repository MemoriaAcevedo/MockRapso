package entities;

import entities.Areapregunta;
import entities.Areareforzar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, String> nombreArea;
    public static volatile ListAttribute<Area, Areapregunta> areapreguntaList;
    public static volatile ListAttribute<Area, Areareforzar> areareforzarList;
    public static volatile SingularAttribute<Area, Integer> idArea;

}