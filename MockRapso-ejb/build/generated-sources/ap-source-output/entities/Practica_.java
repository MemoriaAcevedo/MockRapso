package entities;

import entities.Casoprueba;
import entities.Comunidad;
import entities.Estadop;
import entities.Incidencia;
import entities.Mensaje;
import entities.Practica1;
import entities.Practica2;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Practica.class)
public class Practica_ { 

    public static volatile SingularAttribute<Practica, Comunidad> comunidadidComunidad;
    public static volatile SingularAttribute<Practica, Integer> calificacion;
    public static volatile SingularAttribute<Practica, Estadop> estadoPidEstadoP;
    public static volatile SingularAttribute<Practica, String> identificadorPractica;
    public static volatile SingularAttribute<Practica, Date> fechaTermino;
    public static volatile ListAttribute<Practica, Mensaje> mensajeList;
    public static volatile SingularAttribute<Practica, Usuario> corrector;
    public static volatile SingularAttribute<Practica, Usuario> realizador;
    public static volatile ListAttribute<Practica, Incidencia> incidenciaList;
    public static volatile SingularAttribute<Practica, Date> fechaInicio;
    public static volatile ListAttribute<Practica, Practica2> practica2List;
    public static volatile ListAttribute<Practica, Casoprueba> casopruebaList;
    public static volatile ListAttribute<Practica, Practica1> practica1List;
    public static volatile SingularAttribute<Practica, Integer> idPractica;

}