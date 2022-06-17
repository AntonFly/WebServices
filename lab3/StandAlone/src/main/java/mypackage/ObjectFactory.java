
package mypackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NoSuchUserException_QNAME = new QName("http://controllers/", "NoSuchUserException");
    private final static QName _GetPersonsByEmailResponse_QNAME = new QName("http://controllers/", "getPersonsByEmailResponse");
    private final static QName _GetPersonsByPhoneResponse_QNAME = new QName("http://controllers/", "getPersonsByPhoneResponse");
    private final static QName _GetAllPersonsResponse_QNAME = new QName("http://controllers/", "getAllPersonsResponse");
    private final static QName _CreatePearsonResponse_QNAME = new QName("http://controllers/", "createPearsonResponse");
    private final static QName _DeletePearsonResponse_QNAME = new QName("http://controllers/", "deletePearsonResponse");
    private final static QName _GetPersonsByName_QNAME = new QName("http://controllers/", "getPersonsByName");
    private final static QName _DeletePearson_QNAME = new QName("http://controllers/", "deletePearson");
    private final static QName _GetAllPersons_QNAME = new QName("http://controllers/", "getAllPersons");
    private final static QName _CreatePearson_QNAME = new QName("http://controllers/", "createPearson");
    private final static QName _UpdatePearson_QNAME = new QName("http://controllers/", "updatePearson");
    private final static QName _WrongEmailFormat_QNAME = new QName("http://controllers/", "WrongEmailFormat");
    private final static QName _UpdatePearsonResponse_QNAME = new QName("http://controllers/", "updatePearsonResponse");
    private final static QName _GetPersonsByNameResponse_QNAME = new QName("http://controllers/", "getPersonsByNameResponse");
    private final static QName _GetPersonsByPhone_QNAME = new QName("http://controllers/", "getPersonsByPhone");
    private final static QName _GetPersonsByNameAndSurnameResponse_QNAME = new QName("http://controllers/", "getPersonsByNameAndSurnameResponse");
    private final static QName _GetPersonsByNameAndSurname_QNAME = new QName("http://controllers/", "getPersonsByNameAndSurname");
    private final static QName _GetPersonsByEmail_QNAME = new QName("http://controllers/", "getPersonsByEmail");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllPersonsResponse }
     * 
     */
    public GetAllPersonsResponse createGetAllPersonsResponse() {
        return new GetAllPersonsResponse();
    }

    /**
     * Create an instance of {@link GetPersonsByEmailResponse }
     * 
     */
    public GetPersonsByEmailResponse createGetPersonsByEmailResponse() {
        return new GetPersonsByEmailResponse();
    }

    /**
     * Create an instance of {@link GetPersonsByPhoneResponse }
     * 
     */
    public GetPersonsByPhoneResponse createGetPersonsByPhoneResponse() {
        return new GetPersonsByPhoneResponse();
    }

    /**
     * Create an instance of {@link PersonWebServiceFault }
     * 
     */
    public PersonWebServiceFault createPersonWebServiceFault() {
        return new PersonWebServiceFault();
    }

    /**
     * Create an instance of {@link GetAllPersons }
     * 
     */
    public GetAllPersons createGetAllPersons() {
        return new GetAllPersons();
    }

    /**
     * Create an instance of {@link DeletePearson }
     * 
     */
    public DeletePearson createDeletePearson() {
        return new DeletePearson();
    }

    /**
     * Create an instance of {@link CreatePearsonResponse }
     * 
     */
    public CreatePearsonResponse createCreatePearsonResponse() {
        return new CreatePearsonResponse();
    }

    /**
     * Create an instance of {@link DeletePearsonResponse }
     * 
     */
    public DeletePearsonResponse createDeletePearsonResponse() {
        return new DeletePearsonResponse();
    }

    /**
     * Create an instance of {@link GetPersonsByName }
     * 
     */
    public GetPersonsByName createGetPersonsByName() {
        return new GetPersonsByName();
    }

    /**
     * Create an instance of {@link GetPersonsByPhone }
     * 
     */
    public GetPersonsByPhone createGetPersonsByPhone() {
        return new GetPersonsByPhone();
    }

    /**
     * Create an instance of {@link GetPersonsByNameResponse }
     * 
     */
    public GetPersonsByNameResponse createGetPersonsByNameResponse() {
        return new GetPersonsByNameResponse();
    }

    /**
     * Create an instance of {@link UpdatePearsonResponse }
     * 
     */
    public UpdatePearsonResponse createUpdatePearsonResponse() {
        return new UpdatePearsonResponse();
    }

    /**
     * Create an instance of {@link CreatePearson }
     * 
     */
    public CreatePearson createCreatePearson() {
        return new CreatePearson();
    }

    /**
     * Create an instance of {@link UpdatePearson }
     * 
     */
    public UpdatePearson createUpdatePearson() {
        return new UpdatePearson();
    }

    /**
     * Create an instance of {@link GetPersonsByEmail }
     * 
     */
    public GetPersonsByEmail createGetPersonsByEmail() {
        return new GetPersonsByEmail();
    }

    /**
     * Create an instance of {@link GetPersonsByNameAndSurname }
     * 
     */
    public GetPersonsByNameAndSurname createGetPersonsByNameAndSurname() {
        return new GetPersonsByNameAndSurname();
    }

    /**
     * Create an instance of {@link GetPersonsByNameAndSurnameResponse }
     * 
     */
    public GetPersonsByNameAndSurnameResponse createGetPersonsByNameAndSurnameResponse() {
        return new GetPersonsByNameAndSurnameResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonWebServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "NoSuchUserException")
    public JAXBElement<PersonWebServiceFault> createNoSuchUserException(PersonWebServiceFault value) {
        return new JAXBElement<PersonWebServiceFault>(_NoSuchUserException_QNAME, PersonWebServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByEmailResponse")
    public JAXBElement<GetPersonsByEmailResponse> createGetPersonsByEmailResponse(GetPersonsByEmailResponse value) {
        return new JAXBElement<GetPersonsByEmailResponse>(_GetPersonsByEmailResponse_QNAME, GetPersonsByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByPhoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByPhoneResponse")
    public JAXBElement<GetPersonsByPhoneResponse> createGetPersonsByPhoneResponse(GetPersonsByPhoneResponse value) {
        return new JAXBElement<GetPersonsByPhoneResponse>(_GetPersonsByPhoneResponse_QNAME, GetPersonsByPhoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getAllPersonsResponse")
    public JAXBElement<GetAllPersonsResponse> createGetAllPersonsResponse(GetAllPersonsResponse value) {
        return new JAXBElement<GetAllPersonsResponse>(_GetAllPersonsResponse_QNAME, GetAllPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePearsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "createPearsonResponse")
    public JAXBElement<CreatePearsonResponse> createCreatePearsonResponse(CreatePearsonResponse value) {
        return new JAXBElement<CreatePearsonResponse>(_CreatePearsonResponse_QNAME, CreatePearsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePearsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "deletePearsonResponse")
    public JAXBElement<DeletePearsonResponse> createDeletePearsonResponse(DeletePearsonResponse value) {
        return new JAXBElement<DeletePearsonResponse>(_DeletePearsonResponse_QNAME, DeletePearsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByName")
    public JAXBElement<GetPersonsByName> createGetPersonsByName(GetPersonsByName value) {
        return new JAXBElement<GetPersonsByName>(_GetPersonsByName_QNAME, GetPersonsByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePearson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "deletePearson")
    public JAXBElement<DeletePearson> createDeletePearson(DeletePearson value) {
        return new JAXBElement<DeletePearson>(_DeletePearson_QNAME, DeletePearson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getAllPersons")
    public JAXBElement<GetAllPersons> createGetAllPersons(GetAllPersons value) {
        return new JAXBElement<GetAllPersons>(_GetAllPersons_QNAME, GetAllPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePearson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "createPearson")
    public JAXBElement<CreatePearson> createCreatePearson(CreatePearson value) {
        return new JAXBElement<CreatePearson>(_CreatePearson_QNAME, CreatePearson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePearson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "updatePearson")
    public JAXBElement<UpdatePearson> createUpdatePearson(UpdatePearson value) {
        return new JAXBElement<UpdatePearson>(_UpdatePearson_QNAME, UpdatePearson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonWebServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "WrongEmailFormat")
    public JAXBElement<PersonWebServiceFault> createWrongEmailFormat(PersonWebServiceFault value) {
        return new JAXBElement<PersonWebServiceFault>(_WrongEmailFormat_QNAME, PersonWebServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePearsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "updatePearsonResponse")
    public JAXBElement<UpdatePearsonResponse> createUpdatePearsonResponse(UpdatePearsonResponse value) {
        return new JAXBElement<UpdatePearsonResponse>(_UpdatePearsonResponse_QNAME, UpdatePearsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByNameResponse")
    public JAXBElement<GetPersonsByNameResponse> createGetPersonsByNameResponse(GetPersonsByNameResponse value) {
        return new JAXBElement<GetPersonsByNameResponse>(_GetPersonsByNameResponse_QNAME, GetPersonsByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByPhone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByPhone")
    public JAXBElement<GetPersonsByPhone> createGetPersonsByPhone(GetPersonsByPhone value) {
        return new JAXBElement<GetPersonsByPhone>(_GetPersonsByPhone_QNAME, GetPersonsByPhone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByNameAndSurnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByNameAndSurnameResponse")
    public JAXBElement<GetPersonsByNameAndSurnameResponse> createGetPersonsByNameAndSurnameResponse(GetPersonsByNameAndSurnameResponse value) {
        return new JAXBElement<GetPersonsByNameAndSurnameResponse>(_GetPersonsByNameAndSurnameResponse_QNAME, GetPersonsByNameAndSurnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByNameAndSurname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByNameAndSurname")
    public JAXBElement<GetPersonsByNameAndSurname> createGetPersonsByNameAndSurname(GetPersonsByNameAndSurname value) {
        return new JAXBElement<GetPersonsByNameAndSurname>(_GetPersonsByNameAndSurname_QNAME, GetPersonsByNameAndSurname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getPersonsByEmail")
    public JAXBElement<GetPersonsByEmail> createGetPersonsByEmail(GetPersonsByEmail value) {
        return new JAXBElement<GetPersonsByEmail>(_GetPersonsByEmail_QNAME, GetPersonsByEmail.class, null, value);
    }

}
