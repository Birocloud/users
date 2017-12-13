package com.biro.cloud.users.api.v1.resources;


import com.biro.cloud.users.api.v1.config.InfoProperties;

import javax.inject.Inject;
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

    @Inject
    private InfoProperties infoProperties;

    @GET
    @Path("/info")
    public Response getInfo() {

        Info info = new Info();
        try {
            info.mikrostoritve.set(0, infoProperties.getUsersMicroserviceAddress() + "/v1/users");
            info.mikrostoritve.set(1, infoProperties.getAccountOptionsMicroserviceAddress() + "/v1/accountoptions");
        } catch (Exception e) {}
        return Response.status(Response.Status.OK).entity(info).build();
    }

}
