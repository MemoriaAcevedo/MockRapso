package entities;

import entities.Practica;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, Integer> idMensaje;
    public static volatile SingularAttribute<Mensaje, Practica> practicaidPractica;
    public static volatile SingularAttribute<Mensaje, Date> fechaRealizado;
    public static volatile SingularAttribute<Mensaje, String> mensaje;
    public static volatile SingularAttribute<Mensaje, Usuario> realizador;

}