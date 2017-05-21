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
@Table(name = "practica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practica.findAll", query = "SELECT p FROM Practica p"),
    @NamedQuery(name = "Practica.findByIdPractica", query = "SELECT p FROM Practica p WHERE p.idPractica = :idPractica"),
    @NamedQuery(name = "Practica.findByIdentificadorPractica", query = "SELECT p FROM Practica p WHERE p.identificadorPractica = :identificadorPractica"),
    @NamedQuery(name = "Practica.findByFechaInicio", query = "SELECT p FROM Practica p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Practica.findByFechaTermino", query = "SELECT p FROM Practica p WHERE p.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Practica.findByCalificacion", query = "SELECT p FROM Practica p WHERE p.calificacion = :calificacion")})
public class Practica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPractica")
    private Integer idPractica;
    @Size(max = 45)
    @Column(name = "identificadorPractica")
    private String identificadorPractica;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fechaTermino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Column(name = "calificacion")
    private Integer calificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practicaidPractica", fetch = FetchType.EAGER)
    private List<Casoprueba> casopruebaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practicaidPractica", fetch = FetchType.EAGER)
    private List<Incidencia> incidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.EAGER)
    private List<Practica1> practica1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.EAGER)
    private List<Practica2> practica2List;
    @JoinColumn(name = "Comunidad_idComunidad", referencedColumnName = "idComunidad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Comunidad comunidadidComunidad;
    @JoinColumn(name = "EstadoP_idEstadoP", referencedColumnName = "idEstadoP")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estadop estadoPidEstadoP;
    @JoinColumn(name = "realizador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario realizador;
    @JoinColumn(name = "corrector", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario corrector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practicaidPractica", fetch = FetchType.EAGER)
    private List<Mensaje> mensajeList;

    public Practica() {
    }

    public Practica(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public Integer getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public String getIdentificadorPractica() {
        return identificadorPractica;
    }

    public void setIdentificadorPractica(String identificadorPractica) {
        this.identificadorPractica = identificadorPractica;
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

    @XmlTransient
    public List<Casoprueba> getCasopruebaList() {
        return casopruebaList;
    }

    public void setCasopruebaList(List<Casoprueba> casopruebaList) {
        this.casopruebaList = casopruebaList;
    }

    @XmlTransient
    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }

    @XmlTransient
    public List<Practica1> getPractica1List() {
        return practica1List;
    }

    public void setPractica1List(List<Practica1> practica1List) {
        this.practica1List = practica1List;
    }

    @XmlTransient
    public List<Practica2> getPractica2List() {
        return practica2List;
    }

    public void setPractica2List(List<Practica2> practica2List) {
        this.practica2List = practica2List;
    }

    public Comunidad getComunidadidComunidad() {
        return comunidadidComunidad;
    }

    public void setComunidadidComunidad(Comunidad comunidadidComunidad) {
        this.comunidadidComunidad = comunidadidComunidad;
    }

    public Estadop getEstadoPidEstadoP() {
        return estadoPidEstadoP;
    }

    public void setEstadoPidEstadoP(Estadop estadoPidEstadoP) {
        this.estadoPidEstadoP = estadoPidEstadoP;
    }

    public Usuario getRealizador() {
        return realizador;
    }

    public void setRealizador(Usuario realizador) {
        this.realizador = realizador;
    }

    public Usuario getCorrector() {
        return corrector;
    }

    public void setCorrector(Usuario corrector) {
        this.corrector = corrector;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPractica != null ? idPractica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Practica)) {
            return false;
        }
        Practica other = (Practica) object;
        if ((this.idPractica == null && other.idPractica != null) || (this.idPractica != null && !this.idPractica.equals(other.idPractica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Practica[ idPractica=" + idPractica + " ]";
    }
    
}
