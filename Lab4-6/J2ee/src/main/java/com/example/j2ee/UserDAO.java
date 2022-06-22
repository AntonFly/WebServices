package com.example.j2ee;





import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDAO {
    Connection connection;
    public UserDAO(Connection connection){
        this.connection = connection;
    }
    public List<User> getPersons() {
        List<User> users = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users;");
            while (rs.next()) {
                users.add(generateUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public List<User> getPersonsByName(String Name)  {
        List<User> users = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where name=\""+Name+"\";");

            while (rs.next()) {
                users.add(generateUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public List<User> getPersonsByNameAndSurname(String Name, String Surname) {
        List<User> users = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where name=\""+Name+"\" and" +
                    " surname=\""+Surname+"\";");
            while (rs.next()) {
                users.add(generateUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public List<User> getPersonsByEmail(String Email)  {
        List<User> users = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher  = pattern.matcher(Email);
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where email=\""+Email+"\";");
            while (rs.next()) {
                users.add(generateUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public List<User> getPersonsByPhone(String Phone) {
        List<User> users = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where phone_number="+Phone+";");
            while (rs.next()) {
                users.add(generateUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public int createUser(String name, String surname, int number, String email, String password){
        Statement stmt = null;
        int id = 0;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("insert into users (name, surname, phone_number, email, password) values ('"+
                    name+"','"+surname+"', "+number+",'"+email+"','"+password+"'); ");
            ResultSet rs = stmt.executeQuery("select   LAST_INSERT_ID();");
            while (rs.next()) {
                id =  rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  id;
    }

    public String deleteUser(int id){
        Statement stmt = null;
        String status = "";
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("delete from users where id= "+id+";");

            status = "Succeed";

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            status = throwables.toString();
        }
        return  status;
    }

    public String updateUser(String name, String surname, int number, String email, String password, int id){
        Statement stmt = null;
        String status ="";
        String sql = "update users set";
        if(name!=null)
            sql += " name = '"+name+"'";
        if(surname!=null)
            sql += " surname = '"+surname+"'";
        if(number!=0)
            sql += " phone_number = '"+number+"'";
        if(email!=null)
            sql += " email = '"+email+"'";
        if(password!=null)
            sql += " password = '"+password+"'";
        sql += " where id = "+id+";";

        System.out.println( sql);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            status = "Succeed";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return status;
    }


    User generateUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        long phone = rs.getLong("phone_number");
        String email = rs.getString("email");
        //String password = rs.getString("password");
        User user = new User(id,name, surname,phone,email);
        return user;
    }
}
