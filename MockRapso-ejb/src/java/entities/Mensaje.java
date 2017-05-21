/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdMensaje", query = "SELECT m FROM Mensaje m WHERE m.idMensaje = :idMensaje"),
    @NamedQuery(name = "Mensaje.findByMensaje", query = "SELECT m FROM Mensaje m WHERE m.mensaje = :mensaje"),
    @NamedQuery(name = "Mensaje.findByFechaRealizado", query = "SELECT m FROM Mensaje m WHERE m.fechaRealizado = :fechaRealizado")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMensaje")
    private Integer idMensaje;
    @Size(max = 1000)
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fechaRealizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizado;
    @JoinColumn(name = "Practica_idPractica", referencedColumnName = "idPractica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Practica practicaidPractica;
    @JoinColumn(name = "realizador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario realizador;

    public Mensaje() {
    }

    public Mensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public Practica getPracticaidPractica() {
        return practicaidPractica;
    }

    public void setPracticaidPractica(Practica practicaidPractica) {
        this.practicaidPractica = practicaidPractica;
    }

    public Usuario getRealizador() {
        return realizador;
    }

    public void setRealizador(Usuario realizador) {
        this.realizador = realizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mensaje[ idMensaje=" + idMensaje + " ]";
    }
    
}
