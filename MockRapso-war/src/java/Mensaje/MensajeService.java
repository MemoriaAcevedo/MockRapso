/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensaje;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@XmlRootElement
public class MensajeService {
    @XmlElement public int idP;
    @XmlElement public String mensaje;
    @XmlElement public String tipo;
}
