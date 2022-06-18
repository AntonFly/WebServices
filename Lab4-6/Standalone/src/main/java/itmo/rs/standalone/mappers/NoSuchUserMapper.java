package itmo.rs.standalone.mappers;

import itmo.rs.standalone.exceptions.NoSuchUserException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoSuchUserMapper implements ExceptionMapper<NoSuchUserException> {
    @Override
    public Response toResponse(NoSuchUserException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
