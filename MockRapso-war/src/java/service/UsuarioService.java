/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Comunidad;
import entities.Estado;
import entities.Tipousuario;
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
@Path("usuario")
public class UsuarioService {

    @EJB
    private UsuarioEJBLocal usuarioEJB;

    @POST
    @Path("login/{emailU}/{passU}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response login(@PathParam("emailU") String email, @PathParam("passU") String pass) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.login(email, pass));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getUserByEmail/{emailU}")
    @Produces({"application/json"})
    public Usuario getUserByEmail(@PathParam("emailU") String emailU) {
        Usuario usuario = usuarioEJB.getUserByEmail(emailU);
        return usuario;
    }

    @POST
    @Path("cerrarC/{rutU}/{motivo}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response cerrarC(@PathParam("rutU") String rutU, @PathParam("motivo") String motivo) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.cerrarC(rutU, motivo));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("recuperar/{emailU}/{op}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public void recuperarC(@PathParam("emailU") String emailU, @PathParam("op") String op) {
        usuarioEJB.sendEmail(emailU, op);
    }

    @POST
    @Path("activarC/{rutU}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Usuario activarC(@PathParam("rutU") String rutU) {
        return usuarioEJB.activarC(rutU);
    }

    @POST
    @Path("eliminarC/{rutU}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response eliminarC(@PathParam("rutU") String rutU) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.eliminarC(rutU));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("crearUsuario")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearUsuario(Usuario user) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearUsuario(user));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("editarUsuario")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Usuario editarUsuario(Usuario usuario) {
        return usuarioEJB.editarUsuario(usuario);
    }

    @GET
    @Path("estados")
    @Produces({"application/json"})
    public List<Estado> estados() {
        List<Estado> estados = usuarioEJB.getEstados();
        return estados;
    }

    @GET
    @Path("tipoUsuarios")
    @Produces({"application/json"})
    public List<Tipousuario> tipoUsuarios() {
        List<Tipousuario> tipoUsuarios = usuarioEJB.getTipoUsuarios();
        return tipoUsuarios;
    }

    @GET
    @Path("getTUCustom")
    @Produces({"application/json"})
    public List<Tipousuario> getTUCustom() {
        List<Tipousuario> tipoUsuarios = usuarioEJB.getTUCustom();
        return tipoUsuarios;
    }

    @GET
    @Path("getAllUsers")
    @Produces({"application/json"})
    public List<Usuario> getAllUsers() {
        List<Usuario> users = usuarioEJB.getAllUsers();
        return users;
    }

    @GET
    @Path("getAllE/{tipo}")
    @Produces({"application/json"})
    public List<Usuario> getAllE(@PathParam("tipo") String tipo) {
        List<Usuario> users = usuarioEJB.getAllE(tipo);
        return users;
    }

    @POST
    @Path("asociar/{nombreC}/{rutA}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response asociar(@PathParam("nombreC") String nombreC, @PathParam("rutA") String rutA) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.asociarAComunidad(nombreC, rutA));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    //SPRINT 1.3
    @POST
    @Path("crearComunidad/{nombreC}/{descripcionC}/{emailP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearC(@PathParam("nombreC") String nombreC, @PathParam("descripcionC") String descripcionC, @PathParam("emailP") String emailP) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.crearComunidad(emailP, nombreC, descripcionC));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getAllComunidad")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Comunidad> getAllComunidad() {
        return usuarioEJB.getAllComunidades();
    }

    @GET
    @Path("getAsociadosC/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Usuario> getAsociadosC(@PathParam("idC") int id) {
        return usuarioEJB.getAlumnosByComunidad(id);
    }

    @POST
    @Path("desligar/{idC}/{idA}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response desligar(@PathParam("idC") int idC, @PathParam("idA") int idA) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.desligar(idC, idA));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("editarC")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response editarC(Comunidad c) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.editarComunidad(c));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("eliminarComunidad")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response eliminarComunidad(Comunidad c) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.eliminarComunidad(c));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getComunidadesByProfesor/{idP}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Comunidad> getCByP(@PathParam("idP") int idP) {
        return usuarioEJB.getCByProfesor(idP);
    }

    @GET
    @Path("getComunidadesByAA/{idA}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Comunidad> getCByAA(@PathParam("idA") int idA) {
        return usuarioEJB.getCByAA(idA);
    }

    @GET
    @Path("getComunidad/{idC}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Comunidad getComunidad(@PathParam("idC") int idC) {
        return usuarioEJB.getComunidad(idC);
    }

    @GET
    @Path("accesoPractica/{idC}/{idU}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response accesoPractica(@PathParam("idC") int idC, @PathParam("idU") int idU) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", usuarioEJB.accesoPractica(idC, idU));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }
}
