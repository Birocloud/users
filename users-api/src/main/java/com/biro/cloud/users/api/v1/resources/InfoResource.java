package com.biro.cloud.users.api.v1.resources;

// jax-rs
import com.biro.cloud.users.persistence.v1.Users;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

// other
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InfoResource {

    @GET
    @Path("/info")
    public Response getInfo() {

        Info info = new Info();

        return Response.status(Response.Status.OK).entity(info).build();
    }
    
}
