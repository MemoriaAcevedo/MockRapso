/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Area;
import entities.Areapregunta;
import entities.Areareforzar;
import entities.Casoprueba;
import entities.Comunidad;
import entities.Comunidadasociado;
import entities.ComunidadasociadoPK;
import entities.Cuenta;
import entities.Estado;
import entities.Estadoc;
import entities.Estadoi;
import entities.Estadop;
import entities.Hu;
import entities.Incidencia;
import entities.Incidenciacp;
import entities.Mensaje;
import entities.Pa;
import entities.Practica;
import entities.Practica1;
import entities.Practica2;
import entities.Pregunta;
import entities.Pruebateorica;
import entities.Tipousuario;
import entities.Usuario;
import facade.AreapreguntaFacadeLocal;
import facade.AreareforzarFacadeLocal;
import facade.CasopruebaFacadeLocal;
import facade.ComunidadFacadeLocal;
import facade.ComunidadasociadoFacadeLocal;
import facade.CuentaFacadeLocal;
import facade.EstadoFacadeLocal;
import facade.EstadocFacadeLocal;
import facade.EstadoiFacadeLocal;
import facade.EstadopFacadeLocal;
import facade.HuFacadeLocal;
import facade.IncidenciaFacadeLocal;
import facade.IncidenciacpFacadeLocal;
import facade.MensajeFacadeLocal;
import facade.PaFacadeLocal;
import facade.Practica1FacadeLocal;
import facade.Practica2FacadeLocal;
import facade.PracticaFacadeLocal;
import facade.PreguntaFacadeLocal;
import facade.PruebateoricaFacadeLocal;
import facade.TipousuarioFacadeLocal;
import facade.UsuarioFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author Sebastian
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBLocal {

    @EJB
    public EstadoFacadeLocal estadoFacade;

    @EJB
    public UsuarioFacadeLocal usuarioFacade;

    @EJB
    public TipousuarioFacadeLocal tipoUsuarioFacade;

    @EJB
    public ComunidadFacadeLocal comunidadFacade;

    @EJB
    public ComunidadasociadoFacadeLocal comunidadAsociadoFacade;

    @EJB
    public CuentaFacadeLocal cuentaFacade;

    @EJB
    public PracticaFacadeLocal practidaFacade;

    @EJB
    public EstadopFacadeLocal estadoPFacade;

    @EJB
    public IncidenciaFacadeLocal incidenciaFacade;

    @EJB
    public IncidenciacpFacadeLocal incidenciacpFacade;

    @EJB
    public EstadoiFacadeLocal estadoIFacade;

    @EJB
    public CasopruebaFacadeLocal casopruebaFacade;

    @EJB
    public HuFacadeLocal huFacade;

    @EJB
    public EstadocFacadeLocal estadoCFacade;

    @EJB
    public MensajeFacadeLocal mensajeFacade;

    @EJB
    public PaFacadeLocal paFacade;

    @EJB
    public Practica1FacadeLocal practica1Facade;

    @EJB
    public Practica2FacadeLocal practica2Facade;

    @EJB
    public PruebateoricaFacadeLocal pruebateoricaFacade;

    @EJB
    public AreareforzarFacadeLocal areareforzarFacade;

    @EJB
    public PreguntaFacadeLocal preguntaFacade;

    @EJB
    public AreapreguntaFacadeLocal areaPreguntaFacade;

    @Resource
    private SessionContext sctx;


    @Override
    public String login(String email, String pass) {
        Usuario usuario;
        usuario = usuarioFacade.findByEmail(email);
        if (usuario != null) {
            if (usuario.getContrasenaU().equals(pass) && usuario.getEstadoidEstado().getNombreE().equals("Abierta")) {
                if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Alumno") || usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Ayudante")) {
                    return "/home/alumno";
                } else if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Profesor")) {
                    return "/home/profesor";
                } else if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Administrador")) {
                    return "/home/administrador";
                }
            } else if (usuario.getContrasenaU().equals(pass) && usuario.getEstadoidEstado().getNombreE().equals("Cerrada")) {
                if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Alumno") || usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Ayudante")) {
                    return "/home/alumno/activar";
                } else if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Profesor")) {
                    return "/home/profesor/activar";
                } else if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Administrador")) {
                    return "/home/administrador/activar";
                }
            } else if (!usuario.getContrasenaU().equals(pass) && ((usuario.getEstadoidEstado().getNombreE().equals("Abierta")) || (usuario.getEstadoidEstado().getNombreE().equals("Cerrada")))) {
                return "i";
            }
        }
        return "false";

    }

    @Override
    public Usuario getUserByEmail(String emailU) {

        Usuario usuario = usuarioFacade.findByEmail(emailU);
        return usuario;
    }

    @Override
    public String crearUsuario(Usuario newU) {

        Usuario user = usuarioFacade.findByRut(newU.getRutU());

        Usuario user1 = usuarioFacade.findByEmail(newU.getEmailU());

        if (user != null && user1 != null) {
            return "false";
        }
        if (user != null && user1 == null) {
            return "r";
        }
        if (user == null && user1 != null) {
            return "e";
        }
        Date d = new Date();

        Estado estadoU = estadoFacade.findByNombre("Abierta");

        if (estadoU == null) {
            return "err";
        }
        newU.setEstadoidEstado(estadoU);
        newU.setFechaCreacionU(d);
        newU.setFechaEdicionU(d);
        newU.setContrasenaU("rapso123");
        String response = usuarioFacade.createUser(newU);
        Usuario u = usuarioFacade.findByRut(newU.getRutU());
        String resb = "";
        String recb = "";
        if (!u.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Administrador")) {
            Cuenta sb = new Cuenta();
            Cuenta cb = new Cuenta();
            sb.setIdU(u);
            sb.setSaldoC(0);
            sb.setTipoC("sb");
            sb.setEstadoC(true);
            cb.setIdU(u);
            cb.setSaldoC(0);
            cb.setTipoC("cb");
            cb.setEstadoC(true);
            resb = cuentaFacade.createCuenta(sb);
            recb = cuentaFacade.createCuenta(cb);
        }

        if (response.equals("t") && (resb.equals("t") || recb.equals("")) && (resb.equals("t") || recb.equals(""))) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmail(u.getEmailU(), "n");
            return "t";
        }
        return "err";
    }

    @Override
    public Usuario editarUsuario(Usuario uEdit) {
        Date date = new Date();
        uEdit.setFechaEdicionU(date);
        String response = usuarioFacade.editUser(uEdit);
        String emailTo = uEdit.getEmailU();
        if (response.equals("true")) {
            if (uEdit.getEstadoidEstado().getNombreE().equals("Abierta")) {
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmail(emailTo, "e");
            }
            return usuarioFacade.findByEmail(uEdit.getEmailU());
        }
        return null;
    }

    @Override
    public String cerrarC(String rutU, String motivo) {
        Usuario usuario = usuarioFacade.findByRut(rutU);
        Estado e = null;
        e = estadoFacade.findByNombre("Cerrada");
        Date d = new Date();
        usuario.setMotivoC(motivo);
        usuario.setFechaEdicionU(d);
        usuario.setEstadoidEstado(e);

        String response = usuarioFacade.editUser(usuario);
        String emailTo = usuario.getEmailU();
        if (response.equals("true")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmail(emailTo, "c");

            if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Alumno")) {
                //Obtener practicas
                List<Comunidad> comun = getCByAA(usuario.getIdUsuario());
                if (comun != null) {
                    for (Comunidad c : comun) {
                        if (c.getProfesorC().getEstadoidEstado().getNombreE().equals("Abierta")) {
                            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(usuario, c, "rc");
                        }
                        List<Practica> correctores = getCorrectorByAlumno(usuario.getIdUsuario(), c.getIdComunidad());
                        if (correctores != null) {
                            for (Practica corrector : correctores) {
                                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(corrector, "cr");
                            }
                        }
                    }
                }
            } else if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Ayudante")) {
                List<Comunidad> comun = getCByAA(usuario.getIdUsuario());
                if (comun != null) {
                    for (Comunidad c : comun) {
                        if (c.getProfesorC().getEstadoidEstado().getNombreE().equals("Abierta")) {
                            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(usuario, c, "ac");
                        }
                        List<Practica> realizador = getRealizadorByCorrector(usuario.getIdUsuario(), c.getIdComunidad());
                        if (realizador != null) {
                            for (Practica corrector : realizador) {
                                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(corrector, "cc");
                            }
                        }
                    }
                }
            } else if (usuario.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Profesor")) {
                List<Comunidad> comun = getCByProfesor(usuario.getIdUsuario());
                if (comun != null) {
                    for (Comunidad c : comun) {
                        List<Usuario> users = getAlumnosByComunidad(c.getIdComunidad());
                        if (users != null) {
                            for (Usuario u : users) {
                                if (u.getEstadoidEstado().getNombreE().equals("Abierta")) {
                                    sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(u, c, "cp");
                                }
                            }
                        }
                        List<Practica> realizador = getRealizadorByCorrector(usuario.getIdUsuario(), c.getIdComunidad());
                        if (realizador != null) {
                            for (Practica corrector : realizador) {
                                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(corrector, "cc");
                            }
                        }
                    }
                }
            }

        }
        return response;
    }

    @Override
    public Usuario activarC(String rutU) {
        Usuario usuario = usuarioFacade.findByRut(rutU);
        Estado e = null;
        e = estadoFacade.findByNombre("Abierta");
        Date d = new Date();
        usuario.setFechaEdicionU(d);
        usuario.setEstadoidEstado(e);
        String response = usuarioFacade.editUser(usuario);
        String emailTo = usuario.getEmailU();
        if (response.equals("true")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmail(emailTo, "a");
            return usuarioFacade.findByEmail(usuario.getEmailU());
        }
        return null;
    }

    @Override
    public String eliminarC(String rutU) {
        Usuario u = usuarioFacade.findByRut(rutU);
        String emailTo = u.getEmailU();

        //Inicio Práctica
        //Se avisa a los correctores de los cuales el tipo posee una actividad dicendo que este fue eliminado
        if (u.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Alumno")) {
            List<Comunidad> comunidades = getCByAA(u.getIdUsuario());
            if (comunidades != null) {
                for (Comunidad c : comunidades) {
                    if (c.getProfesorC().getEstadoidEstado().getNombreE().equals("Abierta")) {
                        sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(u, c, "del");
                    }
                    List<Practica> ps = getCorrectorByAlumno(u.getIdUsuario(), c.getIdComunidad());
                    if (ps != null) {
                        for (Practica p : ps) {
                            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "sr");
                        }
                    }

                }
            }
        } else if (u.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Ayudante")) {
            List<Comunidad> comunidades = getCByAA(u.getIdUsuario());
            if (comunidades != null) {
                for (Comunidad c : comunidades) {
                    if (c.getProfesorC().getEstadoidEstado().getNombreE().equals("Abierta")) {
                        sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(u, c, "del");
                    }
                    List<Practica> ps = getRealizadorByCorrector(u.getIdUsuario(), c.getIdComunidad());
                    if (ps != null) {
                        for (Practica p : ps) {
                            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "sc");
                        }
                    }
                }
            }
        }

        //Si se elimina un profesor de una comunidad se avisa a todos que estan desligados 
        if (u.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Profesor")) {
            List<Comunidad> comunidades = getCByProfesor(u.getIdUsuario());
            if (comunidades != null) {
                List<Usuario> ca = null;
                for (Comunidad c : comunidades) {
                    ca = getAlumnosByComunidad(c.getIdComunidad());
                    if (ca != null) {
                        for (Usuario cax : ca) {
                            if (cax.getEstadoidEstado().getNombreE().equals("Abierta")) {
                                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(cax, c, "delP");
                            }
                        }

                        List<Practica> realizador = getRealizadorByCorrector(u.getIdUsuario(), c.getIdComunidad());
                        if (realizador != null) {
                            for (Practica corrector : realizador) {
                                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(corrector, "sc");
                            }
                        }

                    }

                    ca = null;
                }
            }
        }

        //fin comunidad
        String response = usuarioFacade.deleteUser(rutU);
        if (response.equals("t")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmail(emailTo, "suprimir");
        }
        return response;
    }

    @Override
    public List<Tipousuario> getTipoUsuarios() {
        List<Tipousuario> tipoUsuarios = tipoUsuarioFacade.findAll();
        return tipoUsuarios;
    }

    @Override
    public List<Estado> getEstados() {
        List<Estado> estados = estadoFacade.findAll();
        return estados;
    }

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> us = usuarioFacade.findAll();

        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getRutU().equals("15129921-0")) {
                us.remove(us.get(i));
            }
        }
        return us;
    }

    @Override
    public List<Usuario> getAllE(String tipo
    ) {
        List<Usuario> us = usuarioFacade.findAll();
        List<Usuario> getAll = new ArrayList();

        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getTipoUsuarioidTipoUsuario().getNombreTU().equals(tipo) && us.get(i).getEstadoidEstado().getNombreE().equals("Abierta")) {
                getAll.add(us.get(i));
            }
        }
        return getAll;
    }

    @Override
    public List<Tipousuario> getTUCustom() {
        List<Tipousuario> tu = tipoUsuarioFacade.findAll();
        List<Tipousuario> aux = new ArrayList();

        for (Tipousuario t : tu) {
            if (t.getNombreTU().equals("Alumno") || t.getNombreTU().equals("Ayudante")) {
                aux.add(t);
            }
        }

        return aux;
    }

    @Asynchronous
    public void sendEmail(String toEmail, String tipo
    ) {
        System.out.println("start running asyncMethod in thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(0);
            String username = "rapsodiatest@gmail.com";
            String password = "rapsodia1";

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);

            String message = "";
            String subject = "";
            if (tipo.equals("e")) {
                //edición
                message = "Se ha realizado una actualización en su perfil en Rapsodia." + "\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Edición perfil";
            } else if (tipo.equals("c")) {
                //cierre
                message = "Se ha cerrado su cuenta en Rapsodia. \nEsperamos que haya tenido una buena experiencia.";
                subject = "[Rapsodia] Cierre cuenta";
            } else if (tipo.equals("r")) {
                //recuperar contraseña
                Usuario user = usuarioFacade.findByEmail(toEmail);
                message = "Se ha solicitado la recuperación de la contraseña de su cuenta en Rapsodia. Su contraseña es: " + user.getContrasenaU() + "\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Recuperación contraseña";
            } else if (tipo.equals("n")) {
                //nuevo usuario creado
                Usuario user = usuarioFacade.findByEmail(toEmail);
                message = "Usted tiene acceso a Rapsodia.\n Sus credenciales son las siguientes: \nE-mail: " + user.getEmailU() + "\n Contraseña: "
                        + user.getContrasenaU() + "\n Pregunta Secreta: " + user.getPreguntaU() + "\n Respuesta: " + user.getRespuestaU() + "\n .Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Cuenta Rapsodia";
            } else if (tipo.equals("a")) {
                //activar
                message = "Su cuenta en Rapsodia ha sido activada." + "\n Ingrese ahora: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Activación Cuenta";
            } else {
                //eliminación
                message = "Se ha eliminado su cuenta en Rapsodia. \nEsperamos que haya tenido una buena experiencia.";
                subject = "[Rapsodia] Eliminación cuenta";
            }

            Message mailMessage = new MimeMessage(mailSession);
            mailMessage.setFrom(new InternetAddress("rapsodiatest@gmail.com"));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessage.setContent(message, "text/html");
            mailMessage.setSubject(subject);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        } catch (MessagingException ex) {
            Logger.getLogger(UsuarioEJB.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished running asyncMethod in thread " + Thread.currentThread().getName());
    }

    @Asynchronous
    public void sendEmailComunidad(Usuario u, Comunidad c, String tipo) {
        System.out.println("start running asyncMethod in thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(0);
            String username = "rapsodiatest@gmail.com";
            String password = "rapsodia1";

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);

            String message = "";
            String subject = "";

            if (tipo.equals("aso")) {
                message = "Usted ha sido asociado a la comunidad con nombre " + c.getNombreC() + ".\n Ingrese ahora: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Asociación a una comunidad";
            } else if (tipo.equals("des")) {
                message = "Usted ha sido desligado de la comunidad con nombre " + c.getNombreC() + ".\n Ingrese ahora: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Desvinculación de una comunidad";
            } else if (tipo.equals("comu")) {
                message = "Usted se encuentra a cargo de la comunidad con nombre " + c.getNombreC() + ".\n Ingrese ahora para ver la nueva comunidad: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Nueva Comunidad";
            } else if (tipo.equals("comuE")) {
                message = "Se ha actualizado su comunidad con nombre " + c.getNombreC() + ".\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Edición Comunidad";
            } else if (tipo.equals("elimC")) {
                message = "Se ha eliminado su comunidad con nombre " + c.getNombreC() + ".\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Eliminación Comunidad";
            } else if (tipo.equals("del")) {
                message = "Se ha eliminado el " + u.getTipoUsuarioidTipoUsuario().getNombreTU() + " " + u.getNombreU() + " " + u.getApellidoU() + " de su comunidad con nombre " + c.getNombreC() + ".\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Eliminación usuario comunidad";
            } else if (tipo.equals("delP")) {
                message = "Se ha eliminado el " + c.getProfesorC().getTipoUsuarioidTipoUsuario().getNombreTU() + " " + c.getProfesorC().getNombreU() + " " + c.getProfesorC().getApellidoU() + " encargado de la comunidad con nombre " + c.getNombreC() + ", por lo tanto usted ha sido desligado de esta.\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Eliminación profesor comunidad";
            } else if (tipo.equals("rc")) {
                message = "El Alumno " + u.getNombreU() + " " + u.getApellidoU() + " perteneciente a su comunidad con nombre " + c.getNombreC() + ",ha cerrado su cuenta." + "\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Cierre cuenta alumno comunidad";
            } else if (tipo.equals("ac")) {
                message = "El Ayudante " + u.getNombreU() + "" + u.getApellidoU() + " perteneciente a su comunidad con nombre " + c.getNombreC() + ", ha cerrado su cuenta." + "\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Cierre cuenta ayudante comunidad";
            } else if (tipo.equals("cp")) {
                message = "El Profesor " + c.getProfesorC().getNombreU() + " de la comunidad con nombre " + c.getNombreC() + ", ha cerrado su cuenta." + "\n Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Cierre cuenta profesor comunidad";
            } else if (tipo.equals("cn")) {
                message = "El " + u.getTipoUsuarioidTipoUsuario().getNombreTU() + " " + u.getNombreU() + " " + u.getApellidoU() + " ha actualizado la nota mínima de la comunidad " + c.getNombreC() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Cambio nota prueba teórica";
            }

            Message mailMessage = new MimeMessage(mailSession);
            mailMessage.setFrom(new InternetAddress("rapsodiatest@gmail.com"));
            if (tipo.equals("del") || tipo.equals("rc") || tipo.equals("ac")) {
                mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(c.getProfesorC().getEmailU()));
            } else {
                mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(u.getEmailU()));
            }
            mailMessage.setContent(message, "text/html");
            mailMessage.setSubject(subject);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);

            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

        } catch (MessagingException ex) {
            Logger.getLogger(UsuarioEJB.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished running asyncMethod in thread " + Thread.currentThread().getName());

    }

    //SPRINT 1.3
    @Override
    public String crearComunidad(String emailP, String nombreC, String descripcionC
    ) {

        Comunidad test = comunidadFacade.findByNombre(nombreC);
        if (test != null) {
            return "e";
        }
        Usuario p = usuarioFacade.findByEmail(emailP);
        if (p == null) {
            return "p";
        }
        Comunidad c = new Comunidad();
        c.setNombreC(nombreC);
        c.setDescripcionC(descripcionC);
        c.setProfesorC(p);
        Date d = new Date();
        c.setFechaCC(d);
        c.setFechaEC(d);
        c.setNotaMinima(40);
        String retorno = comunidadFacade.createComunidad(c);
        if (retorno.equals("t")) {
            Comunidad res = comunidadFacade.findByNombre(nombreC);
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(p, res, "comu");
        }

        return retorno;
    }

    @Override
    public List<Comunidad> getAllComunidades() {
        List<Comunidad> c = comunidadFacade.findAll();
        return c;
    }

    @Override
    public String editarComunidad(Comunidad c
    ) {
        Date date = new Date();
        c.setFechaEC(date);
        Comunidad c1 = comunidadFacade.findByNombre(c.getNombreC());
        if (c1 != null) {
            if (c.getIdComunidad() != c1.getIdComunidad()) {
                return "e";
            }
        }
        String response = comunidadFacade.editarComunidad(c);
        if (response.equals("true")) {
            if (c.getProfesorC().getEstadoidEstado().getNombreE().equals("Abierta")) {
                Comunidad res = comunidadFacade.findByNombre(c.getNombreC());
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(c.getProfesorC(), res, "comuE");
            }
        }

        return response;
    }

    @Override
    public String asociarAComunidad(String nombreC, String rutA
    ) {
        Comunidad c = comunidadFacade.findByNombre(nombreC);
        Usuario asociar = usuarioFacade.findByRut(rutA);

        
        if (comunidadAsociadoFacade.findByCA(c.getIdComunidad(), asociar.getIdUsuario()) != null) {
            return "e";
        }
        ComunidadasociadoPK ca = new ComunidadasociadoPK();

        ca.setComunidadidComunidad(c.getIdComunidad());
        ca.setUsuarioAA(asociar.getIdUsuario());
        Date actual = new Date();
        Comunidadasociado cas = new Comunidadasociado();
        cas.setComunidadasociadoPK(ca);
        cas.setComunidad(c);
        cas.setUsuario(asociar);
        cas.setFechaAsociacion(actual);
        cas.setAccesoPractica(false);

        comunidadAsociadoFacade.create(cas);

        if (comunidadAsociadoFacade.findByCA(c.getIdComunidad(), asociar.getIdUsuario()) != null) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(asociar, c, "aso");
            return "true";
        } else {
            return "false";
        }
    }

    @Override
    public List<Usuario> getAlumnosByComunidad(int idC
    ) {
        List<Comunidadasociado> ca = comunidadAsociadoFacade.findByC(idC);

        if (ca == null) {
            return null;
        }

        List<Usuario> asociados = new ArrayList();

        for (Comunidadasociado cax : ca) {
            asociados.add(cax.getUsuario());
        }

        return asociados;
    }

    public List<Usuario> getAyudantesByComunidad(int idC
    ) {
        List<Comunidadasociado> ca = comunidadAsociadoFacade.findByC(idC);

        if (ca == null) {
            return null;
        }

        List<Usuario> asociados = new ArrayList();

        for (Comunidadasociado cax : ca) {
            if (cax.getUsuario().getTipoUsuarioidTipoUsuario().getNombreTU().equals("Ayudante")) {
                asociados.add(cax.getUsuario());
            }

        }

        return asociados;
    }

    @Override
    public String desligar(int idC, int idA
    ) {
        Comunidadasociado as = comunidadAsociadoFacade.findByCA(idC, idA);
        comunidadAsociadoFacade.remove(as);
        if (comunidadAsociadoFacade.findByCA(idC, idA) == null) {
            Usuario u = usuarioFacade.find(idA);
            if (u.getEstadoidEstado().getNombreE().equals("Abierto")) {
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(u, as.getComunidad(), "des");
            }
            return "true";
        } else {
            return "false";
        }
    }

    @Override
    public String eliminarComunidad(Comunidad c
    ) {

        int idC = c.getIdComunidad();
        List<Comunidadasociado> ca = comunidadAsociadoFacade.findByC(idC);

        if (ca != null) {
            for (Comunidadasociado cax : ca) {
                if (cax.getUsuario().getEstadoidEstado().getNombreE().equals("Abierta")) {
                    sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(cax.getUsuario(), cax.getComunidad(), "des");
                }
            }
        }
        comunidadFacade.remove(c);

        if (comunidadFacade.find(idC) == null) {
            if (c.getProfesorC().getEstadoidEstado().getNombreE().equals("Abierta")) {
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(c.getProfesorC(), c, "elimC");
            }
            return "true";
        }

        return "false";
    }

    @Override
    public List<Comunidad> getCByProfesor(int idP
    ) {
        List<Comunidad> all = comunidadFacade.findAll();
        List<Comunidad> response = new ArrayList();

        if (all != null) {
            for (Comunidad c : all) {
                if (c.getProfesorC().getIdUsuario() == idP) {
                    response.add(c);
                }
            }
        }

        if (response.isEmpty()) {
            return null;
        }
        return response;
    }

    @Override
    public List<Comunidad> getCByAA(int idAA
    ) {
        List<Comunidadasociado> response = comunidadAsociadoFacade.findByA(idAA);
        List<Comunidad> res = new ArrayList();

        if (response != null) {
            for (Comunidadasociado cas : response) {
                res.add(cas.getComunidad());
            }
            return res;
        }

        return null;
    }

    @Override
    public Comunidad getComunidadByNombre(String nombre) {
        Comunidad c = comunidadFacade.findByNombre(nombre);
        return c;
    }

    //Sprint 3.3
    /*INICIO FUNCIONES PRACTICA*/
    @Override
    public String crearPractica(String rutR, int idC
    ) {

        Practica p = new Practica();
        Usuario realizador = usuarioFacade.findByRut(rutR);
        Comunidad c = comunidadFacade.find(idC);
        if (c == null) {
            return "f";
        }

        if (realizador == null) {
            return "f";
        }
        List<Practica> ps = getPracticasByAlumnoComunidad(realizador.getIdUsuario(), c.getIdComunidad());

        for (Practica prac : ps) {
            if (prac.getEstadoPidEstadoP().getNombre().equals("Desarrollo P1") || prac.getEstadoPidEstadoP().getNombre().equals("Desarrollo P2") || prac.getEstadoPidEstadoP().getNombre().equals("Corregir P1") || prac.getEstadoPidEstadoP().getNombre().equals("Corregir P2") || prac.getEstadoPidEstadoP().getNombre().equals("Corregida P1")) {
                return "n";
            }
        }

        Usuario corrector = getCorrector(c.getIdComunidad());

        if (corrector == null) {
            return "c";
        }

        p.setRealizador(realizador);
        p.setCorrector(corrector);
        p.setFechaInicio(new Date());
        p.setCalificacion(0);
        p.setComunidadidComunidad(c);
        Estadop ep = estadoPFacade.findByNombre("Desarrollo P1");
        if (ep == null) {
            return "f";
        }
        p.setEstadoPidEstadoP(ep);

        String estatico = "P-";

        if (ps == null) {
            estatico = estatico + 1;
        } else {
            estatico = estatico + (ps.size() + 1);
        }

        p.setIdentificadorPractica(estatico);

        String res = practidaFacade.createPractica(p);

        if (res.equals("t")) {
            Practica p1 = getPracticaByIdentificadorComunidad(estatico, p.getComunidadidComunidad().getIdComunidad(), rutR);
            //crearPractica 1
            Practica1 practica1 = new Practica1();
            practica1.setCalificacion(0);
            practica1.setFechaInicio(new Date());
            practica1.setObservacion("");
            practica1.setPractica(p1);
            String r = practica1Facade.createPractica1(practica1);

            if (r.equals("t")) {
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p1, "cpa");
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p1, "cpc");
                return p1.getIdentificadorPractica();
            }
        }

        return "f";
    }

    @Override
    public String eliminarPractica(int idP) {
        Practica p = practidaFacade.find(idP);
        String res = practidaFacade.eliminarPractica(idP);

        if (res.equals("t")) {
            if (p.getRealizador().getEstadoidEstado().getNombreE().equals("Abierta")) {
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "epa");
            }
            if (p.getCorrector().getEstadoidEstado().getNombreE().equals("Abierta")) {
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "epc");
            }

            return "t";
        }
        return "f";
    }

    public Usuario getCorrector(int idComunidad) {
        List<Usuario> all = getAlumnosByComunidad(idComunidad);
        List<Usuario> response = new ArrayList();
        Comunidad c = comunidadFacade.find(idComunidad);
        if (all == null) {
            response.add(c.getProfesorC());
        } else {
            response = all;
            response.add(c.getProfesorC());
        }

        List<Usuario> correctores = new ArrayList();

        for (Usuario u : response) {
            if ((u.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Profesor") && u.getEstadoidEstado().getNombreE().equals("Abierta")) || (u.getTipoUsuarioidTipoUsuario().getNombreTU().equals("Ayudante") && u.getEstadoidEstado().getNombreE().equals("Abierta"))) {
                correctores.add(u);
            }
        }

        if (correctores.isEmpty()) {
            return null;
        }

        int numeroAleatorio = (int) (Math.random() * correctores.size() + 1);

        return correctores.get(numeroAleatorio - 1);
    }

    @Override
    public List<Practica> getPracticasByAlumnoComunidad(int idU, int idC) {
        List<Practica> practicas = practidaFacade.findAll();

        if (practicas == null) {
            return null;
        }

        List<Practica> response = new ArrayList();
        for (Practica p : practicas) {
            if (p.getRealizador().getIdUsuario() == idU && p.getComunidadidComunidad().getIdComunidad() == idC) {
                response.add(p);
            }
        }
        return response;
    }

    public List<Practica> getCorrectorByAlumno(int idU, int idC) {
        List<Practica> p = getPracticasByAlumnoComunidad(idU, idC);

        if (p == null) {
            return null;
        }
        List<Practica> users = new ArrayList();
        for (Practica ps : p) {
            if (!userExistP(users, ps.getCorrector().getIdUsuario(), "c") && ps.getCorrector().getEstadoidEstado().getNombreE().equals("Abierta")) {
                users.add(ps);
            }
        }

        if (users.isEmpty()) {
            return null;
        }

        return users;

    }

    public List<Practica> getRealizadorByCorrector(int idU, int idC) {
        List<Practica> p = getPracticasByCorrectorComunidad(idU, idC);

        if (p == null) {
            return null;
        }
        List<Practica> users = new ArrayList();
        for (Practica ps : p) {
            if (!userExistP(users, ps.getRealizador().getIdUsuario(), "r") && ps.getRealizador().getEstadoidEstado().getNombreE().equals("Abierta")) {
                users.add(ps);
            }
        }

        if (users.isEmpty()) {
            return null;
        }

        return users;

    }

    public boolean userExistP(List<Practica> p, int idU, String tipo) {
        if (p.isEmpty()) {
            return false;
        }
        for (Practica pr : p) {
            if (tipo.equals("c")) {
                if (pr.getCorrector().getIdUsuario() == idU) {
                    return true;
                }
            } else if (tipo.equals("r")) {
                if (pr.getRealizador().getIdUsuario() == idU) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<Practica> getPracticasByCorrectorComunidad(int idU, int idC) {
        List<Practica> practicas = practidaFacade.findAll();

        if (practicas == null) {
            return null;
        }

        List<Practica> response = new ArrayList();
        for (Practica p : practicas) {
            if (p.getCorrector().getIdUsuario() == idU && p.getComunidadidComunidad().getIdComunidad() == idC) {
                response.add(p);
            }
        }
        return response;
    }

    @Override
    public List<Practica> getPracticasByAlumnoCorrectorComunidad(int idA, int idCorrector, int idComunidad) {
        List<Practica> pAlum = getPracticasByAlumnoComunidad(idA, idComunidad);

        if (pAlum == null) {
            return null;
        }

        List<Practica> response = new ArrayList();
        for (Practica p : pAlum) {
            if (p.getCorrector().getIdUsuario() == idCorrector) {
                response.add(p);
            }
        }
        return response;
    }

    @Override
    public Practica getPractica(int idP) {
        return practidaFacade.find(idP);
    }

    @Override
    public Practica getPracticaByIdentificadorComunidad(String idP, int idC, String rut) {
        List<Practica> p = practidaFacade.findAll();

        if (p == null) {
            return null;
        }

        for (Practica p1 : p) {
            if (p1.getIdentificadorPractica().equals(idP) && p1.getComunidadidComunidad().getIdComunidad() == idC && p1.getRealizador().getRutU().equals(rut)) {
                return p1;
            }
        }

        return null;
    }

    @Override
    public String enviarACorreccionP1(int idP1) {
        Practica1 p1 = practica1Facade.find(idP1);
        if (p1 == null) {
            return "f";
        }

        Estadop ep = estadoPFacade.findByNombre("Corregir P1");
        if (ep == null) {
            return "f";
        }

        Practica practica = p1.getPractica();

        practica.setEstadoPidEstadoP(ep);

        String r1 = practidaFacade.correccionPractica(practica);

        if (r1.equals("t")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(practica, "pec");
        }

        return r1;
    }

    @Override
    public String crearMensaje(int idP, String mensaje, String tipo) {

        Practica p = practidaFacade.find(idP);

        if (p == null) {
            return "f";
        }
        Mensaje m = new Mensaje();
        m.setMensaje(mensaje);
        m.setFechaRealizado(new Date());
        m.setPracticaidPractica(p);

        if (tipo.equals("r")) {
            m.setRealizador(p.getRealizador());
        } else {
            m.setRealizador(p.getCorrector());
        }

        String r = mensajeFacade.createMensaje(m);

        if (r.equals("t")) {
            if (tipo.equals("r")) {
                //enviar a corrector
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "mpc");

            } else {
                //enviar a realizador
                sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "mpa");
            }
            return "true";
        }
        return "false";
    }

    @Override
    public List<Mensaje> getMensajesP(int idP) {
        List<Mensaje> m = mensajeFacade.findAll();

        if (m == null) {
            return null;
        }
        List<Mensaje> mensajes = new ArrayList();
        for (Mensaje msg : m) {
            if (msg.getPracticaidPractica().getIdPractica() == idP) {
                mensajes.add(msg);
            }
        }

        if (mensajes.isEmpty()) {
            return null;
        }

        return mensajes;
    }

    @Override
    public String evaluarP1(int idP1, int nota, String obs) {
        Practica1 p = practica1Facade.find(idP1);

        if (p == null) {
            return "f";
        }

        if (nota > 70) {
            return "e";
        } else if (nota < 10) {
            return "i";
        }

        Estadop ep = estadoPFacade.findByNombre("Corregida P1");

        if (ep == null) {
            return "f";
        }

        Practica practica = p.getPractica();
        practica.setEstadoPidEstadoP(ep);

        p.setCalificacion(nota);
        p.setObservacion(obs);
        p.setFechaTermino(new Date());

        String res = practica1Facade.evaluarP1(p);
        String r = practidaFacade.correccionPractica(practica);

        if (res.equals("t") && r.equals("t")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p.getPractica(), "pev");
        }

        return res;
    }


    /*FIN FUNCIONES PRACTICA*/

 /*INICIO FUNCIONES INCIDENCIAS*/
    @Override
    public String crearIncidencia(Incidencia i) {
        String estatico = "I-";

        List<Incidencia> is = incidenciasByPractica(i.getPracticaidPractica().getIdPractica());

        if (is == null) {
            estatico = estatico + 1;
        } else {
            estatico = estatico + (is.size() + 1);
        }

        Estadoi ei = estadoIFacade.findByNombre("Corregir");
        if (ei == null) {
            return "false";
        }

        Practica p = getPracticaByIdentificadorComunidad(i.getPracticaidPractica().getIdentificadorPractica(), i.getPracticaidPractica().getComunidadidComunidad().getIdComunidad(), i.getPracticaidPractica().getRealizador().getRutU());

        i.setPracticaidPractica(p);
        i.setEstadoIidEstadoI(ei);
        i.setIdentificadorI(estatico);
        i.setFechaCI(new Date());
        i.setFechaEI(new Date());

        String response = incidenciaFacade.createIncidencia(i);

        if (response.equals("t")) {
            return "true";
        }

        return "false";
    }

    @Override
    public String crearIncidenciacp(Incidenciacp i) {
        String estatico = "I-";

        List<Incidenciacp> is = getIncidenciasCasoPrueba(i.getCasoPruebaidCp().getIdCp());

        if (is == null) {
            estatico = estatico + 1;
        } else {
            estatico = estatico + (is.size() + 1);
        }

        Estadoi ei = estadoIFacade.findByNombre("Corregir");
        if (ei == null) {
            return "false";
        }

        i.setEstadoIidEstadoI(ei);
        i.setIdentificadorICP(estatico);
        i.setFechaCICP(new Date());
        i.setFechaE(new Date());

        String response = incidenciacpFacade.createIncidenciacp(i);

        if (response.equals("t")) {
            return "true";
        }

        return "false";
    }

    @Override
    public List<Incidencia> incidenciasByPractica(int idP) {
        List<Incidencia> all = incidenciaFacade.findAll();

        if (all == null) {
            return null;
        }

        List<Incidencia> i = new ArrayList();

        for (Incidencia x : all) {
            if (x.getPracticaidPractica().getIdPractica() == idP) {
                i.add(x);
            }
        }

        if (i.isEmpty()) {
            return null;
        }

        return i;
    }

    @Override
    public List<Incidenciacp> getIncidenciasCPByPractica(int idP) {
        List<Casoprueba> cp = getCasosPruebaByPractica(idP);

        if (cp == null) {
            return null;
        }

        List<Incidenciacp> icp = new ArrayList();
        List<Incidenciacp> aux = new ArrayList();
        for (Casoprueba c : cp) {
            aux = getIncidenciasCasoPrueba(c.getIdCp());
            if (aux != null) {
                for (Incidenciacp i : aux) {
                    icp.add(i);
                }
            }
        }

        if (icp.isEmpty()) {
            return null;
        }

        return icp;
    }

    @Override
    public List<Incidenciacp> getIncidenciasCasoPrueba(int idCasoprueba) {
        List<Incidenciacp> icp = incidenciacpFacade.findAll();

        if (icp == null) {
            return null;
        }
        List<Incidenciacp> res = new ArrayList();
        for (Incidenciacp i : icp) {
            if (i.getCasoPruebaidCp().getIdCp() == idCasoprueba) {
                res.add(i);
            }
        }

        if (res.isEmpty()) {
            return null;
        }

        return res;
    }

    @Override
    public String actualizarIncidencia(Incidencia i) {
        Incidencia prev = incidenciaFacade.find(i.getIdIncidencia());
        if (i.getNombreI().equals(prev.getNombreI()) && i.getDescripcionI().equals(prev.getDescripcionI()) && i.getPasosI().equals(prev.getPasosI()) && i.getResultadoEI().equals(prev.getResultadoEI()) && i.getResultadoOI().equals(prev.getResultadoOI()) && i.getEstadoIidEstadoI().getNombre().equals(prev.getEstadoIidEstadoI().getNombre())) {
            return "i";
        }

        i.setFechaEI(new Date());
        String res = incidenciaFacade.editIncidencia(i);

        return res;
    }

    @Override
    public String actualizarIncidenciaCP(Incidenciacp i) {
        Incidenciacp prev = incidenciacpFacade.find(i.getIdIncidenciacp());
        if (i.getNombreICP().equals(prev.getNombreICP()) && i.getDescripcionICP().equals(prev.getDescripcionICP()) && i.getPasosICP().equals(prev.getPasosICP()) && i.getResultadoEICP().equals(prev.getResultadoEICP()) && i.getResultadoOICP().equals(prev.getResultadoOICP()) && i.getEstadoIidEstadoI().getNombre().equals(prev.getEstadoIidEstadoI().getNombre())) {
            return "i";
        }

        i.setFechaE(new Date());
        String res = incidenciacpFacade.editIncidenciacp(i);

        return res;
    }

    @Override
    public String eliminarI(int idI) {
        String res = incidenciaFacade.eliminarIncidencia(idI);
        return res;
    }

    @Override
    public String eliminarICP(int idI) {
        String res = incidenciacpFacade.eliminarIncidenciacp(idI);
        return res;
    }

    @Override
    public List<Estadoi> getEstadosI() {
        return estadoIFacade.findAll();
    }

    @Override
    public Incidencia getIncidencia(int idI) {
        Incidencia i = incidenciaFacade.find(idI);
        return i;
    }

    @Override
    public Incidenciacp getIncidenciacp(int idICP) {
        Incidenciacp i = incidenciacpFacade.find(idICP);
        return i;
    }

    /*FIN FUNCIONES INCIDENCIAS*/

 /*INICIO FUNCIONES CASOS DE PRUEBA */
    @Override
    public List<Casoprueba> getCasosPruebaByPractica(int idP) {

        List<Casoprueba> cp = casopruebaFacade.findAll();

        if (cp == null) {
            return null;
        }

        List<Casoprueba> casos = new ArrayList();

        for (Casoprueba c : cp) {
            if (c.getPracticaidPractica().getIdPractica() == idP) {
                casos.add(c);
            }
        }

        if (casos.isEmpty()) {
            return null;
        }

        return casos;
    }

    @Override
    public List<Hu> getHU() {
        return huFacade.findAll();
    }

    @Override
    public String crearCP(Casoprueba cp) {
        String estatico = "CP-";

        List<Casoprueba> is = getCasosPruebaByPractica(cp.getPracticaidPractica().getIdPractica());
        
        if (is == null) {
            estatico = estatico + 1;
        } else {
            estatico = estatico + (is.size() + 1);
        }

        Estadoc ec = estadoCFacade.findByNombre("Falla");
        if (ec == null) {
            return "false";
        }

        Practica p = getPracticaByIdentificadorComunidad(cp.getPracticaidPractica().getIdentificadorPractica(), cp.getPracticaidPractica().getComunidadidComunidad().getIdComunidad(), cp.getPracticaidPractica().getRealizador().getRutU());

        cp.setPracticaidPractica(p);
        cp.setEstadoCidEstadoC(ec);
        cp.setIdentificadorCaso(estatico);
        cp.setFechaC(new Date());
        cp.setFechaE(new Date());

        String response = casopruebaFacade.createCP(cp);

        if (response.equals("t")) {
            return "true";
        }

        return "false";
    }

    @Override
    public String actualizarCP(Casoprueba c) {
        Casoprueba prev = casopruebaFacade.find(c.getIdCp());

        if (c.getNombre().equals(prev.getNombre()) && c.getDescripcion().equals(prev.getDescripcion()) && c.getPasos().equals(prev.getPasos()) && c.getResultadosE().equals(prev.getResultadosE()) && c.getPrecondicion().equals(prev.getPrecondicion()) && c.getResultadosO().equals(prev.getResultadosO()) && c.getEstadoCidEstadoC().getNombre().equals(prev.getEstadoCidEstadoC().getNombre())) {
            return "i";
        }

        if (c.getEstadoCidEstadoC().getNombre().equals("Pasa") && prev.getEstadoCidEstadoC().getNombre().equals("Falla")) {
            if (c.getResultadosO().equals("")) {
                return "ro";
            }
            List<Incidenciacp> icp = getIncidenciasCasoPrueba(c.getIdCp());

            if (icp != null) {
                for (Incidenciacp i : icp) {
                    if (i.getEstadoIidEstadoI().getNombre().equals("Corregir")) {
                        return "e";
                    }
                }
            }
        }

        c.setFechaE(new Date());
        String res = casopruebaFacade.editCP(c);
        return res;
    }

    @Override
    public List<Estadoc> getEstadoCP() {
        return estadoCFacade.findAll();
    }

    @Override
    public String eliminarCP(int idC) {
        String res = casopruebaFacade.deleteCP(idC);
        return res;
    }

    @Override
    public Casoprueba getCasoPrueba(int idCP) {
        Casoprueba cp = casopruebaFacade.find(idCP);
        return cp;
    }

    /*FIN FUNCIONES CASOS DE PRUEBA */
    @Override
    public List<Usuario> getAlumnosByCorrectorComunidad(int idCorrector, int idComunidad) {
        List<Practica> ps = practidaFacade.findAll();

        if (ps == null) {
            return null;
        }

        List<Usuario> users = new ArrayList();
        for (Practica p : ps) {
            if (p.getCorrector().getIdUsuario() == idCorrector && p.getComunidadidComunidad().getIdComunidad() == idComunidad && !userExist(users, p.getRealizador().getIdUsuario())) {
                users.add(p.getRealizador());
            }
        }

        if (users.isEmpty()) {
            return null;
        }

        return users;
    }

    public boolean userExist(List<Usuario> u, int idU) {
        if (u.isEmpty()) {
            return false;
        }
        for (Usuario user : u) {
            if (user.getIdUsuario() == idU) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Pa> getPA(int idHU) {

        List<Pa> pas = paFacade.findAll();

        if (pas == null) {
            return null;
        }

        List<Pa> response = new ArrayList();

        for (Pa x : pas) {
            if (x.getHUidHU().getIdHU() == idHU) {
                response.add(x);
            }
        }

        if (response.isEmpty()) {
            return null;
        }

        return response;
    }

    @Override
    public List<Pa> getPAS() {
        List<Pa> pas = paFacade.findAll();
        return pas;
    }

    @Asynchronous
    public void sendEmailPractica(Practica practica, String tipo) {
        System.out.println("Start running asyncMethod in thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(0);
            String username = "rapsodiatest@gmail.com";
            String password = "rapsodia1";

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);

            String message = "";
            String subject = "";
            String toEmail = "";
            if (tipo.equals("cpa")) {
                //creación nueva practica
                message = "Se ha iniciado una nueva práctica en la terminal bancaria, la cual tiene como corrector al " + practica.getCorrector().getTipoUsuarioidTipoUsuario().getNombreTU() + " " + practica.getCorrector().getNombreU() + " " + practica.getCorrector().getApellidoU() + ". La práctica pertenece a la comunidad " + practica.getComunidadidComunidad().getNombreC() + " y su identificador es " + practica.getIdentificadorPractica() + ", ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Nueva práctica terminal bancaria";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("cpc")) {
                //creación nueva practica
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " ha iniciado una nueva práctica en la terminal bancaria, la cual pertenece a la comunidad " + practica.getComunidadidComunidad().getNombreC() + " y posee el identificador " + practica.getIdentificadorPractica() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Nueva práctica terminal bancaria";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("cpa2")) {
                //creación nueva practica
                message = "Se ha iniciado la práctica número 2 en la terminal bancaria, la cual tiene como corrector al " + practica.getCorrector().getTipoUsuarioidTipoUsuario().getNombreTU() + " " + practica.getCorrector().getNombreU() + " " + practica.getCorrector().getApellidoU() + ". La práctica pertenece a la comunidad " + practica.getComunidadidComunidad().getNombreC() + " y su identificador es " + practica.getIdentificadorPractica() + ", ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Práctica 2 terminal bancaria";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("cpc2")) {
                //creación nueva practica
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " ha iniciado la práctica número 2 en la terminal bancaria, la cual pertenece a la comunidad " + practica.getComunidadidComunidad().getNombreC() + " y posee el identificador " + practica.getIdentificadorPractica() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Práctica 2 terminal bancaria";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("epa")) {
                //eliminación practica
                message = "Se ha eliminado la práctica en la terminal bancaria de la comunidad " + practica.getComunidadidComunidad().getNombreC() + " con identificador " + practica.getIdentificadorPractica() + ". Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Eliminación práctica terminal bancaria";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("epc")) {
                //eliminación practica
                message = "Se ha eliminado la práctica en la terminal bancaria de la comunidad " + practica.getComunidadidComunidad().getNombreC() + " con identificador " + practica.getIdentificadorPractica() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Eliminación práctica terminal bancaria";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("mpc")) {
                //mensaje corrector
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " le ha enviado un mensaje a través de la práctica con identificador " + practica.getIdentificadorPractica() + "perteneciente a la comunidad " + practica.getComunidadidComunidad().getNombreC() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Mensaje práctica terminal bancaria";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("mpa")) {
                //mensaje alumno
                message = "El " + practica.getCorrector().getTipoUsuarioidTipoUsuario().getNombreTU() + " " + practica.getCorrector().getNombreU() + " " + practica.getCorrector().getApellidoU() + " le ha enviado un mensaje a través de la práctica con identificador " + practica.getIdentificadorPractica() + "perteneciente a la comunidad " + practica.getComunidadidComunidad().getNombreC() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Mensaje práctica terminal bancaria";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("pec")) {
                //mensaje corrector
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " ha enviado a corrección la práctica con identificador " + practica.getIdentificadorPractica() + " perteneciente a la comunidad " + practica.getComunidadidComunidad().getNombreC() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Práctica terminal bancaria enviada a corrección";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("pec2")) {
                //mensaje corrector
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " ha enviado a corrección la práctica número 2 con identificador " + practica.getIdentificadorPractica() + " perteneciente a la comunidad " + practica.getComunidadidComunidad().getNombreC() + "\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Práctica terminal bancaria enviada a corrección";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("pev")) {
                //mensaje realizador
                message = "La práctica con identificador " + practica.getIdentificadorPractica() + " perteneciente a la comunidad " + practica.getComunidadidComunidad().getNombreC() + " ha sido evaluada, ahora posee acceso a la siguiente práctica de la terminal\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Práctica terminal bancaria evaluada";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("pev2")) {
                //mensaje realizador
                message = "La práctica número 2 con identificador " + practica.getIdentificadorPractica() + " perteneciente a la comunidad " + practica.getComunidadidComunidad().getNombreC() + " ha sido evaluada, de esta manera se concluye la práctica de la terminal bancaria.\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Práctica terminal bancaria evaluada";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("sc")) {
                //mensaje realizador
                message = "El " + practica.getCorrector().getTipoUsuarioidTipoUsuario().getNombreTU() + " " + practica.getCorrector().getNombreU() + " " + practica.getCorrector().getApellidoU() + " de la comunidad " + practica.getComunidadidComunidad().getNombreC() + " ya no es parte de Rapsodia, por lo tanto las prácticas realizadas con él serán eliminadas\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Corrector práctica terminal bancaria";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("sr")) {
                //mensaje realizador
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " de la comunidad " + practica.getComunidadidComunidad().getNombreC() + " ya no es parte de Rapsodia, por lo tanto las prácticas realizadas con él serán eliminadas\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Alumno práctica terminal bancaria";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("cr")) {
                //mensaje corrector
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " de la comunidad " + practica.getComunidadidComunidad().getNombreC() + " ha cerrado su cuenta en Rapsodia,\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Alumno práctica terminal bancaria";
                toEmail = practica.getCorrector().getEmailU();
            } else if (tipo.equals("cc")) {
                //mensaje realizador
                message = "El " + practica.getCorrector().getNombreU() + " " + practica.getCorrector().getApellidoU() + " de la comunidad " + practica.getComunidadidComunidad().getNombreC() + " ha cerrado su cuenta en Rapsodia,\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Corrector práctica terminal bancaria";
                toEmail = practica.getRealizador().getEmailU();
            } else if (tipo.equals("ar")) {
                //mensaje corrector
                message = "El Alumno " + practica.getRealizador().getNombreU() + " " + practica.getRealizador().getApellidoU() + " de la comunidad " + practica.getComunidadidComunidad().getNombreC() + " en la práctica " + practica.getIdentificadorPractica() + "ha registrado su ambiente de trabajo y repositorio,\n. Ingrese ahora a la plataforma: " + "http://memoriaseba.zapto.org/rapsodia";
                subject = "[Rapsodia] Ambiente y repositorio práctica terminal bancaria";
                toEmail = practica.getCorrector().getEmailU();
            }

            Message mailMessage = new MimeMessage(mailSession);
            mailMessage.setFrom(new InternetAddress("rapsodiatest@gmail.com"));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessage.setContent(message, "text/html");
            mailMessage.setSubject(subject);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);

            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

        } catch (MessagingException ex) {
            Logger.getLogger(UsuarioEJB.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished running asyncMethod in thread " + Thread.currentThread().getName());

    }

    //Sprint 3.3
    //Sprint 3.4
    @Override
    public Practica1 getPractica1ByIdentificarP(String identificadorP, int idComunidad, String rut) {
        List<Practica1> p1 = practica1Facade.findAll();

        if (p1 == null) {
            return null;
        }

        for (Practica1 p : p1) {
            if (p.getPractica().getComunidadidComunidad().getIdComunidad() == idComunidad && p.getPractica().getIdentificadorPractica().equals(identificadorP) && p.getPractica().getRealizador().getRutU().equals(rut)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String crearPracticaP2(String identificadorP, int idC, String rut) {
        Practica p = getPracticaByIdentificadorComunidad(identificadorP, idC, rut);
        if (p == null) {
            return "f";
        }

        Practica2 p2 = new Practica2();
        p2.setCalificacion(0);
        p2.setFechaInicio(new Date());
        p2.setPractica(p);
        p2.setTutorial(Boolean.TRUE);
        p2.setObservacion("");
        p2.setUrlCodenvy("");
        p2.setUrlGithub("");

        Estadop ep = estadoPFacade.findByNombre("Desarrollo P2");
        if (ep == null) {
            return "f";
        }
        p.setEstadoPidEstadoP(ep);

        //estoy cambiando el estado de la práctica de corregida p1 a desarrollo p2
        String res = practidaFacade.correccionPractica(p);
        String re = practica2Facade.createPractica2(p2);
        String response = "f";
        if (res.equals("t") && re.equals("t")) {
            response = "t";
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "cpa2");
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p, "cpc2");
        }

        return response;
    }

    @Override
    public Practica2 getPractica2ByIdentificarP(String identificadorP, int idComunidad, String rut) {
        List<Practica2> p2 = practica2Facade.findAll();

        if (p2 == null) {
            return null;
        }

        for (Practica2 p : p2) {
            if (p.getPractica().getComunidadidComunidad().getIdComunidad() == idComunidad && p.getPractica().getIdentificadorPractica().equals(identificadorP) && p.getPractica().getRealizador().getRutU().equals(rut)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String enviarACorreccionP2(int idP2) {
        Practica2 p2 = practica2Facade.find(idP2);
        if (p2 == null) {
            return "f";
        }

        Estadop ep = estadoPFacade.findByNombre("Corregir P2");
        if (ep == null) {
            return "f";
        }

        Practica practica = p2.getPractica();
        practica.setEstadoPidEstadoP(ep);

        String r1 = practidaFacade.correccionPractica(practica);
        if (r1.equals("t")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(practica, "pec2");
        }

        return r1;
    }

    @Override
    public String guardarAR(Practica2 p2) {
        Practica2 prev = practica2Facade.find(p2.getIdPractica2());

        UrlValidator validar = new UrlValidator();

        if (!validar.isValid(p2.getUrlCodenvy()) || !validar.isValid(p2.getUrlGithub())) {
            return "i";
        }

        if (p2.getUrlCodenvy().equals(prev.getUrlCodenvy()) && p2.getUrlGithub().equals(prev.getUrlGithub())) {
            return "e";
        }

        String response = practica2Facade.guardarAR(p2);

        if (response.equals("t")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(p2.getPractica(), "ar");
        }

        return response;
    }

    @Override
    public String evaluarP2(int idP2, int nota, String obs) {
        Practica2 p2 = practica2Facade.find(idP2);

        if (p2 == null) {
            return "f";
        }

        if (nota > 70) {
            return "e";
        } else if (nota < 10) {
            return "i";
        }

        Estadop ep = estadoPFacade.findByNombre("Finalizada");

        if (ep == null) {
            return "f";
        }

        Practica practica = p2.getPractica();
        practica.setEstadoPidEstadoP(ep);
        Practica1 p1 = getPractica1ByIdentificarP(practica.getIdentificadorPractica(), practica.getComunidadidComunidad().getIdComunidad(), p2.getPractica().getRealizador().getRutU());
        int notaF = (p1.getCalificacion() + nota) / 2;
        practica.setCalificacion(notaF);
        practica.setFechaTermino(new Date());
        p2.setCalificacion(nota);
        p2.setObservacion(obs);
        p2.setFechaTermino(new Date());

        String res = practica2Facade.evaluarP2(p2);
        String r = practidaFacade.correccionPractica(practica);

        if (res.equals("t") && r.equals("t")) {
            sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailPractica(practica, "pev2");
        }

        return res;
    }

    // Sprint 3.4
    //Sprint 3.5
    @Override
    public String configurarNota(int idC, int nota) {

        Comunidad c = comunidadFacade.find(idC);

        if (c == null) {
            return "false";
        }

        if (nota > 70) {
            return "e";
        } else if (nota < 10) {
            return "i";
        } else if (nota == c.getNotaMinima()) {
            return "eq";
        }

        c.setNotaMinima(nota);

        String response = comunidadFacade.editarComunidad(c);
        if (response.equals("true")) {
            //Profesor
            List<Usuario> ayudantes = getAyudantesByComunidad(c.getIdComunidad());
            List<Usuario> alumnos = getAlumnosByComunidad(c.getIdComunidad());
            if (ayudantes != null) {
                for (Usuario a : ayudantes) {
                    sctx.getBusinessObject(UsuarioEJBLocal.class).sendEmailComunidad(a, c, "cn");
                }
            }

            if (alumnos != null) {
                //cambiamos el acceso a la práctica en base a la nueva nota
                for (Usuario alum : alumnos) {

                    Comunidadasociado ca = comunidadAsociadoFacade.findByCA(c.getIdComunidad(), alum.getIdUsuario());
                    if (ca != null) {

                        Pruebateorica pt = getPruebaTeoria(alum.getIdUsuario(), c.getIdComunidad());
                        if (pt != null) {
                            if (pt.getNota() >= nota) {
                                if (!ca.getAccesoPractica()) {
                                    ca.setAccesoPractica(true);
                                    comunidadAsociadoFacade.edit(ca);
                                }

                            } else if (pt.getNota() < nota) {
                                if (ca.getAccesoPractica()) {
                                    ca.setAccesoPractica(false);
                                    comunidadAsociadoFacade.edit(ca);
                                }
                            }
                        }
                    }
                }

            }
            return "true";
        }
        return "false";
    }

    @Override
    public Comunidad getComunidad(int idC) {
        Comunidad c = comunidadFacade.find(idC);
        if (c != null) {
            return c;
        }
        return null;
    }

    @Override
    public Pruebateorica getPruebaTeoria(int idU, int idC) {
        Usuario u = usuarioFacade.find(idU);
        Comunidad c = comunidadFacade.find(idC);

        if (u == null || c == null) {
            return null;
        }

        List<Pruebateorica> pt = pruebateoricaFacade.findAll();

        if (pt == null) {
            return null;
        }

        for (Pruebateorica p : pt) {
            if (p.getUsuarioRealizador().getIdUsuario() == idU && p.getComunidad().getIdComunidad() == idC) {
                return p;
            }
        }

        return null;
    }

    @Override
    public List<Area> getAreasReforzar(int idPT) {

        List<Areareforzar> ar = areareforzarFacade.findAll();

        if (ar == null) {
            return null;
        }
        List<Area> areas = new ArrayList();
        for (Areareforzar a : ar) {
            if (a.getPruebaTeorica().getIdPT() == idPT) {
                areas.add(a.getArea());
            }
        }

        if (areas.isEmpty()) {
            return null;
        }

        return areas;

    }

    @Override
    public List<Pregunta> getPreguntas() {
        List<Pregunta> p = preguntaFacade.findAll();
        return p;
    }

    @Override
    public String corregirPT(List<Pregunta> respuestas, int idComunidad, int idAlumno) {

        List<Pregunta> preguntas = preguntaFacade.findAll();
        int pregBuenas = 0;
        int notaFinal = 10;
        List<Area> areasReforzar = new ArrayList();

        Comunidad c = comunidadFacade.find(idComunidad);
        Usuario u = usuarioFacade.find(idAlumno);

        if (c == null || u == null || preguntas == null) {
            return "f";
        }

        for (Pregunta p : preguntas) {
            for (Pregunta r : respuestas) {
                if (p.getIdPregunta() == r.getIdPregunta()) {
                    if (p.getRespuesta().equals(r.getRespuesta())) {
                        pregBuenas++;
                    } else {
                        //buscar areas que debe reforzar
                        List<Area> aux = getAreaP(p.getIdPregunta());
                        if (aux != null) {
                            for (Area aux1 : aux) {
                                if (!existArea(areasReforzar, aux1.getIdArea())) {
                                    areasReforzar.add(aux1);
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        //Consulto si la habia una prueba previa
        Pruebateorica prev = getPruebaTeoria(idAlumno, idComunidad);
        //Calculando nota del alumno

        notaFinal = calcularNota(pregBuenas, preguntas.size());

        if (prev != null) {
            prev.setFechaRealizado(new Date());
            prev.setNota(notaFinal);

            String resEdit = pruebateoricaFacade.editarPruebaTeorica(prev);
            if (resEdit.equals("true")) {
                //Eliminar areas que existen
                String deleteAR = areareforzarFacade.deleteAreaReforzar(prev.getIdPT());

                if (deleteAR.equals("f")) {
                    return "f";
                }

                if (areasReforzar != null) {
                    for (Area a : areasReforzar) {
                        if (areareforzarFacade.crearAreaReforzar(a, prev).equals("f")) {
                            return "f";
                        }
                    }
                }
                Comunidadasociado ca = comunidadAsociadoFacade.findByCA(c.getIdComunidad(), u.getIdUsuario());

                if (notaFinal >= c.getNotaMinima()) {
                    //tiene acceso a la prueba práctica
                    ca.setAccesoPractica(true);
                    comunidadAsociadoFacade.edit(ca);
                } else {
                    //se le quita el acceso
                    ca.setAccesoPractica(false);
                    comunidadAsociadoFacade.edit(ca);
                }

                return "t";
            }
            return "f";
        } else {
            prev = new Pruebateorica();
            prev.setComunidad(c);
            prev.setFechaRealizado(new Date());
            prev.setNota(notaFinal);
            prev.setUsuarioRealizador(u);

            String response = pruebateoricaFacade.crearPruebaTeorica(prev);

            if (response.equals("t")) {
                //Agregar las areas a reforzar
                if (areasReforzar != null) {
                    for (Area a : areasReforzar) {
                        if (areareforzarFacade.crearAreaReforzar(a, prev).equals("f")) {
                            return "f";
                        }
                    }
                }
                Comunidadasociado ca = comunidadAsociadoFacade.findByCA(c.getIdComunidad(), u.getIdUsuario());

                if (notaFinal >= c.getNotaMinima()) {
                    //tiene acceso a la prueba práctica
                    ca.setAccesoPractica(true);
                    comunidadAsociadoFacade.edit(ca);
                } else {
                    //se le quita el acceso
                    ca.setAccesoPractica(false);
                    comunidadAsociadoFacade.edit(ca);
                }
                return "t";
            }

            return "f";
        }

    }

    public int calcularNota(int puntajeObtenido, int cantidadPreguntas) {

        int notaFinal = 0;
        //se busca la cantidad de puntos para obtener el 40, si son 10 preguntas son 6 preguntas buenas
        int media = (int) (cantidadPreguntas * 0.6);

        if (puntajeObtenido > media) {
            notaFinal = (puntajeObtenido * 70) / cantidadPreguntas;
        } else if (puntajeObtenido == 0) {
            return 10;
        } else {
            notaFinal = (puntajeObtenido * 40) / media;
        }

        return notaFinal;

    }

    public boolean existArea(List<Area> areas, int idArea) {
        for (Area a : areas) {
            if (a.getIdArea() == idArea) {
                return true;
            }
        }

        return false;
    }

    public List<Area> getAreaP(int idP) {
        List<Areapregunta> ap = areaPreguntaFacade.findAll();

        if (ap == null) {
            return null;
        }
        List<Area> response = new ArrayList();
        for (Areapregunta a : ap) {
            if (a.getPregunta().getIdPregunta() == idP) {
                response.add(a.getArea());
            }
        }

        if (response.isEmpty()) {
            return null;
        }

        return response;
    }

    @Override
    public boolean accesoPractica(int idC, int idU) {
        Comunidadasociado ca = comunidadAsociadoFacade.findByCA(idC, idU);
        if (ca == null) {
            return false;
        }
        return ca.getAccesoPractica();
    }

    //Sprint 3.5
}
