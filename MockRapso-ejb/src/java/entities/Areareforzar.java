/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "areareforzar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areareforzar.findAll", query = "SELECT a FROM Areareforzar a"),
    @NamedQuery(name = "Areareforzar.findByIdAR", query = "SELECT a FROM Areareforzar a WHERE a.idAR = :idAR")})
public class Areareforzar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAR")
    private Integer idAR;
    @JoinColumn(name = "area", referencedColumnName = "idArea")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Area area;
    @JoinColumn(name = "pruebaTeorica", referencedColumnName = "idPT")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pruebateorica pruebaTeorica;

    public Areareforzar() {
    }

    public Areareforzar(Integer idAR) {
        this.idAR = idAR;
    }

    public Integer getIdAR() {
        return idAR;
    }

    public void setIdAR(Integer idAR) {
        this.idAR = idAR;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Pruebateorica getPruebaTeorica() {
        return pruebaTeorica;
    }

    public void setPruebaTeorica(Pruebateorica pruebaTeorica) {
        this.pruebaTeorica = pruebaTeorica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAR != null ? idAR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areareforzar)) {
            return false;
        }
        Areareforzar other = (Areareforzar) object;
        if ((this.idAR == null && other.idAR != null) || (this.idAR != null && !this.idAR.equals(other.idAR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Areareforzar[ idAR=" + idAR + " ]";
    }
    
}
