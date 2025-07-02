package jdbc.model;

import java.sql.Date;
import java.time.LocalDate;

public class Student {

private int stId;
private String firstName;
private String lastName;
private Date dateOfBirth;
private String gender;
private String email;
private String phone;


public Student(){}
//Constructor used when we are reading data from DB
    public Student(int stId, String firstName, String lastName, LocalDate dateOfBirth, String gender, String email, String phone) {
        this.stId = stId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = Date.valueOf(dateOfBirth);
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
    //Constructor used when we are inserting data into DB


    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = Date.valueOf(dateOfBirth);
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }



    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.sql.Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Student{" +
                "stId=" + stId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
