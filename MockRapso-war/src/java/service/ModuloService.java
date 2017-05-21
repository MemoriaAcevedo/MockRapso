/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Cuenta;
import entities.Operacion;
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
import sessionbeans.ModuloEJBLocal;

/**
 *
 * @author Sebastian
 */
@Stateless
@Path("modulo")
public class ModuloService {

    @EJB
    private ModuloEJBLocal moduloEJB;

    @POST
    @Path("login/{rut}/{pass}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response login(@PathParam("rut") String rut, @PathParam("pass") String pass) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloEJB.login(rut, pass));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getUserByRut/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Cuenta getUserByRut(@PathParam("rut") String rut) {
        Cuenta usuario = moduloEJB.getByRut(rut);
        return usuario;
    }

    @POST
    @Path("depositar/{rut}/{monto}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response depositar(@PathParam("rut") String rut, @PathParam("monto") int monto) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloEJB.depositar(rut, monto));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("retirar/{rut}/{monto}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response retirar(@PathParam("rut") String rut, @PathParam("monto") int monto) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloEJB.retirar(rut, monto));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("transferir/{rutR}/{rutRE}/{monto}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response transferir(@PathParam("rutR") String rutR, @PathParam("rutRE") String rutRE, @PathParam("monto") int monto) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloEJB.transferir(rutR, rutRE, monto));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getOperacion/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Operacion> getOp(@PathParam("rut") String rut) {
        List<Operacion> op = moduloEJB.getOperacion(rut);
        return op;
    }
    
    @POST
    @Path("updateEC/{rut}/{tipo}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response updateEstadoC(@PathParam("rut") String rut, @PathParam("tipo") String tipo) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloEJB.updateEstadoC(rut, tipo));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }
}
