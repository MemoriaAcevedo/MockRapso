/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByEmailU", query = "SELECT u FROM Usuario u WHERE u.emailU = :emailU"),
    @NamedQuery(name = "Usuario.findByRutU", query = "SELECT u FROM Usuario u WHERE u.rutU = :rutU"),
    @NamedQuery(name = "Usuario.findByNombreU", query = "SELECT u FROM Usuario u WHERE u.nombreU = :nombreU"),
    @NamedQuery(name = "Usuario.findByApellidoU", query = "SELECT u FROM Usuario u WHERE u.apellidoU = :apellidoU"),
    @NamedQuery(name = "Usuario.findByApodoU", query = "SELECT u FROM Usuario u WHERE u.apodoU = :apodoU"),
    @NamedQuery(name = "Usuario.findByContrasenaU", query = "SELECT u FROM Usuario u WHERE u.contrasenaU = :contrasenaU"),
    @NamedQuery(name = "Usuario.findByFotoPerfilU", query = "SELECT u FROM Usuario u WHERE u.fotoPerfilU = :fotoPerfilU"),
    @NamedQuery(name = "Usuario.findByFechaCreacionU", query = "SELECT u FROM Usuario u WHERE u.fechaCreacionU = :fechaCreacionU"),
    @NamedQuery(name = "Usuario.findByFechaEdicionU", query = "SELECT u FROM Usuario u WHERE u.fechaEdicionU = :fechaEdicionU"),
    @NamedQuery(name = "Usuario.findByPreguntaU", query = "SELECT u FROM Usuario u WHERE u.preguntaU = :preguntaU"),
    @NamedQuery(name = "Usuario.findByRespuestaU", query = "SELECT u FROM Usuario u WHERE u.respuestaU = :respuestaU"),
    @NamedQuery(name = "Usuario.findByMotivoC", query = "SELECT u FROM Usuario u WHERE u.motivoC = :motivoC")})
public class Usuario implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioRealizador", fetch = FetchType.EAGER)
    private List<Pruebateorica> pruebateoricaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 45)
    @Column(name = "emailU")
    private String emailU;
    @Size(max = 25)
    @Column(name = "rutU")
    private String rutU;
    @Size(max = 45)
    @Column(name = "nombreU")
    private String nombreU;
    @Size(max = 45)
    @Column(name = "apellidoU")
    private String apellidoU;
    @Size(max = 30)
    @Column(name = "apodoU")
    private String apodoU;
    @Size(max = 45)
    @Column(name = "contrasenaU")
    private String contrasenaU;
    @Size(max = 60)
    @Column(name = "fotoPerfilU")
    private String fotoPerfilU;
    @Column(name = "fechaCreacionU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionU;
    @Column(name = "fechaEdicionU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdicionU;
    @Size(max = 45)
    @Column(name = "preguntaU")
    private String preguntaU;
    @Size(max = 45)
    @Column(name = "respuestaU")
    private String respuestaU;
    @Size(max = 200)
    @Column(name = "motivoC")
    private String motivoC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "realizador", fetch = FetchType.EAGER)
    private List<Practica> practicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corrector", fetch = FetchType.EAGER)
    private List<Practica> practicaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Comunidadasociado> comunidadasociadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idU", fetch = FetchType.EAGER)
    private List<Cuenta> cuentaList;
    @JoinColumn(name = "Estado_idEstado", referencedColumnName = "idEstado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estado estadoidEstado;
    @JoinColumn(name = "TipoUsuario_idTipoUsuario", referencedColumnName = "idTipoUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tipousuario tipoUsuarioidTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "realizador", fetch = FetchType.EAGER)
    private List<Mensaje> mensajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesorC", fetch = FetchType.EAGER)
    private List<Comunidad> comunidadList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public String getRutU() {
        return rutU;
    }

    public void setRutU(String rutU) {
        this.rutU = rutU;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getApellidoU() {
        return apellidoU;
    }

    public void setApellidoU(String apellidoU) {
        this.apellidoU = apellidoU;
    }

    public String getApodoU() {
        return apodoU;
    }

    public void setApodoU(String apodoU) {
        this.apodoU = apodoU;
    }

    public String getContrasenaU() {
        return contrasenaU;
    }

    public void setContrasenaU(String contrasenaU) {
        this.contrasenaU = contrasenaU;
    }

    public String getFotoPerfilU() {
        return fotoPerfilU;
    }

    public void setFotoPerfilU(String fotoPerfilU) {
        this.fotoPerfilU = fotoPerfilU;
    }

    public Date getFechaCreacionU() {
        return fechaCreacionU;
    }

    public void setFechaCreacionU(Date fechaCreacionU) {
        this.fechaCreacionU = fechaCreacionU;
    }

    public Date getFechaEdicionU() {
        return fechaEdicionU;
    }

    public void setFechaEdicionU(Date fechaEdicionU) {
        this.fechaEdicionU = fechaEdicionU;
    }

    public String getPreguntaU() {
        return preguntaU;
    }

    public void setPreguntaU(String preguntaU) {
        this.preguntaU = preguntaU;
    }

    public String getRespuestaU() {
        return respuestaU;
    }

    public void setRespuestaU(String respuestaU) {
        this.respuestaU = respuestaU;
    }

    public String getMotivoC() {
        return motivoC;
    }

    public void setMotivoC(String motivoC) {
        this.motivoC = motivoC;
    }

    @XmlTransient
    public List<Practica> getPracticaList() {
        return practicaList;
    }

    public void setPracticaList(List<Practica> practicaList) {
        this.practicaList = practicaList;
    }

    @XmlTransient
    public List<Practica> getPracticaList1() {
        return practicaList1;
    }

    public void setPracticaList1(List<Practica> practicaList1) {
        this.practicaList1 = practicaList1;
    }

    @XmlTransient
    public List<Comunidadasociado> getComunidadasociadoList() {
        return comunidadasociadoList;
    }

    public void setComunidadasociadoList(List<Comunidadasociado> comunidadasociadoList) {
        this.comunidadasociadoList = comunidadasociadoList;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public Estado getEstadoidEstado() {
        return estadoidEstado;
    }

    public void setEstadoidEstado(Estado estadoidEstado) {
        this.estadoidEstado = estadoidEstado;
    }

    public Tipousuario getTipoUsuarioidTipoUsuario() {
        return tipoUsuarioidTipoUsuario;
    }

    public void setTipoUsuarioidTipoUsuario(Tipousuario tipoUsuarioidTipoUsuario) {
        this.tipoUsuarioidTipoUsuario = tipoUsuarioidTipoUsuario;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @XmlTransient
    public List<Comunidad> getComunidadList() {
        return comunidadList;
    }

    public void setComunidadList(List<Comunidad> comunidadList) {
        this.comunidadList = comunidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    @XmlTransient
    public List<Pruebateorica> getPruebateoricaList() {
        return pruebateoricaList;
    }

    public void setPruebateoricaList(List<Pruebateorica> pruebateoricaList) {
        this.pruebateoricaList = pruebateoricaList;
    }
    
}
