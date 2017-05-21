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
@Table(name = "incidenciacp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidenciacp.findAll", query = "SELECT i FROM Incidenciacp i"),
    @NamedQuery(name = "Incidenciacp.findByIdIncidenciacp", query = "SELECT i FROM Incidenciacp i WHERE i.idIncidenciacp = :idIncidenciacp"),
    @NamedQuery(name = "Incidenciacp.findByIdentificadorICP", query = "SELECT i FROM Incidenciacp i WHERE i.identificadorICP = :identificadorICP"),
    @NamedQuery(name = "Incidenciacp.findByNombreICP", query = "SELECT i FROM Incidenciacp i WHERE i.nombreICP = :nombreICP"),
    @NamedQuery(name = "Incidenciacp.findByDescripcionICP", query = "SELECT i FROM Incidenciacp i WHERE i.descripcionICP = :descripcionICP"),
    @NamedQuery(name = "Incidenciacp.findByPasosICP", query = "SELECT i FROM Incidenciacp i WHERE i.pasosICP = :pasosICP"),
    @NamedQuery(name = "Incidenciacp.findByResultadoEICP", query = "SELECT i FROM Incidenciacp i WHERE i.resultadoEICP = :resultadoEICP"),
    @NamedQuery(name = "Incidenciacp.findByResultadoOICP", query = "SELECT i FROM Incidenciacp i WHERE i.resultadoOICP = :resultadoOICP"),
    @NamedQuery(name = "Incidenciacp.findByFechaCICP", query = "SELECT i FROM Incidenciacp i WHERE i.fechaCICP = :fechaCICP"),
    @NamedQuery(name = "Incidenciacp.findByFechaE", query = "SELECT i FROM Incidenciacp i WHERE i.fechaE = :fechaE")})
public class Incidenciacp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncidenciacp")
    private Integer idIncidenciacp;
    @Size(max = 45)
    @Column(name = "identificadorICP")
    private String identificadorICP;
    @Size(max = 45)
    @Column(name = "nombreICP")
    private String nombreICP;
    @Size(max = 200)
    @Column(name = "descripcionICP")
    private String descripcionICP;
    @Size(max = 500)
    @Column(name = "pasosICP")
    private String pasosICP;
    @Size(max = 200)
    @Column(name = "resultadoEICP")
    private String resultadoEICP;
    @Size(max = 200)
    @Column(name = "resultadoOICP")
    private String resultadoOICP;
    @Column(name = "fechaCICP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCICP;
    @Column(name = "fechaE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaE;
    @JoinColumn(name = "CasoPrueba_idCp", referencedColumnName = "idCp")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Casoprueba casoPruebaidCp;
    @JoinColumn(name = "EstadoI_idEstadoI", referencedColumnName = "idEstadoI")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estadoi estadoIidEstadoI;

    public Incidenciacp() {
    }

    public Incidenciacp(Integer idIncidenciacp) {
        this.idIncidenciacp = idIncidenciacp;
    }

    public Integer getIdIncidenciacp() {
        return idIncidenciacp;
    }

    public void setIdIncidenciacp(Integer idIncidenciacp) {
        this.idIncidenciacp = idIncidenciacp;
    }

    public String getIdentificadorICP() {
        return identificadorICP;
    }

    public void setIdentificadorICP(String identificadorICP) {
        this.identificadorICP = identificadorICP;
    }

    public String getNombreICP() {
        return nombreICP;
    }

    public void setNombreICP(String nombreICP) {
        this.nombreICP = nombreICP;
    }

    public String getDescripcionICP() {
        return descripcionICP;
    }

    public void setDescripcionICP(String descripcionICP) {
        this.descripcionICP = descripcionICP;
    }

    public String getPasosICP() {
        return pasosICP;
    }

    public void setPasosICP(String pasosICP) {
        this.pasosICP = pasosICP;
    }

    public String getResultadoEICP() {
        return resultadoEICP;
    }

    public void setResultadoEICP(String resultadoEICP) {
        this.resultadoEICP = resultadoEICP;
    }

    public String getResultadoOICP() {
        return resultadoOICP;
    }

    public void setResultadoOICP(String resultadoOICP) {
        this.resultadoOICP = resultadoOICP;
    }

    public Date getFechaCICP() {
        return fechaCICP;
    }

    public void setFechaCICP(Date fechaCICP) {
        this.fechaCICP = fechaCICP;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
    }

    public Casoprueba getCasoPruebaidCp() {
        return casoPruebaidCp;
    }

    public void setCasoPruebaidCp(Casoprueba casoPruebaidCp) {
        this.casoPruebaidCp = casoPruebaidCp;
    }

    public Estadoi getEstadoIidEstadoI() {
        return estadoIidEstadoI;
    }

    public void setEstadoIidEstadoI(Estadoi estadoIidEstadoI) {
        this.estadoIidEstadoI = estadoIidEstadoI;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncidenciacp != null ? idIncidenciacp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidenciacp)) {
            return false;
        }
        Incidenciacp other = (Incidenciacp) object;
        if ((this.idIncidenciacp == null && other.idIncidenciacp != null) || (this.idIncidenciacp != null && !this.idIncidenciacp.equals(other.idIncidenciacp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Incidenciacp[ idIncidenciacp=" + idIncidenciacp + " ]";
    }
    
}
