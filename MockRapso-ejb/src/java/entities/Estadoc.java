/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "estadoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoc.findAll", query = "SELECT e FROM Estadoc e"),
    @NamedQuery(name = "Estadoc.findByIdEstadoC", query = "SELECT e FROM Estadoc e WHERE e.idEstadoC = :idEstadoC"),
    @NamedQuery(name = "Estadoc.findByNombre", query = "SELECT e FROM Estadoc e WHERE e.nombre = :nombre")})
public class Estadoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoC")
    private Integer idEstadoC;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCidEstadoC", fetch = FetchType.EAGER)
    private List<Casoprueba> casopruebaList;

    public Estadoc() {
    }

    public Estadoc(Integer idEstadoC) {
        this.idEstadoC = idEstadoC;
    }

    public Integer getIdEstadoC() {
        return idEstadoC;
    }

    public void setIdEstadoC(Integer idEstadoC) {
        this.idEstadoC = idEstadoC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Casoprueba> getCasopruebaList() {
        return casopruebaList;
    }

    public void setCasopruebaList(List<Casoprueba> casopruebaList) {
        this.casopruebaList = casopruebaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoC != null ? idEstadoC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoc)) {
            return false;
        }
        Estadoc other = (Estadoc) object;
        if ((this.idEstadoC == null && other.idEstadoC != null) || (this.idEstadoC != null && !this.idEstadoC.equals(other.idEstadoC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estadoc[ idEstadoC=" + idEstadoC + " ]";
    }
    
}
