package itmo.rs.standalone.exceptions;


import javax.xml.ws.WebFault;

@WebFault(faultBean = "controllers.PersonWebServiceFault")
public class WrongEmailFormatException extends Exception {
        private static final long serialVersionUID = -6647544772732631077L;

    public static WrongEmailFormatException DEFAULT_INSTANCE = new
            WrongEmailFormatException("Такого пользователя не существует");

    public WrongEmailFormatException(String message) {
        super(message);
    }
}
