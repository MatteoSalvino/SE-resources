/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap_client;

import soap.Student;
import soap.StudentEntry;
import soap.StudentMap;

/**
 *
 * @author studente
 */
public class SOAP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Alpha");
        
        Student s2 = new Student();
        s2.setName("Beta");
        
        SOAP_Client.helloStudent(s1);
        SOAP_Client.helloStudent(s2);
        
        StudentMap students = SOAP_Client.getStudents();
        
        for(StudentEntry entry : students.getEntry()) {
            System.out.println("Student " + entry.getStudent().getName() + " with id " + entry.getId());
        }        
    }

    private static StudentMap getStudents() {
        soap.WSImplService service = new soap.WSImplService();
        soap.WSInterface port = service.getWSImplPort();
        return port.getStudents();
    }

    private static String helloStudent(soap.Student arg0) {
        soap.WSImplService service = new soap.WSImplService();
        soap.WSInterface port = service.getWSImplPort();
        return port.helloStudent(arg0);
    }
    
}
