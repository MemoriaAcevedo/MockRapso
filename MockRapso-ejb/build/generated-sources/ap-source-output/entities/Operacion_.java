package entities;

import entities.Cuenta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Operacion.class)
public class Operacion_ { 

    public static volatile SingularAttribute<Operacion, Integer> saldoFinal;
    public static volatile SingularAttribute<Operacion, String> rutR;
    public static volatile SingularAttribute<Operacion, Integer> idO;
    public static volatile SingularAttribute<Operacion, Date> fechaOp;
    public static volatile SingularAttribute<Operacion, String> rutRE;
    public static volatile SingularAttribute<Operacion, String> operacion;
    public static volatile SingularAttribute<Operacion, Integer> montoOp;
    public static volatile SingularAttribute<Operacion, Cuenta> realizador;
    public static volatile SingularAttribute<Operacion, String> tipoO;

}