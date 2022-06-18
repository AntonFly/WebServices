package org.example;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class User {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private long phone_number;
    private String bio;
    private Date birthday;
    private String email;

    public User(){};
    public User(int id, String name, String surname, long phone_number, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString(){
        return "User{" + "name=" + name + ", surname=" + surname +
                ", birthday=" + birthday + ", email="+email+'}';
    }
}
