import controllers.PersonWebService;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        String url = "http://localhost:8088/PersonService";
        Endpoint.publish(url, new PersonWebService());
    }
}
