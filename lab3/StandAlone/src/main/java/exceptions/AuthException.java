package exceptions;

import controllers.PersonWebServiceFault;

import javax.xml.ws.WebFault;

@WebFault(name = "AuthException", targetNamespace = "http://impl.ws.itmo/")
public class AuthException
        extends Exception
{


    private PersonWebServiceFault faultInfo;


    public AuthException(String message, PersonWebServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }


    public AuthException(String message, PersonWebServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }


    public PersonWebServiceFault getFaultInfo() {
        return faultInfo;
    }

}