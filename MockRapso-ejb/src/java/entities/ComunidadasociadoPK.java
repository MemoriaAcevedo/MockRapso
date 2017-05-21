/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sebastian
 */
@Embeddable
public class ComunidadasociadoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Comunidad_idComunidad")
    private int comunidadidComunidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioAA")
    private int usuarioAA;

    public ComunidadasociadoPK() {
    }

    public ComunidadasociadoPK(int comunidadidComunidad, int usuarioAA) {
        this.comunidadidComunidad = comunidadidComunidad;
        this.usuarioAA = usuarioAA;
    }

    public int getComunidadidComunidad() {
        return comunidadidComunidad;
    }

    public void setComunidadidComunidad(int comunidadidComunidad) {
        this.comunidadidComunidad = comunidadidComunidad;
    }

    public int getUsuarioAA() {
        return usuarioAA;
    }

    public void setUsuarioAA(int usuarioAA) {
        this.usuarioAA = usuarioAA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) comunidadidComunidad;
        hash += (int) usuarioAA;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComunidadasociadoPK)) {
            return false;
        }
        ComunidadasociadoPK other = (ComunidadasociadoPK) object;
        if (this.comunidadidComunidad != other.comunidadidComunidad) {
            return false;
        }
        if (this.usuarioAA != other.usuarioAA) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ComunidadasociadoPK[ comunidadidComunidad=" + comunidadidComunidad + ", usuarioAA=" + usuarioAA + " ]";
    }
    
}
