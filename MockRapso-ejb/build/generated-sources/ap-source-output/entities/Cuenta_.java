package entities;

import entities.Operacion;
import entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile ListAttribute<Cuenta, Operacion> operacionList;
    public static volatile SingularAttribute<Cuenta, Integer> idC;
    public static volatile SingularAttribute<Cuenta, String> tipoC;
    public static volatile SingularAttribute<Cuenta, Usuario> idU;
    public static volatile SingularAttribute<Cuenta, Integer> saldoC;
    public static volatile SingularAttribute<Cuenta, Boolean> estadoC;

}