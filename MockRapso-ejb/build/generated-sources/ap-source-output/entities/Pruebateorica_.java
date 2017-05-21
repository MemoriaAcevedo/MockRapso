package entities;

import entities.Areareforzar;
import entities.Comunidad;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Pruebateorica.class)
public class Pruebateorica_ { 

    public static volatile ListAttribute<Pruebateorica, Areareforzar> areareforzarList;
    public static volatile SingularAttribute<Pruebateorica, Usuario> usuarioRealizador;
    public static volatile SingularAttribute<Pruebateorica, Date> fechaRealizado;
    public static volatile SingularAttribute<Pruebateorica, Integer> nota;
    public static volatile SingularAttribute<Pruebateorica, Integer> idPT;
    public static volatile SingularAttribute<Pruebateorica, Comunidad> comunidad;

}