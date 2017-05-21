package entities;

import entities.Incidencia;
import entities.Incidenciacp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Estadoi.class)
public class Estadoi_ { 

    public static volatile ListAttribute<Estadoi, Incidencia> incidenciaList;
    public static volatile SingularAttribute<Estadoi, Integer> idEstadoI;
    public static volatile SingularAttribute<Estadoi, String> nombre;
    public static volatile ListAttribute<Estadoi, Incidenciacp> incidenciacpList;

}