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
import sessionbeans.ModuloDEJBLocal;

/**
 *
 * @author Sebastian
 */
@Stateless
@Path("moduloD")
public class ModuloDService {

    @EJB
    private ModuloDEJBLocal moduloDEJB;

    @POST
    @Path("loginD/{rut}/{pass}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response loginD(@PathParam("rut") String rut, @PathParam("pass") String pass) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloDEJB.loginD(rut, pass));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("depositarD/{rut}/{monto}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response depositar(@PathParam("rut") String rut, @PathParam("monto") int monto) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloDEJB.depositarD(rut, monto));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("retirarD/{rut}/{monto}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response retirarD(@PathParam("rut") String rut, @PathParam("monto") int monto) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloDEJB.retirarD(rut, monto));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @POST
    @Path("transferirD/{rutR}/{rutRE}/{monto}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response transferirD(@PathParam("rutR") String rutR, @PathParam("rutRE") String rutRE, @PathParam("monto") int monto) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloDEJB.transferirD(rutR, rutRE, monto));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getOperacionD/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Operacion> getOp(@PathParam("rut") String rut) {
        List<Operacion> op = moduloDEJB.getOperacionD(rut);
        return op;
    }

    @POST
    @Path("cerrarC/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response updateEstadoC(@PathParam("rut") String rut) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", moduloDEJB.cerrarC(rut));
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.status(Response.Status.OK).entity(jsonObj).build();
    }

    @GET
    @Path("getUserByRutD/{rut}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Cuenta getUserByEmail(@PathParam("rut") String rut) {
        Cuenta usuario = moduloDEJB.getByRutD(rut);
        return usuario;
    }
}
