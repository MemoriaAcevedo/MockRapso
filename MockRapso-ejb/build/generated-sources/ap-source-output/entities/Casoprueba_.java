package entities;

import entities.Estadoc;
import entities.Hu;
import entities.Incidenciacp;
import entities.Practica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Casoprueba.class)
public class Casoprueba_ { 

    public static volatile SingularAttribute<Casoprueba, String> identificadorCaso;
    public static volatile SingularAttribute<Casoprueba, String> descripcion;
    public static volatile SingularAttribute<Casoprueba, String> precondicion;
    public static volatile SingularAttribute<Casoprueba, Hu> hUidHU;
    public static volatile SingularAttribute<Casoprueba, Date> fechaE;
    public static volatile SingularAttribute<Casoprueba, Date> fechaC;
    public static volatile SingularAttribute<Casoprueba, String> nombre;
    public static volatile SingularAttribute<Casoprueba, Estadoc> estadoCidEstadoC;
    public static volatile SingularAttribute<Casoprueba, String> resultadosE;
    public static volatile SingularAttribute<Casoprueba, Practica> practicaidPractica;
    public static volatile SingularAttribute<Casoprueba, Integer> idCp;
    public static volatile SingularAttribute<Casoprueba, String> resultadosO;
    public static volatile ListAttribute<Casoprueba, Incidenciacp> incidenciacpList;
    public static volatile SingularAttribute<Casoprueba, String> pasos;

}