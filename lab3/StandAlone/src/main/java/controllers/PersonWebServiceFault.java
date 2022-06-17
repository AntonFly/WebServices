package controllers;

public class PersonWebServiceFault {
     private static final String DEFAULT_MESSAGE = "personName cannot be null or empty";

    protected String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public static PersonWebServiceFault defaultInstance() {
        PersonWebServiceFault fault = new PersonWebServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }

}
