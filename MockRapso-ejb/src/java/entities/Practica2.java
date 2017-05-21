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
@Table(name = "practica2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practica2.findAll", query = "SELECT p FROM Practica2 p"),
    @NamedQuery(name = "Practica2.findByIdPractica2", query = "SELECT p FROM Practica2 p WHERE p.idPractica2 = :idPractica2"),
    @NamedQuery(name = "Practica2.findByFechaInicio", query = "SELECT p FROM Practica2 p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Practica2.findByFechaTermino", query = "SELECT p FROM Practica2 p WHERE p.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Practica2.findByCalificacion", query = "SELECT p FROM Practica2 p WHERE p.calificacion = :calificacion"),
    @NamedQuery(name = "Practica2.findByObservacion", query = "SELECT p FROM Practica2 p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Practica2.findByUrlGithub", query = "SELECT p FROM Practica2 p WHERE p.urlGithub = :urlGithub"),
    @NamedQuery(name = "Practica2.findByUrlCodenvy", query = "SELECT p FROM Practica2 p WHERE p.urlCodenvy = :urlCodenvy"),
    @NamedQuery(name = "Practica2.findByTutorial", query = "SELECT p FROM Practica2 p WHERE p.tutorial = :tutorial")})
public class Practica2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPractica2")
    private Integer idPractica2;
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
    @Size(max = 60)
    @Column(name = "urlGithub")
    private String urlGithub;
    @Size(max = 100)
    @Column(name = "urlCodenvy")
    private String urlCodenvy;
    @Column(name = "tutorial")
    private Boolean tutorial;
    @JoinColumn(name = "practica", referencedColumnName = "idPractica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Practica practica;

    public Practica2() {
    }

    public Practica2(Integer idPractica2) {
        this.idPractica2 = idPractica2;
    }

    public Integer getIdPractica2() {
        return idPractica2;
    }

    public void setIdPractica2(Integer idPractica2) {
        this.idPractica2 = idPractica2;
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

    public String getUrlGithub() {
        return urlGithub;
    }

    public void setUrlGithub(String urlGithub) {
        this.urlGithub = urlGithub;
    }

    public String getUrlCodenvy() {
        return urlCodenvy;
    }

    public void setUrlCodenvy(String urlCodenvy) {
        this.urlCodenvy = urlCodenvy;
    }

    public Boolean getTutorial() {
        return tutorial;
    }

    public void setTutorial(Boolean tutorial) {
        this.tutorial = tutorial;
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
        hash += (idPractica2 != null ? idPractica2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Practica2)) {
            return false;
        }
        Practica2 other = (Practica2) object;
        if ((this.idPractica2 == null && other.idPractica2 != null) || (this.idPractica2 != null && !this.idPractica2.equals(other.idPractica2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Practica2[ idPractica2=" + idPractica2 + " ]";
    }
    
}
