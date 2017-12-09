package com.biro.cloud.users.api.v1.resources;

import java.util.List;

// project imports
import com.biro.cloud.users.persistence.v1.Users;
import com.biro.cloud.users.logic.v1.UsersBean;

// jax-rs
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

// other
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private UsersBean usersBean;

    @GET
    public Response getUsers() {

        List<Users> users = usersBean.getUsers();

        return Response.ok(users).build();
    }

    @GET
    @Path("/filtered")
    public Response getUsersFiltered() {

        List<Users> customers;

        customers = usersBean.getUsersFilter(uriInfo);

        return Response.status(Response.Status.OK).entity(customers).build();
    }

}