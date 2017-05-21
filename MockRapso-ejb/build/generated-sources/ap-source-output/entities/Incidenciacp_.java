package entities;

import entities.Casoprueba;
import entities.Estadoi;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Incidenciacp.class)
public class Incidenciacp_ { 

    public static volatile SingularAttribute<Incidenciacp, String> resultadoEICP;
    public static volatile SingularAttribute<Incidenciacp, Estadoi> estadoIidEstadoI;
    public static volatile SingularAttribute<Incidenciacp, Date> fechaCICP;
    public static volatile SingularAttribute<Incidenciacp, String> resultadoOICP;
    public static volatile SingularAttribute<Incidenciacp, Date> fechaE;
    public static volatile SingularAttribute<Incidenciacp, String> identificadorICP;
    public static volatile SingularAttribute<Incidenciacp, String> descripcionICP;
    public static volatile SingularAttribute<Incidenciacp, String> nombreICP;
    public static volatile SingularAttribute<Incidenciacp, Casoprueba> casoPruebaidCp;
    public static volatile SingularAttribute<Incidenciacp, Integer> idIncidenciacp;
    public static volatile SingularAttribute<Incidenciacp, String> pasosICP;

}