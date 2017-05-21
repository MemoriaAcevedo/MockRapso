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
@Table(name = "areapregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areapregunta.findAll", query = "SELECT a FROM Areapregunta a"),
    @NamedQuery(name = "Areapregunta.findByIdAP", query = "SELECT a FROM Areapregunta a WHERE a.idAP = :idAP")})
public class Areapregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAP")
    private Integer idAP;
    @JoinColumn(name = "area", referencedColumnName = "idArea")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Area area;
    @JoinColumn(name = "pregunta", referencedColumnName = "idPregunta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pregunta pregunta;

    public Areapregunta() {
    }

    public Areapregunta(Integer idAP) {
        this.idAP = idAP;
    }

    public Integer getIdAP() {
        return idAP;
    }

    public void setIdAP(Integer idAP) {
        this.idAP = idAP;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAP != null ? idAP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areapregunta)) {
            return false;
        }
        Areapregunta other = (Areapregunta) object;
        if ((this.idAP == null && other.idAP != null) || (this.idAP != null && !this.idAP.equals(other.idAP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Areapregunta[ idAP=" + idAP + " ]";
    }
    
}
