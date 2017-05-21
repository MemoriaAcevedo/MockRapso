/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Area;
import entities.Casoprueba;
import entities.Comunidad;
import entities.Estado;
import entities.Estadoc;
import entities.Estadoi;
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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface UsuarioEJBLocal {

    String login(String email, String pass);

    Usuario getUserByEmail(String emailU);

    String crearUsuario(Usuario newU);

    List<Tipousuario> getTipoUsuarios();

    List<Estado> getEstados();

    Usuario editarUsuario(Usuario uEdit);

    String cerrarC(String rutU, String motivo);

    Usuario activarC(String rutU);

    List<Usuario> getAllUsers();

    void sendEmail(String toEmail, String tipo);

    String eliminarC(String rutU);

    List<Usuario> getAllE(String tipo);

    String asociarAComunidad(String nombreC, String rutA);

    List<Tipousuario> getTUCustom();

    String desligar(int idC, int idA);

    //SPRINT1.3
    String crearComunidad(String emailP, String nombreC, String descripcionC);

    List<Comunidad> getAllComunidades();

    List<Usuario> getAlumnosByComunidad(int idC
    );

    Comunidad getComunidadByNombre(String nombre);

    String editarComunidad(Comunidad c);

    String eliminarComunidad(Comunidad c);

    List<Comunidad> getCByProfesor(int idP);

    List<Comunidad> getCByAA(int idAA);

    //SPRINT 3.3
    String crearPractica(String rutR, int idC);

    List<Practica> getPracticasByAlumnoComunidad(int idU, int idC);

    List<Practica> getPracticasByAlumnoCorrectorComunidad(int idA, int idCorrector, int idComunidad);

    String eliminarPractica(int idP);

    Practica getPractica(int idP);

    String crearIncidencia(Incidencia i);

    List<Incidencia> incidenciasByPractica(int idP);

    List<Incidenciacp> getIncidenciasCPByPractica(int idP);

    List<Incidenciacp> getIncidenciasCasoPrueba(int idCasoprueba);

    List<Casoprueba> getCasosPruebaByPractica(int idP);

    String crearIncidenciacp(Incidenciacp i);

    List<Estadoi> getEstadosI();

    String actualizarIncidencia(Incidencia i);

    String eliminarI(int idI);

    String actualizarIncidenciaCP(Incidenciacp i);

    String eliminarICP(int idI);

    List<Hu> getHU();

    List<Estadoc> getEstadoCP();

    String crearCP(Casoprueba cp);

    String actualizarCP(Casoprueba c);

    String eliminarCP(int idC);

    String enviarACorreccionP1(int idP);

    String crearMensaje(int idP, String mensaje, String tipo);

    List<Mensaje> getMensajesP(int idP);

    List<Usuario> getAlumnosByCorrectorComunidad(int idCorrector, int idComunidad);

    String evaluarP1(int idP1, int nota, String obs);

    List<Pa> getPA(int idHU);

    List<Pa> getPAS();

    void sendEmailPractica(Practica practica, String tipo);

    Casoprueba getCasoPrueba(int idCP);

    Incidencia getIncidencia(int idI);

    Incidenciacp getIncidenciacp(int idICP);
    
    Practica getPracticaByIdentificadorComunidad(String idP, int idC, String rut);

    List<Practica> getPracticasByCorrectorComunidad(int idU, int idC);

    //SPRINT 3.4
    Practica1 getPractica1ByIdentificarP(String identificadorP, int idComunidad, String rut);
  
    String crearPracticaP2(String identificadorP, int idC, String rut);

    Practica2 getPractica2ByIdentificarP(String identificadorP, int idComunidad, String rut);

    String enviarACorreccionP2(int idP2);

    String guardarAR(Practica2 p2);

    String evaluarP2(int idP2, int nota, String obs);

    void sendEmailComunidad(Usuario u, Comunidad c, String tipo);

    //SPRINT 3.5
    String configurarNota(int idC, int nota);

    Comunidad getComunidad(int idC);

    Pruebateorica getPruebaTeoria(int idU, int idC);

    List<Area> getAreasReforzar(int idPT);

    List<Pregunta> getPreguntas();

    String corregirPT(List<Pregunta> respuestas, int idComunidad, int idAlumno);

    boolean accesoPractica(int idC, int idU);
}
