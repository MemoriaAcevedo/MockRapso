/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "casoprueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casoprueba.findAll", query = "SELECT c FROM Casoprueba c"),
    @NamedQuery(name = "Casoprueba.findByIdCp", query = "SELECT c FROM Casoprueba c WHERE c.idCp = :idCp"),
    @NamedQuery(name = "Casoprueba.findByIdentificadorCaso", query = "SELECT c FROM Casoprueba c WHERE c.identificadorCaso = :identificadorCaso"),
    @NamedQuery(name = "Casoprueba.findByNombre", query = "SELECT c FROM Casoprueba c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Casoprueba.findByDescripcion", query = "SELECT c FROM Casoprueba c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Casoprueba.findByPrecondicion", query = "SELECT c FROM Casoprueba c WHERE c.precondicion = :precondicion"),
    @NamedQuery(name = "Casoprueba.findByPasos", query = "SELECT c FROM Casoprueba c WHERE c.pasos = :pasos"),
    @NamedQuery(name = "Casoprueba.findByResultadosE", query = "SELECT c FROM Casoprueba c WHERE c.resultadosE = :resultadosE"),
    @NamedQuery(name = "Casoprueba.findByResultadosO", query = "SELECT c FROM Casoprueba c WHERE c.resultadosO = :resultadosO"),
    @NamedQuery(name = "Casoprueba.findByFechaC", query = "SELECT c FROM Casoprueba c WHERE c.fechaC = :fechaC"),
    @NamedQuery(name = "Casoprueba.findByFechaE", query = "SELECT c FROM Casoprueba c WHERE c.fechaE = :fechaE")})
public class Casoprueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCp")
    private Integer idCp;
    @Size(max = 45)
    @Column(name = "identificadorCaso")
    private String identificadorCaso;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 300)
    @Column(name = "precondicion")
    private String precondicion;
    @Size(max = 500)
    @Column(name = "pasos")
    private String pasos;
    @Size(max = 300)
    @Column(name = "resultadosE")
    private String resultadosE;
    @Size(max = 300)
    @Column(name = "resultadosO")
    private String resultadosO;
    @Column(name = "fechaC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaC;
    @Column(name = "fechaE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaE;
    @JoinColumn(name = "EstadoC_idEstadoC", referencedColumnName = "idEstadoC")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estadoc estadoCidEstadoC;
    @JoinColumn(name = "HU_idHU", referencedColumnName = "idHU")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Hu hUidHU;
    @JoinColumn(name = "Practica_idPractica", referencedColumnName = "idPractica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Practica practicaidPractica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "casoPruebaidCp", fetch = FetchType.EAGER)
    private List<Incidenciacp> incidenciacpList;

    public Casoprueba() {
    }

    public Casoprueba(Integer idCp) {
        this.idCp = idCp;
    }

    public Integer getIdCp() {
        return idCp;
    }

    public void setIdCp(Integer idCp) {
        this.idCp = idCp;
    }

    public String getIdentificadorCaso() {
        return identificadorCaso;
    }

    public void setIdentificadorCaso(String identificadorCaso) {
        this.identificadorCaso = identificadorCaso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecondicion() {
        return precondicion;
    }

    public void setPrecondicion(String precondicion) {
        this.precondicion = precondicion;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getResultadosE() {
        return resultadosE;
    }

    public void setResultadosE(String resultadosE) {
        this.resultadosE = resultadosE;
    }

    public String getResultadosO() {
        return resultadosO;
    }

    public void setResultadosO(String resultadosO) {
        this.resultadosO = resultadosO;
    }

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
    }

    public Estadoc getEstadoCidEstadoC() {
        return estadoCidEstadoC;
    }

    public void setEstadoCidEstadoC(Estadoc estadoCidEstadoC) {
        this.estadoCidEstadoC = estadoCidEstadoC;
    }

    public Hu getHUidHU() {
        return hUidHU;
    }

    public void setHUidHU(Hu hUidHU) {
        this.hUidHU = hUidHU;
    }

    public Practica getPracticaidPractica() {
        return practicaidPractica;
    }

    public void setPracticaidPractica(Practica practicaidPractica) {
        this.practicaidPractica = practicaidPractica;
    }

    @XmlTransient
    public List<Incidenciacp> getIncidenciacpList() {
        return incidenciacpList;
    }

    public void setIncidenciacpList(List<Incidenciacp> incidenciacpList) {
        this.incidenciacpList = incidenciacpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCp != null ? idCp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casoprueba)) {
            return false;
        }
        Casoprueba other = (Casoprueba) object;
        if ((this.idCp == null && other.idCp != null) || (this.idCp != null && !this.idCp.equals(other.idCp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Casoprueba[ idCp=" + idCp + " ]";
    }
    
}
