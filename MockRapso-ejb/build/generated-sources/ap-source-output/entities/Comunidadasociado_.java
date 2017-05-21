package entities;

import entities.Comunidad;
import entities.ComunidadasociadoPK;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Comunidadasociado.class)
public class Comunidadasociado_ { 

    public static volatile SingularAttribute<Comunidadasociado, Boolean> accesoPractica;
    public static volatile SingularAttribute<Comunidadasociado, ComunidadasociadoPK> comunidadasociadoPK;
    public static volatile SingularAttribute<Comunidadasociado, Usuario> usuario;
    public static volatile SingularAttribute<Comunidadasociado, Date> fechaAsociacion;
    public static volatile SingularAttribute<Comunidadasociado, Comunidad> comunidad;

}