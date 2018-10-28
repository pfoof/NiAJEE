package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BookService;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Author;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Owner;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collection;

@Path("/authors")
public class UsersController {

    @Inject
    KeypartsService keypartsService;

    @GET
    public Collection<Owner> getAllUsers() {
        return keypartsService.findAllUsers();
    }

    @GET
    @Path("/{user}")
    public Owner getUser(@PathParam("user") Owner user) {
        return user;
    }

    @DELETE
    @Path("/{user}")
    public void deleteUser(@PathParam("user") Owner user) { keypartsService.removeUser(user); }
}
