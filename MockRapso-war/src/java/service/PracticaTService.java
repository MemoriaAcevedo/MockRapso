/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Mensaje.MensajeService;
import Mensaje.RespuestasService;
import entities.Area;
import entities.Casoprueba;
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
import entities.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import sessionbeans.UsuarioEJBLocal;

/**
 *
 * @author Sebastian
 */
@Stateless
@Path("practicaT")
public class PracticaTService {

    @EJB
    public UsuarioEJBLocal usuarioEJB;

    @POST
    @Path("crearP/{rutU}/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearP(@PathParam("rutU") String rut, @PathParam("idC") int idC) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearPractica(rut, idC));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getPracticasByAlumnoComunidad/{idU}/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Practica> getPracticasByAlumnoComunidad(@PathParam("idU") int idU, @PathParam("idC") int idC) {
        return usuarioEJB.getPracticasByAlumnoComunidad(idU, idC);
    }

    @GET
    @Path("getPracticasByAlumnoCorrectorComunidad/{idU}/{idCorrector}/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Practica> getPracticasByAlumnoCorrectorComunidad(@PathParam("idU") int idU, @PathParam("idCorrector") int idCorrector, @PathParam("idC") int idC) {
        return usuarioEJB.getPracticasByAlumnoCorrectorComunidad(idU, idCorrector, idC);
    }

    @POST
    @Path("eliminarP/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response eliminarP(@PathParam("idP") int idP) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.eliminarPractica(idP));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getP/{identificadorP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Practica getP(@PathParam("identificadorP") int identificadorP) {
        return usuarioEJB.getPractica(identificadorP);
    }

    @GET
    @Path("getPracticaByIdentificadorComunidadRut/{identificarP}/{idC}/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Practica getPracticaByIdentificador(@PathParam("identificarP") String identificarP, @PathParam("idC") int idC, @PathParam("rut") String rut) {
        return usuarioEJB.getPracticaByIdentificadorComunidad(identificarP, idC, rut);
    }

    @POST
    @Path("crearIncidencia")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearI(Incidencia i) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearIncidencia(i));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("crearIncidenciacp")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearICP(Incidenciacp i) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearIncidenciacp(i));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getIncidenciasP/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Incidencia> getIncidenciasP(@PathParam("idP") int idP) {
        return usuarioEJB.incidenciasByPractica(idP);
    }

    @GET
    @Path("getIncidenciasCP/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Incidenciacp> getIncidenciasCP(@PathParam("idP") int idP) {
        return usuarioEJB.getIncidenciasCPByPractica(idP);
    }

    @GET
    @Path("getCasosP/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Casoprueba> getCasosP(@PathParam("idP") int idP) {
        return usuarioEJB.getCasosPruebaByPractica(idP);
    }

    @GET
    @Path("getEstadoI")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Estadoi> getEstadoI() {
        return usuarioEJB.getEstadosI();
    }

    @POST
    @Path("editarIncidencia")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response editarIncidencia(Incidencia i) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.actualizarIncidencia(i));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("eliminarIncidencia/{idI}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response eliminarIncidencia(@PathParam("idI") int idI) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.eliminarI(idI));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("editarIncidenciacp")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response editarIncidenciacp(Incidenciacp i) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.actualizarIncidenciaCP(i));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("eliminarIncidenciacp/{idI}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response eliminarIncidenciacp(@PathParam("idI") int idI) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.eliminarICP(idI));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getHU")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Hu> getHU() {
        return usuarioEJB.getHU();
    }

    @GET
    @Path("getEstadoCP")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Estadoc> getEstadoCP() {
        return usuarioEJB.getEstadoCP();
    }

    @POST
    @Path("crearCP")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearCP(Casoprueba cp) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearCP(cp));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getCPByPractica/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Casoprueba> getCPByPractica(@PathParam("idP") int idP) {
        return usuarioEJB.getCasosPruebaByPractica(idP);
    }

    @GET
    @Path("getIByCP/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Incidenciacp> getIByCP(@PathParam("idC") int idC) {
        return usuarioEJB.getIncidenciasCasoPrueba(idC);
    }

    @POST
    @Path("editarCP")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response editarCP(Casoprueba c) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.actualizarCP(c));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("eliminarCP/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response eliminarCP(@PathParam("idC") int idC) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.eliminarCP(idC));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("correccionP/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response coreccionP(@PathParam("idP") int idP) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.enviarACorreccionP1(idP));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getMensajesP/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Mensaje> getMensajesP(@PathParam("idP") int idP) {
        return usuarioEJB.getMensajesP(idP);
    }

    @POST
    @Path("crearMensaje")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearMensaje(MensajeService m) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearMensaje(m.idP, m.mensaje, m.tipo));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getAlumnosByCorrectorComunidad/{idCorrector}/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Usuario> getAlumnosByCorrectorComunidad(@PathParam("idCorrector") int idCorrector, @PathParam("idC") int idC) {
        return usuarioEJB.getAlumnosByCorrectorComunidad(idCorrector, idC);
    }

    @POST
    @Path("evaluarP/{idP}/{nota}/{obs}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response evaluarP1(@PathParam("idP") int idP, @PathParam("nota") int nota, @PathParam("obs") String obs) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.evaluarP1(idP, nota, obs));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getPA/{idHU}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Pa> getPA(@PathParam("idHU") int idHU) {
        return usuarioEJB.getPA(idHU);
    }

    @GET
    @Path("getPAS")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Pa> getPAS() {
        return usuarioEJB.getPAS();
    }

    @GET
    @Path("getCasoPrueba/{idCP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Casoprueba getCasoPrueba(@PathParam("idCP") int idCP) {
        return usuarioEJB.getCasoPrueba(idCP);
    }

    @GET
    @Path("getIncidencia/{idI}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Incidencia getIncidencia(@PathParam("idI") int idI) {
        return usuarioEJB.getIncidencia(idI);
    }

    @GET
    @Path("getIncidenciacp/{idICP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Incidenciacp getIncidenciacp(@PathParam("idICP") int idICP) {
        return usuarioEJB.getIncidenciacp(idICP);
    }

    //SPRINT 3.4
    @GET
    @Path("getPractica1ByIdentificadorP/{idP}/{idC}/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Practica1 getPractica1ByIdentificadorP(@PathParam("idP") String idP, @PathParam("idC") int idC, @PathParam("rut") String rut) {
        return usuarioEJB.getPractica1ByIdentificarP(idP, idC, rut);
    }

    @GET
    @Path("getPractica2ByIdentificadorP/{idP}/{idC}/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Practica2 getPractica2ByIdentificarP(@PathParam("idP") String idP, @PathParam("idC") int idC, @PathParam("rut") String rut) {
        return usuarioEJB.getPractica2ByIdentificarP(idP, idC, rut);
    }

    @POST
    @Path("crearPractica2/{identificadorP}/{idC}/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearP2(@PathParam("identificadorP") String identificadorP, @PathParam("idC") int idC, @PathParam("rut") String rut) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearPracticaP2(identificadorP, idC, rut));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("correccionP2/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response coreccionP2(@PathParam("idP") int idP) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.enviarACorreccionP2(idP));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("guardarAR")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response guardarAR(Practica2 p2) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.guardarAR(p2));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("evaluarP2/{idP2}/{nota}/{obs}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response evaluarP2(@PathParam("idP2") int idP2, @PathParam("nota") int nota, @PathParam("obs") String obs) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.evaluarP2(idP2, nota, obs));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    //SPRINT 3.5
    @POST
    @Path("configurarPT/{idC}/{nota}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response configurarPT(@PathParam("idC") int idC, @PathParam("nota") int nota) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.configurarNota(idC, nota));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }
    
    @GET
    @Path("getPracticaTeorica/{idU}/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Pruebateorica getPracticaTeorica(@PathParam("idU") int idU, @PathParam("idC") int idC) {
        return usuarioEJB.getPruebaTeoria(idU, idC);
    }
    
    @GET
    @Path("getAreasReforzar/{idPT}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Area> getAreasReforzar(@PathParam("idPT") int idPT) {
        return usuarioEJB.getAreasReforzar(idPT);
    }
    
    @GET
    @Path("getPreguntas")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Pregunta> getPreguntas() {
        return usuarioEJB.getPreguntas();
    }
    
    @POST
    @Path("corregirPT")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response corregirPT(RespuestasService rs ) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.corregirPT(rs.respuestas, rs.idComunidad, rs.idAlumno));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }
}
