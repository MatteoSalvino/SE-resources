
package soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
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

    private final static QName _GetStudentsResponse_QNAME = new QName("http://soap_server.mycompany.com/", "getStudentsResponse");
    private final static QName _GetStudents_QNAME = new QName("http://soap_server.mycompany.com/", "getStudents");
    private final static QName _HelloStudent_QNAME = new QName("http://soap_server.mycompany.com/", "helloStudent");
    private final static QName _HelloStudentResponse_QNAME = new QName("http://soap_server.mycompany.com/", "helloStudentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloStudent }
     * 
     */
    public HelloStudent createHelloStudent() {
        return new HelloStudent();
    }

    /**
     * Create an instance of {@link GetStudents }
     * 
     */
    public GetStudents createGetStudents() {
        return new GetStudents();
    }

    /**
     * Create an instance of {@link GetStudentsResponse }
     * 
     */
    public GetStudentsResponse createGetStudentsResponse() {
        return new GetStudentsResponse();
    }

    /**
     * Create an instance of {@link HelloStudentResponse }
     * 
     */
    public HelloStudentResponse createHelloStudentResponse() {
        return new HelloStudentResponse();
    }

    /**
     * Create an instance of {@link StudentMap }
     * 
     */
    public StudentMap createStudentMap() {
        return new StudentMap();
    }

    /**
     * Create an instance of {@link StudentEntry }
     * 
     */
    public StudentEntry createStudentEntry() {
        return new StudentEntry();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.mycompany.com/", name = "getStudentsResponse")
    public JAXBElement<GetStudentsResponse> createGetStudentsResponse(GetStudentsResponse value) {
        return new JAXBElement<GetStudentsResponse>(_GetStudentsResponse_QNAME, GetStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.mycompany.com/", name = "getStudents")
    public JAXBElement<GetStudents> createGetStudents(GetStudents value) {
        return new JAXBElement<GetStudents>(_GetStudents_QNAME, GetStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.mycompany.com/", name = "helloStudent")
    public JAXBElement<HelloStudent> createHelloStudent(HelloStudent value) {
        return new JAXBElement<HelloStudent>(_HelloStudent_QNAME, HelloStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.mycompany.com/", name = "helloStudentResponse")
    public JAXBElement<HelloStudentResponse> createHelloStudentResponse(HelloStudentResponse value) {
        return new JAXBElement<HelloStudentResponse>(_HelloStudentResponse_QNAME, HelloStudentResponse.class, null, value);
    }

}
