package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                users.add(createUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public List<User> getPersonsByName(String Name) {
        List<User> users = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where name=\""+Name+"\";");
            while (rs.next()) {
                users.add(createUser(rs));
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
                users.add(createUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public List<User> getPersonsByEmail(String Email) {
        List<User> users = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where email=\""+Email+"\";");
            while (rs.next()) {
                users.add(createUser(rs));
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
                users.add(createUser(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    User createUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        int phone = rs.getInt("phone_number");
        String email = rs.getString("email");
        String password = rs.getString("password");
        User user = new User(id,name, surname,phone,email,password);
        return user;
    }
}
