package example;

import com.sun.corba.se.spi.activation.Activator;

import exceptions.WrongEmailFormat;
import mypackage.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          URL url=new URL("http://localhost:8080/PersonService?wsdl");
          PersonService personService=new PersonService(url);
          System.out.println("Запрос всех пользователей:getAllPersons():");
          List<User> persons=personService.getPersonWebServicePort().getAllPersons();
          for(User user:persons){
              System.out.println(user.toString());
          }
          
          try{
              System.out.println("Total persons:"+persons.size());
              System.out.println("Запрос всех пользователей alexk2109@gmail.com:getPersonByEmail():");
              persons=personService.getPersonWebServicePort().getPersonsByEmail("alexk2109@gmail.com");

              for(User user:persons){
                  System.out.println(user.toString());
              }
                System.out.println("Total persons:"+persons.size());
                System.out.println("Запрос всех пользователей alexk2109gmail.com:getPersonByEmail() Невалидный емайл:");
                persons=personService.getPersonWebServicePort().getPersonsByEmail("alexk2109gmail.com");

                for(User user:persons){
                    System.out.println(user.toString());
                }
                System.out.println("Total persons:"+persons.size());
          }catch (mypackage.WrongEmailFormat e){
              System.out.println("Error message: " + e.getFaultInfo().getMessage());
          }
          try{
          System.out.println("getPersonByName(\"Иван\")");
          persons=personService.getPersonWebServicePort().getPersonsByName("Иван");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.size());

              System.out.println("getPersonByName(\"Иван889\") Невалидное имя");
              persons=personService.getPersonWebServicePort().getPersonsByName("Иван889");

              for(User user:persons){
                  System.out.println(user.toString());
              }
              System.out.println("Total persons:"+persons.size());
          }catch (NoSuchUserException e){
              System.out.println("Error message: " + e.getFaultInfo().getMessage());

          }
          System.out.println("getPersonsByNameAndSurname(\"Тест\",\"Тестов\")");
          persons=personService.getPersonWebServicePort().getPersonsByNameAndSurname("Тест","Тестов");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.size());
          System.out.println("etPersonsByPhone(\"436456436\")");
          persons=personService.getPersonWebServicePort().getPersonsByPhone("436456436");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.size());
          System.out.println("createPearson(\"Anton\",\"Avr\",99988867,\"email@email.com\",\"password\")");
          int id = personService.getPersonWebServicePort().createPearson("Anton","Avr",99988867,"email@email.com","password");
          System.out.println("Id of created person is "+id);
          System.out.println("updatePearson(\"Jac\",null,0,null,null,id)");
          System.out.println(personService.getPersonWebServicePort().updatePearson("Jac",null,0,null,null,id));
          System.out.println("deletePearson(id)");
          System.out.println(personService.getPersonWebServicePort().deletePearson(id));


      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
  }
}
