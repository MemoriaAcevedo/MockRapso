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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "pruebateorica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pruebateorica.findAll", query = "SELECT p FROM Pruebateorica p"),
    @NamedQuery(name = "Pruebateorica.findByIdPT", query = "SELECT p FROM Pruebateorica p WHERE p.idPT = :idPT"),
    @NamedQuery(name = "Pruebateorica.findByNota", query = "SELECT p FROM Pruebateorica p WHERE p.nota = :nota"),
    @NamedQuery(name = "Pruebateorica.findByFechaRealizado", query = "SELECT p FROM Pruebateorica p WHERE p.fechaRealizado = :fechaRealizado")})
public class Pruebateorica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPT")
    private Integer idPT;
    @Column(name = "nota")
    private Integer nota;
    @Column(name = "fechaRealizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pruebaTeorica", fetch = FetchType.EAGER)
    private List<Areareforzar> areareforzarList;
    @JoinColumn(name = "comunidad", referencedColumnName = "idComunidad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Comunidad comunidad;
    @JoinColumn(name = "usuarioRealizador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioRealizador;

    public Pruebateorica() {
    }

    public Pruebateorica(Integer idPT) {
        this.idPT = idPT;
    }

    public Integer getIdPT() {
        return idPT;
    }

    public void setIdPT(Integer idPT) {
        this.idPT = idPT;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    @XmlTransient
    public List<Areareforzar> getAreareforzarList() {
        return areareforzarList;
    }

    public void setAreareforzarList(List<Areareforzar> areareforzarList) {
        this.areareforzarList = areareforzarList;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public Usuario getUsuarioRealizador() {
        return usuarioRealizador;
    }

    public void setUsuarioRealizador(Usuario usuarioRealizador) {
        this.usuarioRealizador = usuarioRealizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPT != null ? idPT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pruebateorica)) {
            return false;
        }
        Pruebateorica other = (Pruebateorica) object;
        if ((this.idPT == null && other.idPT != null) || (this.idPT != null && !this.idPT.equals(other.idPT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pruebateorica[ idPT=" + idPT + " ]";
    }
    
}
