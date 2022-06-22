package itmo.rs.standalone.exceptions;


import javax.xml.ws.WebFault;

@WebFault(faultBean = "controllers.PersonWebServiceFault")
public class NoSuchUserException extends Exception {
    private static final long serialVersionUID = -6647544772732631077L;
    public static  NoSuchUserException DEFAULT_INSTANCE = new NoSuchUserException("Такого пользователя не существует");

    public NoSuchUserException(String message) {
        super(message);
    }
}
