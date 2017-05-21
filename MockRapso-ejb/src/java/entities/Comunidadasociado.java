/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "comunidadasociado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidadasociado.findAll", query = "SELECT c FROM Comunidadasociado c"),
    @NamedQuery(name = "Comunidadasociado.findByComunidadidComunidad", query = "SELECT c FROM Comunidadasociado c WHERE c.comunidadasociadoPK.comunidadidComunidad = :comunidadidComunidad"),
    @NamedQuery(name = "Comunidadasociado.findByUsuarioAA", query = "SELECT c FROM Comunidadasociado c WHERE c.comunidadasociadoPK.usuarioAA = :usuarioAA"),
    @NamedQuery(name = "Comunidadasociado.findByCA", query = "SELECT c FROM Comunidadasociado c WHERE c.comunidadasociadoPK.usuarioAA = :usuarioAA AND c.comunidadasociadoPK.comunidadidComunidad = :comunidadidComunidad"),
    @NamedQuery(name = "Comunidadasociado.findByFechaAsociacion", query = "SELECT c FROM Comunidadasociado c WHERE c.fechaAsociacion = :fechaAsociacion")})
public class Comunidadasociado implements Serializable {

    @Column(name = "accesoPractica")
    private Boolean accesoPractica;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComunidadasociadoPK comunidadasociadoPK;
    @Column(name = "fechaAsociacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsociacion;
    @JoinColumn(name = "Comunidad_idComunidad", referencedColumnName = "idComunidad", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Comunidad comunidad;
    @JoinColumn(name = "usuarioAA", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Comunidadasociado() {
    }

    public Comunidadasociado(ComunidadasociadoPK comunidadasociadoPK) {
        this.comunidadasociadoPK = comunidadasociadoPK;
    }

    public Comunidadasociado(int comunidadidComunidad, int usuarioAA) {
        this.comunidadasociadoPK = new ComunidadasociadoPK(comunidadidComunidad, usuarioAA);
    }

    public ComunidadasociadoPK getComunidadasociadoPK() {
        return comunidadasociadoPK;
    }

    public void setComunidadasociadoPK(ComunidadasociadoPK comunidadasociadoPK) {
        this.comunidadasociadoPK = comunidadasociadoPK;
    }

    public Date getFechaAsociacion() {
        return fechaAsociacion;
    }

    public void setFechaAsociacion(Date fechaAsociacion) {
        this.fechaAsociacion = fechaAsociacion;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comunidadasociadoPK != null ? comunidadasociadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidadasociado)) {
            return false;
        }
        Comunidadasociado other = (Comunidadasociado) object;
        if ((this.comunidadasociadoPK == null && other.comunidadasociadoPK != null) || (this.comunidadasociadoPK != null && !this.comunidadasociadoPK.equals(other.comunidadasociadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Comunidadasociado[ comunidadasociadoPK=" + comunidadasociadoPK + " ]";
    }

    public Boolean getAccesoPractica() {
        return accesoPractica;
    }

    public void setAccesoPractica(Boolean accesoPractica) {
        this.accesoPractica = accesoPractica;
    }
    
}
