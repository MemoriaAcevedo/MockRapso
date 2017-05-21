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
@Table(name = "comunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidad.findAll", query = "SELECT c FROM Comunidad c"),
    @NamedQuery(name = "Comunidad.findByIdComunidad", query = "SELECT c FROM Comunidad c WHERE c.idComunidad = :idComunidad"),
    @NamedQuery(name = "Comunidad.findByNombreC", query = "SELECT c FROM Comunidad c WHERE c.nombreC = :nombreC"),
    @NamedQuery(name = "Comunidad.findByDescripcionC", query = "SELECT c FROM Comunidad c WHERE c.descripcionC = :descripcionC"),
    @NamedQuery(name = "Comunidad.findByFechaCC", query = "SELECT c FROM Comunidad c WHERE c.fechaCC = :fechaCC"),
    @NamedQuery(name = "Comunidad.findByFechaEC", query = "SELECT c FROM Comunidad c WHERE c.fechaEC = :fechaEC")})
public class Comunidad implements Serializable {

    @Column(name = "notaMinima")
    private Integer notaMinima;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunidad", fetch = FetchType.EAGER)
    private List<Pruebateorica> pruebateoricaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComunidad")
    private Integer idComunidad;
    @Size(max = 20)
    @Column(name = "nombreC")
    private String nombreC;
    @Size(max = 50)
    @Column(name = "descripcionC")
    private String descripcionC;
    @Column(name = "fechaCC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCC;
    @Column(name = "fechaEC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunidadidComunidad", fetch = FetchType.EAGER)
    private List<Practica> practicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunidad", fetch = FetchType.EAGER)
    private List<Comunidadasociado> comunidadasociadoList;
    @JoinColumn(name = "profesorC", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario profesorC;

    public Comunidad() {
    }

    public Comunidad(Integer idComunidad) {
        this.idComunidad = idComunidad;
    }

    public Integer getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Integer idComunidad) {
        this.idComunidad = idComunidad;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getDescripcionC() {
        return descripcionC;
    }

    public void setDescripcionC(String descripcionC) {
        this.descripcionC = descripcionC;
    }

    public Date getFechaCC() {
        return fechaCC;
    }

    public void setFechaCC(Date fechaCC) {
        this.fechaCC = fechaCC;
    }

    public Date getFechaEC() {
        return fechaEC;
    }

    public void setFechaEC(Date fechaEC) {
        this.fechaEC = fechaEC;
    }

    @XmlTransient
    public List<Practica> getPracticaList() {
        return practicaList;
    }

    public void setPracticaList(List<Practica> practicaList) {
        this.practicaList = practicaList;
    }

    @XmlTransient
    public List<Comunidadasociado> getComunidadasociadoList() {
        return comunidadasociadoList;
    }

    public void setComunidadasociadoList(List<Comunidadasociado> comunidadasociadoList) {
        this.comunidadasociadoList = comunidadasociadoList;
    }

    public Usuario getProfesorC() {
        return profesorC;
    }

    public void setProfesorC(Usuario profesorC) {
        this.profesorC = profesorC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComunidad != null ? idComunidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidad)) {
            return false;
        }
        Comunidad other = (Comunidad) object;
        if ((this.idComunidad == null && other.idComunidad != null) || (this.idComunidad != null && !this.idComunidad.equals(other.idComunidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Comunidad[ idComunidad=" + idComunidad + " ]";
    }

    public Integer getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(Integer notaMinima) {
        this.notaMinima = notaMinima;
    }

    @XmlTransient
    public List<Pruebateorica> getPruebateoricaList() {
        return pruebateoricaList;
    }

    public void setPruebateoricaList(List<Pruebateorica> pruebateoricaList) {
        this.pruebateoricaList = pruebateoricaList;
    }
    
}
