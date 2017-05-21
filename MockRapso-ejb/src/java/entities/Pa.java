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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "pa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pa.findAll", query = "SELECT p FROM Pa p"),
    @NamedQuery(name = "Pa.findByIdPA", query = "SELECT p FROM Pa p WHERE p.idPA = :idPA"),
    @NamedQuery(name = "Pa.findByIdentificadorPA", query = "SELECT p FROM Pa p WHERE p.identificadorPA = :identificadorPA"),
    @NamedQuery(name = "Pa.findByNombrePA", query = "SELECT p FROM Pa p WHERE p.nombrePA = :nombrePA"),
    @NamedQuery(name = "Pa.findByDescripcionPA", query = "SELECT p FROM Pa p WHERE p.descripcionPA = :descripcionPA"),
    @NamedQuery(name = "Pa.findByPrecondicionesPA", query = "SELECT p FROM Pa p WHERE p.precondicionesPA = :precondicionesPA"),
    @NamedQuery(name = "Pa.findByPasosPA", query = "SELECT p FROM Pa p WHERE p.pasosPA = :pasosPA"),
    @NamedQuery(name = "Pa.findByResultadosEPA", query = "SELECT p FROM Pa p WHERE p.resultadosEPA = :resultadosEPA")})
public class Pa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPA")
    private Integer idPA;
    @Size(max = 25)
    @Column(name = "identificadorPA")
    private String identificadorPA;
    @Size(max = 45)
    @Column(name = "nombrePA")
    private String nombrePA;
    @Size(max = 200)
    @Column(name = "descripcionPA")
    private String descripcionPA;
    @Size(max = 300)
    @Column(name = "precondicionesPA")
    private String precondicionesPA;
    @Size(max = 500)
    @Column(name = "pasosPA")
    private String pasosPA;
    @Size(max = 300)
    @Column(name = "resultadosEPA")
    private String resultadosEPA;
    @JoinColumn(name = "HU_idHU", referencedColumnName = "idHU")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Hu hUidHU;

    public Pa() {
    }

    public Pa(Integer idPA) {
        this.idPA = idPA;
    }

    public Integer getIdPA() {
        return idPA;
    }

    public void setIdPA(Integer idPA) {
        this.idPA = idPA;
    }

    public String getIdentificadorPA() {
        return identificadorPA;
    }

    public void setIdentificadorPA(String identificadorPA) {
        this.identificadorPA = identificadorPA;
    }

    public String getNombrePA() {
        return nombrePA;
    }

    public void setNombrePA(String nombrePA) {
        this.nombrePA = nombrePA;
    }

    public String getDescripcionPA() {
        return descripcionPA;
    }

    public void setDescripcionPA(String descripcionPA) {
        this.descripcionPA = descripcionPA;
    }

    public String getPrecondicionesPA() {
        return precondicionesPA;
    }

    public void setPrecondicionesPA(String precondicionesPA) {
        this.precondicionesPA = precondicionesPA;
    }

    public String getPasosPA() {
        return pasosPA;
    }

    public void setPasosPA(String pasosPA) {
        this.pasosPA = pasosPA;
    }

    public String getResultadosEPA() {
        return resultadosEPA;
    }

    public void setResultadosEPA(String resultadosEPA) {
        this.resultadosEPA = resultadosEPA;
    }

    public Hu getHUidHU() {
        return hUidHU;
    }

    public void setHUidHU(Hu hUidHU) {
        this.hUidHU = hUidHU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPA != null ? idPA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pa)) {
            return false;
        }
        Pa other = (Pa) object;
        if ((this.idPA == null && other.idPA != null) || (this.idPA != null && !this.idPA.equals(other.idPA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pa[ idPA=" + idPA + " ]";
    }
    
}
