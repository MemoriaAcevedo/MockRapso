package entities;

import entities.Comunidad;
import entities.Comunidadasociado;
import entities.Cuenta;
import entities.Estado;
import entities.Mensaje;
import entities.Practica;
import entities.Pruebateorica;
import entities.Tipousuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidoU;
    public static volatile SingularAttribute<Usuario, String> contrasenaU;
    public static volatile SingularAttribute<Usuario, Date> fechaCreacionU;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile ListAttribute<Usuario, Mensaje> mensajeList;
    public static volatile SingularAttribute<Usuario, String> nombreU;
    public static volatile ListAttribute<Usuario, Practica> practicaList;
    public static volatile ListAttribute<Usuario, Pruebateorica> pruebateoricaList;
    public static volatile SingularAttribute<Usuario, String> apodoU;
    public static volatile SingularAttribute<Usuario, String> rutU;
    public static volatile SingularAttribute<Usuario, Date> fechaEdicionU;
    public static volatile SingularAttribute<Usuario, String> respuestaU;
    public static volatile SingularAttribute<Usuario, Estado> estadoidEstado;
    public static volatile SingularAttribute<Usuario, String> motivoC;
    public static volatile ListAttribute<Usuario, Practica> practicaList1;
    public static volatile ListAttribute<Usuario, Comunidad> comunidadList;
    public static volatile SingularAttribute<Usuario, String> preguntaU;
    public static volatile ListAttribute<Usuario, Cuenta> cuentaList;
    public static volatile SingularAttribute<Usuario, String> fotoPerfilU;
    public static volatile SingularAttribute<Usuario, String> emailU;
    public static volatile ListAttribute<Usuario, Comunidadasociado> comunidadasociadoList;
    public static volatile SingularAttribute<Usuario, Tipousuario> tipoUsuarioidTipoUsuario;

}