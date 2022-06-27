/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donorlist;

import javafx.beans.property.*;

/**
 *
 * @author khanhlinh0907
 */
public class DonorClass {
    //donor attributes
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String gender;
    private String blood_type;
    private String email_address;
    private String mobile_number;
    private String address;
    private String notes;
    
    //Constructor
    public DonorClass() {
        this.first_name = new String();
        this.last_name = new String();
        this.date_of_birth = new String();
        this.gender = new String();
        this.blood_type = new String();
        this.email_address = new String();
        this.mobile_number = new String();
        this.address = new String();
        this.notes = new String();
    }
    
    public DonorClass(String first_name, String last_name, String date_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
    }
   
    
    //first_name
    public String getFirstName() {
        return first_name;
    }
    
    public void setFirstName(String firstName) {
        this.first_name=firstName;
    }
    
    //last_name
    public String getLastName() {
        return last_name;
    }
    
    public void setLastName(String lastName) {
        this.last_name=lastName;
    }
    
    //date_of_birth
    public String getDOB() {
        return date_of_birth;
    }
    
    public void setDOB(String date_of_birth) {
        this.date_of_birth=date_of_birth;
    }
    
    //gender
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender=gender;
    }
    
    //blood_type
    public String getBloodType() {
        return blood_type;
    }
    
    public void setBloodType(String bloodType) {
        this.blood_type=bloodType;
    }
    
    //email_address
    public String getEmail() {
        return email_address;
    }
    
    public void setEmail(String email) {
        this.email_address=email;
    }
    
    //mobile_number
    public String getMobileNo() {
        return mobile_number;
    }
    
    public void setMobileNo(String mobile) {
        this.mobile_number=mobile;
    }
    
    //address
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address=address;
    }
    
    //notes
    public String getNote() {
        return notes;
    }
    
    public void setNote(String notes) {
        this.notes=notes;
    }

    @Override
    public String toString() {
        return this.first_name + " " + this.last_name;
    }
    
    
}
