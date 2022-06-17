package exceptions;

import controllers.PersonWebServiceFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "controllers.PersonWebServiceFault")
public class WrongEmailFormat extends Exception {
        private static final long serialVersionUID = -6647544772732631077L;
        private final PersonWebServiceFault fault;

            public WrongEmailFormat(String message, PersonWebServiceFault fault) {
            super(message);
            this.fault = fault;
        }


         public WrongEmailFormat(String message, PersonWebServiceFault fault, Throwable cause) {
            super(message, cause);
            this.fault = fault;
        }

        public PersonWebServiceFault getFaultInfo() {
            return fault;
        }
}
