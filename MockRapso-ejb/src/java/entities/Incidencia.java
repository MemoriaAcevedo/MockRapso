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
@Table(name = "incidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i"),
    @NamedQuery(name = "Incidencia.findByIdIncidencia", query = "SELECT i FROM Incidencia i WHERE i.idIncidencia = :idIncidencia"),
    @NamedQuery(name = "Incidencia.findByIdentificadorI", query = "SELECT i FROM Incidencia i WHERE i.identificadorI = :identificadorI"),
    @NamedQuery(name = "Incidencia.findByNombreI", query = "SELECT i FROM Incidencia i WHERE i.nombreI = :nombreI"),
    @NamedQuery(name = "Incidencia.findByDescripcionI", query = "SELECT i FROM Incidencia i WHERE i.descripcionI = :descripcionI"),
    @NamedQuery(name = "Incidencia.findByPasosI", query = "SELECT i FROM Incidencia i WHERE i.pasosI = :pasosI"),
    @NamedQuery(name = "Incidencia.findByResultadoEI", query = "SELECT i FROM Incidencia i WHERE i.resultadoEI = :resultadoEI"),
    @NamedQuery(name = "Incidencia.findByResultadoOI", query = "SELECT i FROM Incidencia i WHERE i.resultadoOI = :resultadoOI"),
    @NamedQuery(name = "Incidencia.findByFechaCI", query = "SELECT i FROM Incidencia i WHERE i.fechaCI = :fechaCI"),
    @NamedQuery(name = "Incidencia.findByFechaEI", query = "SELECT i FROM Incidencia i WHERE i.fechaEI = :fechaEI")})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncidencia")
    private Integer idIncidencia;
    @Size(max = 45)
    @Column(name = "identificadorI")
    private String identificadorI;
    @Size(max = 45)
    @Column(name = "nombreI")
    private String nombreI;
    @Size(max = 200)
    @Column(name = "descripcionI")
    private String descripcionI;
    @Size(max = 500)
    @Column(name = "pasosI")
    private String pasosI;
    @Size(max = 200)
    @Column(name = "resultadoEI")
    private String resultadoEI;
    @Size(max = 200)
    @Column(name = "resultadoOI")
    private String resultadoOI;
    @Column(name = "fechaCI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCI;
    @Column(name = "fechaEI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEI;
    @JoinColumn(name = "EstadoI_idEstadoI", referencedColumnName = "idEstadoI")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estadoi estadoIidEstadoI;
    @JoinColumn(name = "Practica_idPractica", referencedColumnName = "idPractica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Practica practicaidPractica;

    public Incidencia() {
    }

    public Incidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Integer getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getIdentificadorI() {
        return identificadorI;
    }

    public void setIdentificadorI(String identificadorI) {
        this.identificadorI = identificadorI;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public String getDescripcionI() {
        return descripcionI;
    }

    public void setDescripcionI(String descripcionI) {
        this.descripcionI = descripcionI;
    }

    public String getPasosI() {
        return pasosI;
    }

    public void setPasosI(String pasosI) {
        this.pasosI = pasosI;
    }

    public String getResultadoEI() {
        return resultadoEI;
    }

    public void setResultadoEI(String resultadoEI) {
        this.resultadoEI = resultadoEI;
    }

    public String getResultadoOI() {
        return resultadoOI;
    }

    public void setResultadoOI(String resultadoOI) {
        this.resultadoOI = resultadoOI;
    }

    public Date getFechaCI() {
        return fechaCI;
    }

    public void setFechaCI(Date fechaCI) {
        this.fechaCI = fechaCI;
    }

    public Date getFechaEI() {
        return fechaEI;
    }

    public void setFechaEI(Date fechaEI) {
        this.fechaEI = fechaEI;
    }

    public Estadoi getEstadoIidEstadoI() {
        return estadoIidEstadoI;
    }

    public void setEstadoIidEstadoI(Estadoi estadoIidEstadoI) {
        this.estadoIidEstadoI = estadoIidEstadoI;
    }

    public Practica getPracticaidPractica() {
        return practicaidPractica;
    }

    public void setPracticaidPractica(Practica practicaidPractica) {
        this.practicaidPractica = practicaidPractica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncidencia != null ? idIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.idIncidencia == null && other.idIncidencia != null) || (this.idIncidencia != null && !this.idIncidencia.equals(other.idIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Incidencia[ idIncidencia=" + idIncidencia + " ]";
    }
    
}
