package pl.gda.pg.eti.kask.javaee.jsf.api;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.uri;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.KeypartsService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Keypart;

@Path("/books")
public class KeypartsController {

    @Inject
    KeypartsService keypartsService;

    @GET
    public Collection<Keypart> getAllKeyparts() {
        return keypartsService.findAllKeyparts();
    }

    @POST
    public Response saveKeypart(Keypart keypart) {
        keypartsService.saveKeypart(keypart);
        return created(uri(KeypartsController.class, "get", keypart.getId())).build();
    }

//    @GET
//    @Path("/{bookId}")
//    public Response getBook(@PathParam("bookId") Integer bookId) {
//        Book book = bookService.findBook(bookId);
//
//        if (book == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//
//        return Response.ok(book).build();
//    }

    @GET
    @Path("/{keypart}")
    public Keypart getKeypart(@PathParam("keypart") Keypart keypart) {
        return keypart;
    }

    @DELETE
    @Path("/{keypart}")
    public Response deleteKeypart(@PathParam("keypart") Keypart keypart) {
        keypartsService.removeKeypart(keypart);
        return noContent().build();
    }

    @PUT
    @Path("/{keypart}")
    public Response updateKeypart(@PathParam("keypart") Keypart originalKeypart, Keypart updatedKeypart) {
        if (!originalKeypart.getId().equals(updatedKeypart.getId())) {
            return status(Status.BAD_REQUEST).build();
        }

        keypartsService.saveKeypart(updatedKeypart);
        return ok().build();
    }
}
