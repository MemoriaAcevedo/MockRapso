package entities;

import entities.Casoprueba;
import entities.Pa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Hu.class)
public class Hu_ { 

    public static volatile SingularAttribute<Hu, String> identificadorHU;
    public static volatile ListAttribute<Hu, Pa> paList;
    public static volatile SingularAttribute<Hu, String> descripcionHU;
    public static volatile ListAttribute<Hu, Casoprueba> casopruebaList;
    public static volatile SingularAttribute<Hu, Integer> idHU;
    public static volatile SingularAttribute<Hu, String> nombreHU;

}