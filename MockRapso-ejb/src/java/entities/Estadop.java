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
@Table(name = "estadop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadop.findAll", query = "SELECT e FROM Estadop e"),
    @NamedQuery(name = "Estadop.findByIdEstadoP", query = "SELECT e FROM Estadop e WHERE e.idEstadoP = :idEstadoP"),
    @NamedQuery(name = "Estadop.findByNombre", query = "SELECT e FROM Estadop e WHERE e.nombre = :nombre")})
public class Estadop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoP")
    private Integer idEstadoP;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoPidEstadoP", fetch = FetchType.EAGER)
    private List<Practica> practicaList;

    public Estadop() {
    }

    public Estadop(Integer idEstadoP) {
        this.idEstadoP = idEstadoP;
    }

    public Integer getIdEstadoP() {
        return idEstadoP;
    }

    public void setIdEstadoP(Integer idEstadoP) {
        this.idEstadoP = idEstadoP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Practica> getPracticaList() {
        return practicaList;
    }

    public void setPracticaList(List<Practica> practicaList) {
        this.practicaList = practicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoP != null ? idEstadoP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadop)) {
            return false;
        }
        Estadop other = (Estadop) object;
        if ((this.idEstadoP == null && other.idEstadoP != null) || (this.idEstadoP != null && !this.idEstadoP.equals(other.idEstadoP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estadop[ idEstadoP=" + idEstadoP + " ]";
    }
    
}
