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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdC", query = "SELECT c FROM Cuenta c WHERE c.idC = :idC"),
    @NamedQuery(name = "Cuenta.findBySaldoC", query = "SELECT c FROM Cuenta c WHERE c.saldoC = :saldoC"),
    @NamedQuery(name = "Cuenta.findByEstadoC", query = "SELECT c FROM Cuenta c WHERE c.estadoC = :estadoC"),
    @NamedQuery(name = "Cuenta.findByTipoC", query = "SELECT c FROM Cuenta c WHERE c.tipoC = :tipoC")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idC")
    private Integer idC;
    @Column(name = "saldoC")
    private Integer saldoC;
    @Column(name = "estadoC")
    private Boolean estadoC;
    @Size(max = 25)
    @Column(name = "tipoC")
    private String tipoC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "realizador", fetch = FetchType.EAGER)
    private List<Operacion> operacionList;
    @JoinColumn(name = "idU", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario idU;

    public Cuenta() {
    }

    public Cuenta(Integer idC) {
        this.idC = idC;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public Integer getSaldoC() {
        return saldoC;
    }

    public void setSaldoC(Integer saldoC) {
        this.saldoC = saldoC;
    }

    public Boolean getEstadoC() {
        return estadoC;
    }

    public void setEstadoC(Boolean estadoC) {
        this.estadoC = estadoC;
    }

    public String getTipoC() {
        return tipoC;
    }

    public void setTipoC(String tipoC) {
        this.tipoC = tipoC;
    }

    @XmlTransient
    public List<Operacion> getOperacionList() {
        return operacionList;
    }

    public void setOperacionList(List<Operacion> operacionList) {
        this.operacionList = operacionList;
    }

    public Usuario getIdU() {
        return idU;
    }

    public void setIdU(Usuario idU) {
        this.idU = idU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cuenta[ idC=" + idC + " ]";
    }
    
}
