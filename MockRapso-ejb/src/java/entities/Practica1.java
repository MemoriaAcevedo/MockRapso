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
@Table(name = "practica1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practica1.findAll", query = "SELECT p FROM Practica1 p"),
    @NamedQuery(name = "Practica1.findByIdPractica1", query = "SELECT p FROM Practica1 p WHERE p.idPractica1 = :idPractica1"),
    @NamedQuery(name = "Practica1.findByFechaInicio", query = "SELECT p FROM Practica1 p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Practica1.findByFechaTermino", query = "SELECT p FROM Practica1 p WHERE p.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Practica1.findByCalificacion", query = "SELECT p FROM Practica1 p WHERE p.calificacion = :calificacion"),
    @NamedQuery(name = "Practica1.findByObservacion", query = "SELECT p FROM Practica1 p WHERE p.observacion = :observacion")})
public class Practica1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPractica1")
    private Integer idPractica1;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fechaTermino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Size(max = 1000)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "practica", referencedColumnName = "idPractica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Practica practica;

    public Practica1() {
    }

    public Practica1(Integer idPractica1) {
        this.idPractica1 = idPractica1;
    }

    public Integer getIdPractica1() {
        return idPractica1;
    }

    public void setIdPractica1(Integer idPractica1) {
        this.idPractica1 = idPractica1;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPractica1 != null ? idPractica1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Practica1)) {
            return false;
        }
        Practica1 other = (Practica1) object;
        if ((this.idPractica1 == null && other.idPractica1 != null) || (this.idPractica1 != null && !this.idPractica1.equals(other.idPractica1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Practica1[ idPractica1=" + idPractica1 + " ]";
    }
    
}
