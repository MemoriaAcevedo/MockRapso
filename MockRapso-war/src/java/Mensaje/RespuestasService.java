/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensaje;

import entities.Pregunta;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@XmlRootElement
public class RespuestasService {
    @XmlElement public List<Pregunta> respuestas;
    @XmlElement public int idComunidad;
    @XmlElement public int idAlumno;
}
