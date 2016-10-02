package com.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by jugs on 9/29/16.
 */
    @XmlRootElement(name = "com.example.Student")
    @XmlType(name = "StudentDetails", propOrder = {"studentName", "fatherName", "rollNumber", "studentAge",
            "studentGender", "studentDOB", "addressLine1", "addressLine2", "city",
            "state", "country", "zipcode"})

public class StudentModel
{
    @XmlElement
    private String studentName;
    @XmlElement
    private String fatherName;
    @XmlAttribute
    private int rollNumber;
    @XmlElement
    private int studentAge;
    @XmlElement
    private String studentGender;
    @XmlElement
    private String studentDOB;
    @XmlElement
    private String addressLine1;
    @XmlElement
    private String addressLine2;
    @XmlElement
    private String city;
    @XmlElement
    private String state;
    @XmlElement
    private String country;
    @XmlElement
    private int zipcode;

    public StudentModel()
    {
        
    }

    public StudentModel(String studentName, String fatherName, int rollNumber, int studentAge, String studentGender, String studentDOB, String addressLine1, String addressLine2, String city, String state, String country, int zipcode) {
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.rollNumber = rollNumber;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentDOB = studentDOB;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
