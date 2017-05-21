package entities;

import entities.Practica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Practica1.class)
public class Practica1_ { 

    public static volatile SingularAttribute<Practica1, Integer> calificacion;
    public static volatile SingularAttribute<Practica1, Date> fechaInicio;
    public static volatile SingularAttribute<Practica1, Date> fechaTermino;
    public static volatile SingularAttribute<Practica1, Integer> idPractica1;
    public static volatile SingularAttribute<Practica1, String> observacion;
    public static volatile SingularAttribute<Practica1, Practica> practica;

}