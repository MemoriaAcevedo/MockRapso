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
@Table(name = "hu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hu.findAll", query = "SELECT h FROM Hu h"),
    @NamedQuery(name = "Hu.findByIdHU", query = "SELECT h FROM Hu h WHERE h.idHU = :idHU"),
    @NamedQuery(name = "Hu.findByIdentificadorHU", query = "SELECT h FROM Hu h WHERE h.identificadorHU = :identificadorHU"),
    @NamedQuery(name = "Hu.findByNombreHU", query = "SELECT h FROM Hu h WHERE h.nombreHU = :nombreHU"),
    @NamedQuery(name = "Hu.findByDescripcionHU", query = "SELECT h FROM Hu h WHERE h.descripcionHU = :descripcionHU")})
public class Hu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHU")
    private Integer idHU;
    @Size(max = 25)
    @Column(name = "identificadorHU")
    private String identificadorHU;
    @Size(max = 45)
    @Column(name = "nombreHU")
    private String nombreHU;
    @Size(max = 200)
    @Column(name = "descripcionHU")
    private String descripcionHU;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hUidHU", fetch = FetchType.EAGER)
    private List<Casoprueba> casopruebaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hUidHU", fetch = FetchType.EAGER)
    private List<Pa> paList;

    public Hu() {
    }

    public Hu(Integer idHU) {
        this.idHU = idHU;
    }

    public Integer getIdHU() {
        return idHU;
    }

    public void setIdHU(Integer idHU) {
        this.idHU = idHU;
    }

    public String getIdentificadorHU() {
        return identificadorHU;
    }

    public void setIdentificadorHU(String identificadorHU) {
        this.identificadorHU = identificadorHU;
    }

    public String getNombreHU() {
        return nombreHU;
    }

    public void setNombreHU(String nombreHU) {
        this.nombreHU = nombreHU;
    }

    public String getDescripcionHU() {
        return descripcionHU;
    }

    public void setDescripcionHU(String descripcionHU) {
        this.descripcionHU = descripcionHU;
    }

    @XmlTransient
    public List<Casoprueba> getCasopruebaList() {
        return casopruebaList;
    }

    public void setCasopruebaList(List<Casoprueba> casopruebaList) {
        this.casopruebaList = casopruebaList;
    }

    @XmlTransient
    public List<Pa> getPaList() {
        return paList;
    }

    public void setPaList(List<Pa> paList) {
        this.paList = paList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHU != null ? idHU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hu)) {
            return false;
        }
        Hu other = (Hu) object;
        if ((this.idHU == null && other.idHU != null) || (this.idHU != null && !this.idHU.equals(other.idHU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hu[ idHU=" + idHU + " ]";
    }
    
}
