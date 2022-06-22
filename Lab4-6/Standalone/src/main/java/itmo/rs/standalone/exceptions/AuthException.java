package itmo.rs.standalone.exceptions;

public class AuthException extends Exception{
    private static final long serialVersionUID = -6647544772732631077L;
    public static AuthException DEFAULT_INSTANCE = new
            AuthException("Unknown user");
    public AuthException(String message) {
        super(message);
    }
}
