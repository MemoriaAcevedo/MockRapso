package entities;

import entities.Estadoi;
import entities.Practica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Incidencia.class)
public class Incidencia_ { 

    public static volatile SingularAttribute<Incidencia, Integer> idIncidencia;
    public static volatile SingularAttribute<Incidencia, Estadoi> estadoIidEstadoI;
    public static volatile SingularAttribute<Incidencia, String> resultadoEI;
    public static volatile SingularAttribute<Incidencia, Practica> practicaidPractica;
    public static volatile SingularAttribute<Incidencia, String> nombreI;
    public static volatile SingularAttribute<Incidencia, String> descripcionI;
    public static volatile SingularAttribute<Incidencia, String> pasosI;
    public static volatile SingularAttribute<Incidencia, String> resultadoOI;
    public static volatile SingularAttribute<Incidencia, Date> fechaEI;
    public static volatile SingularAttribute<Incidencia, String> identificadorI;
    public static volatile SingularAttribute<Incidencia, Date> fechaCI;

}