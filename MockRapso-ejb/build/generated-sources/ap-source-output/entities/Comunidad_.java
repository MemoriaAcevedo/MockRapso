package entities;

import entities.Comunidadasociado;
import entities.Practica;
import entities.Pruebateorica;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Comunidad.class)
public class Comunidad_ { 

    public static volatile SingularAttribute<Comunidad, Date> fechaEC;
    public static volatile SingularAttribute<Comunidad, Usuario> profesorC;
    public static volatile SingularAttribute<Comunidad, Date> fechaCC;
    public static volatile SingularAttribute<Comunidad, Integer> notaMinima;
    public static volatile ListAttribute<Comunidad, Practica> practicaList;
    public static volatile SingularAttribute<Comunidad, Integer> idComunidad;
    public static volatile ListAttribute<Comunidad, Pruebateorica> pruebateoricaList;
    public static volatile SingularAttribute<Comunidad, String> descripcionC;
    public static volatile ListAttribute<Comunidad, Comunidadasociado> comunidadasociadoList;
    public static volatile SingularAttribute<Comunidad, String> nombreC;

}