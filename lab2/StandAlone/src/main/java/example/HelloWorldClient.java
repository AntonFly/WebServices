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
          URL url=new URL("http://localhost:8080/PersonService?wsdl");
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
          System.out.println("createPearson(\"Anton\",\"Avr\",99988867,\"email@email.com\",\"password\")");
          int id = personService.createPearson("Anton","Avr",99988867,"email@email.com","password");
          System.out.println("Id of created person is "+id);
          System.out.println("updatePearson(\"Jac\",null,0,null,null,id)");
          System.out.println(personService.updatePearson("Jac",null,0,null,null,id));
          System.out.println("deletePearson(id)");
          System.out.println(personService.deletePearson(id));


      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
  }
}
