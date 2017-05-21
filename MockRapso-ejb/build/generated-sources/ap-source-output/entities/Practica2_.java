package entities;

import entities.Practica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Practica2.class)
public class Practica2_ { 

    public static volatile SingularAttribute<Practica2, String> urlCodenvy;
    public static volatile SingularAttribute<Practica2, String> urlGithub;
    public static volatile SingularAttribute<Practica2, Integer> calificacion;
    public static volatile SingularAttribute<Practica2, Date> fechaInicio;
    public static volatile SingularAttribute<Practica2, Integer> idPractica2;
    public static volatile SingularAttribute<Practica2, Date> fechaTermino;
    public static volatile SingularAttribute<Practica2, Boolean> tutorial;
    public static volatile SingularAttribute<Practica2, String> observacion;
    public static volatile SingularAttribute<Practica2, Practica> practica;

}