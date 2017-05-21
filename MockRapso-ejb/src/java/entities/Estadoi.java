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
@Table(name = "estadoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoi.findAll", query = "SELECT e FROM Estadoi e"),
    @NamedQuery(name = "Estadoi.findByIdEstadoI", query = "SELECT e FROM Estadoi e WHERE e.idEstadoI = :idEstadoI"),
    @NamedQuery(name = "Estadoi.findByNombre", query = "SELECT e FROM Estadoi e WHERE e.nombre = :nombre")})
public class Estadoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoI")
    private Integer idEstadoI;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoIidEstadoI", fetch = FetchType.EAGER)
    private List<Incidencia> incidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoIidEstadoI", fetch = FetchType.EAGER)
    private List<Incidenciacp> incidenciacpList;

    public Estadoi() {
    }

    public Estadoi(Integer idEstadoI) {
        this.idEstadoI = idEstadoI;
    }

    public Integer getIdEstadoI() {
        return idEstadoI;
    }

    public void setIdEstadoI(Integer idEstadoI) {
        this.idEstadoI = idEstadoI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
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
        hash += (idEstadoI != null ? idEstadoI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoi)) {
            return false;
        }
        Estadoi other = (Estadoi) object;
        if ((this.idEstadoI == null && other.idEstadoI != null) || (this.idEstadoI != null && !this.idEstadoI.equals(other.idEstadoI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estadoi[ idEstadoI=" + idEstadoI + " ]";
    }
    
}
