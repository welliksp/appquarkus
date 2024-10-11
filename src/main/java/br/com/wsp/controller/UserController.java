package br.com.wsp.controller;


import br.com.wsp.entity.User;
import br.com.wsp.service.IUserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @POST
    @Transactional
    public Response save(User user) {


        User userSaved = userService.save(user);

        return Response.ok(userSaved).build();
    }


    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {

        var users = userService.findAll(page, pageSize);

        return Response.ok(users).build();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") UUID id) {

        var users = userService.findById(id);

        return Response.ok(users).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") UUID id, User user) {

        User userSaved = userService.update(id, user);

        return Response.ok(userSaved).build();
    }


    @Path("/{id}")
    @Transactional
    @DELETE
    public Response deleteById(@PathParam("id") UUID id) {

        userService.deleteById(id);

        return Response.noContent().build();
    }

}