package itmo.rs.standalone.mappers;



import itmo.rs.standalone.exceptions.AuthException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthExceptionMapper implements ExceptionMapper<AuthException> {
    @Override
    public Response toResponse(AuthException exception) {
        return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
    }
}