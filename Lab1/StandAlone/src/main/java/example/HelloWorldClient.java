package example;

import com.sun.corba.se.spi.activation.Activator;

import mypackage.PersonServiceLocator;
import mypackage.PersonWebService;
import mypackage.User;

import java.net.MalformedURLException;
import java.net.URL;



public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          URL url=new URL("http://localhost:8080/WebServices-1.0-SNAPSHOT/PersonService?wsdl");
          PersonWebService personService=new PersonServiceLocator().getPersonWebServicePort(url);
          System.out.println("Запрос всех пользователей:getAllPersons():");
          User[] persons=personService.getAllPersons();
          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.length);
          System.out.println("Запрос всех пользователей сereer@gmail.com:getPersonByEmail():");
          persons=personService.getPersonsByEmail("ereer@gmail.com");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.length);
          System.out.println("getPersonByName(\"Иван\")");
          persons=personService.getPersonsByName("Иван");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.length);
          System.out.println("getPersonsByNameAndSurname(\"Тест\",\"Тестов\")");
          persons=personService.getPersonsByNameAndSurname("Тест","Тестов");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.length);
          System.out.println("etPersonsByPhone(\"436456436\")");
          persons=personService.getPersonsByPhone("436456436");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.length);

      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
  }
}
