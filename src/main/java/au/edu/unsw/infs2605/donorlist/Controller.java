/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donorlist;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
/**
 *
 * @author Linh To - z5272228
 */

//Show donor list names on ListView

public class Controller implements Initializable {
    
    @FXML
    private ListView<DonorClass> donorListView;
    
    //Create sample data
    public static List<DonorClass> donorList = new ArrayList<>();
    
    //Create labels to display donor information
    @FXML
    Label label;
            
    @FXML
    Label firstName;
    
    @FXML
    Label lastName;
    
    @FXML
    Label gender;
    
    @FXML
    Label dateOfBirth;
    
    @FXML
    Label bloodType;
    
    @FXML
    Label emailAddress;
    
    @FXML
    Label address;
    
    @FXML
    Label mobileNumber;
    
    @FXML
    Label notes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DonorClass donor1 = new DonorClass("Hailey", "Huynh", "02/7/2000", 
                "Female", "O+", "hnha00@gmail.com", "0429351234", 
                "189 Anzac Parade, Kensington NSW 2033", "-");
        DonorClass donor2 = new DonorClass("Kelly", "Dao", "15/10/2000", 
                "Female", "A+", "kelly.dao@gmail.com", "0489214583", 
                "93 Gardeners Road, Kingsford NSW 2032", "allergies");
        DonorClass donor3 = new DonorClass("Oliver", "Tran", "23/7/2001", 
                "Male", "0-", "olivertran01@gmail.com", "0444335252", 
                "235 Maroubra Road, Marboura NSW 2035", "allergic with fruit");
        DonorClass donor4 = new DonorClass("Mia", "Dang", "01/2/2002", 
                "Female", "B+", "mia.dang@outlook.com", "0485723512", 
                "18 High Street, Kensington NSW 2033", "-");
        DonorClass donor5 = new DonorClass("Chloe", "Le", "01/8/1999", 
                "Female", "AB+", "chloelee99@gmail.com", "0475823534", 
                "188 Fedgerald Avenue, Maroubra NSW 2035", "-");
       
        donorList.add(donor1);
        donorList.add(donor2);
        donorList.add(donor3);
        donorList.add(donor4);
        donorList.add(donor5);
        
        //make sure ListView is clear before adding
        donorListView.getItems().clear();
        
        //Display List of donors in ListView
        donorListView.getItems().addAll(donorList);
        
        //retrieve default information
        donorListView.getSelectionModel().select(0);
        
        //Display full information of donors
        displayFullInformation();       
        }
    
        public void displayFullInformation() {
            //selected donor
            DonorClass current = donorListView.getSelectionModel().getSelectedItem();
            
            //Display selected donor name on top of Detail view
            label.setText(current.getFirstName() + " " + current.getLastName());
            
            //display information
            firstName.setText(current.getFirstName());
            lastName.setText(current.getLastName());
            gender.setText(current.getGender());
            dateOfBirth.setText(current.getDOB());
            bloodType.setText(current.getBloodType());
            emailAddress.setText(current.getEmail());
            mobileNumber.setText(current.getMobileNumber());
            address.setText(current.getAddress());
            notes.setText(current.getNote());
        }
        
    //Change to New Donor Screen
    @FXML
    public void toNewDonorController() throws IOException {
        App.setRoot("newDonor");
        }
    }
    
// 
    
    
    
    
    
 


