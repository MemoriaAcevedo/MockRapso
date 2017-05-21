/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "operacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o"),
    @NamedQuery(name = "Operacion.findByIdO", query = "SELECT o FROM Operacion o WHERE o.idO = :idO"),
    @NamedQuery(name = "Operacion.findByOperacion", query = "SELECT o FROM Operacion o WHERE o.operacion = :operacion"),
    @NamedQuery(name = "Operacion.findByMontoOp", query = "SELECT o FROM Operacion o WHERE o.montoOp = :montoOp"),
    @NamedQuery(name = "Operacion.findByFechaOp", query = "SELECT o FROM Operacion o WHERE o.fechaOp = :fechaOp"),
    @NamedQuery(name = "Operacion.findBySaldoFinal", query = "SELECT o FROM Operacion o WHERE o.saldoFinal = :saldoFinal"),
    @NamedQuery(name = "Operacion.findByTipoO", query = "SELECT o FROM Operacion o WHERE o.tipoO = :tipoO"),
    @NamedQuery(name = "Operacion.findByRutR", query = "SELECT o FROM Operacion o WHERE o.rutR = :rutR"),
    @NamedQuery(name = "Operacion.findByRutRE", query = "SELECT o FROM Operacion o WHERE o.rutRE = :rutRE")})
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idO")
    private Integer idO;
    @Size(max = 25)
    @Column(name = "operacion")
    private String operacion;
    @Column(name = "montoOp")
    private Integer montoOp;
    @Column(name = "fechaOp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOp;
    @Column(name = "saldoFinal")
    private Integer saldoFinal;
    @Size(max = 25)
    @Column(name = "tipoO")
    private String tipoO;
    @Size(max = 45)
    @Column(name = "rutR")
    private String rutR;
    @Size(max = 45)
    @Column(name = "rutRE")
    private String rutRE;
    @JoinColumn(name = "realizador", referencedColumnName = "idC")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuenta realizador;

    public Operacion() {
    }

    public Operacion(Integer idO) {
        this.idO = idO;
    }

    public Integer getIdO() {
        return idO;
    }

    public void setIdO(Integer idO) {
        this.idO = idO;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getMontoOp() {
        return montoOp;
    }

    public void setMontoOp(Integer montoOp) {
        this.montoOp = montoOp;
    }

    public Date getFechaOp() {
        return fechaOp;
    }

    public void setFechaOp(Date fechaOp) {
        this.fechaOp = fechaOp;
    }

    public Integer getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Integer saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getTipoO() {
        return tipoO;
    }

    public void setTipoO(String tipoO) {
        this.tipoO = tipoO;
    }

    public String getRutR() {
        return rutR;
    }

    public void setRutR(String rutR) {
        this.rutR = rutR;
    }

    public String getRutRE() {
        return rutRE;
    }

    public void setRutRE(String rutRE) {
        this.rutRE = rutRE;
    }

    public Cuenta getRealizador() {
        return realizador;
    }

    public void setRealizador(Cuenta realizador) {
        this.realizador = realizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idO != null ? idO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.idO == null && other.idO != null) || (this.idO != null && !this.idO.equals(other.idO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operacion[ idO=" + idO + " ]";
    }
    
}
