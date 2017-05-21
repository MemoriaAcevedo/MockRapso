package entities;

import entities.Areapregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T15:54:11")
@StaticMetamodel(Pregunta.class)
public class Pregunta_ { 

    public static volatile ListAttribute<Pregunta, Areapregunta> areapreguntaList;
    public static volatile SingularAttribute<Pregunta, String> respuesta;
    public static volatile SingularAttribute<Pregunta, Integer> idPregunta;
    public static volatile SingularAttribute<Pregunta, String> pregunta;

}