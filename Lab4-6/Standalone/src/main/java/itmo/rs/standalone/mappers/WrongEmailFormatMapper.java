package itmo.rs.standalone.mappers;

import itmo.rs.standalone.exceptions.WrongEmailFormatException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WrongEmailFormatMapper implements ExceptionMapper<WrongEmailFormatException> {
    @Override
    public Response toResponse(WrongEmailFormatException wrongEmailFormat) {
        return Response.status(Response.Status.BAD_REQUEST).entity(wrongEmailFormat.getMessage()).build();
    }
}
