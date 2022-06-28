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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    
        /*
    //Create Text Fields to insert new information
    
    */
    
    @FXML
    TextField newFirstName;
    
    @FXML
    TextField newLastName;
    
    @FXML
    TextField newDateOfBirth;
    
    @FXML
    TextField newEmailAddress;
    
    @FXML
    TextField newAddress;
    
    @FXML
    TextField newMobileNumber;
    
    @FXML
    TextField newNotes;
    
    @FXML
    ChoiceBox<String> newGender = new ChoiceBox<>();
 
    @FXML 
    ChoiceBox<String> newBloodType = new ChoiceBox<>(); 
    
    @FXML
    Button editCurrentDonor;
    
    @FXML
    Button addNewDonor;
    
    @FXML
    Button saveUpdate;

    
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
        
        
        
        //Display List of donors in ListView
        donorListView.getItems().addAll(donorList);
        
        
        //retrieve default information
        donorListView.getSelectionModel().select(0);
        
        //Display full information of donors
        displayFullInformation(); 
        
        createNewDonor();
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
    
    public void createNewDonor() {
            DonorClass newDonor = new DonorClass();
            
            newDonor.setFirstName(App.getFirstName());
            System.out.println(newDonor.getFirstName());
            newDonor.setLastName(App.getLastName());
            newDonor.setDOB(App.getDateOfBirth());
            newDonor.setEmail(App.getEmail());
            newDonor.setMobileNumber(App.getMobileNumber());
            newDonor.setNote(App.getNotes());
            newDonor.setAddress(App.getAddress());
            newDonor.setGender(App.getGender());
            newDonor.setBloodType(App.getBloodType());
            
            donorList.add(newDonor);
            donorListView.getItems().add(newDonor);
    }
        
    //Change to New Donor Screen
    @FXML
    public void toNewDonorController() throws IOException {
        App.setRoot("newDonor");
    }
    
    /*
    Edit information of current donor
    */
    
    @FXML
    public void editCurrentDonor() {
        //Selected donor to be edited
        DonorClass currentDonor = donorListView.getSelectionModel().getSelectedItem();
        
        /*
        Set TextFields and ChoiceBox visible
        Make sure that the current Label and the new TextField/ChoiceBox never appears at the same time
        */
        
        newFirstName.setVisible(true);
        newLastName.setVisible(true);
        newDateOfBirth.setVisible(true);
        newEmailAddress.setVisible(true);
        newAddress.setVisible(true);
        newMobileNumber.setVisible(true);
        newNotes.setVisible(true);
        newGender.setVisible(true);
        newBloodType.setVisible(true);
        
        //Set button addNewDonor invisible
        addNewDonor.setVisible(false);
        
        //Create a confirm button to save updated information
        saveUpdate.setVisible(true);
        
        
        //firstName.setVisible(false);
//        newLastName.setVisible(!lastName.isVisible());
//        newDateOfBirth.setVisible(!dateOfBirth.isVisible());
//        newEmailAddress.setVisible(!emailAddress.isVisible());
//        newAddress.setVisible(!address.isVisible());
//        newMobileNumber.setVisible(!mobileNumber.isVisible());
//        newNotes.setVisible(!notes.isVisible());
//        newGender.setVisible(!gender.isVisible());
//        newBloodType.setVisible(!bloodType.isVisible());
        
        //Prefill TextField with current information of current donor
        newFirstName.setText(currentDonor.getFirstName());
        newLastName.setText(currentDonor.getLastName());
        newDateOfBirth.setText(currentDonor.getDOB());
        newEmailAddress.setText(currentDonor.getEmail());
        newMobileNumber.setText(currentDonor.getMobileNumber());
        newAddress.setText(currentDonor.getAddress());
        newNotes.setText(currentDonor.getNote());
        
        newGender.setValue(currentDonor.getGender());
        newBloodType.setValue(currentDonor.getBloodType());
       
        System.out.println(currentDonor.getFirstName());

        //gender & bloodType -- choiceBox
        createChoiceBox();
    }
    
    public void createChoiceBox() {
            //Create list of choice for Gender
        newGender.getItems().add("Male");
        newGender.getItems().add("Female");
        newGender.getItems().add("Other");
        newGender.getItems().add("Prefer not to say");
            
            //Create list of choice for BloodType
        newBloodType.getItems().add("O+");
        newBloodType.getItems().add("O-");
        newBloodType.getItems().add("A+");
        newBloodType.getItems().add("A-");
        newBloodType.getItems().add("B+");
        newBloodType.getItems().add("B-");
        newBloodType.getItems().add("AB+");
        newBloodType.getItems().add("AB-");
        
                        
    }
    
    private String getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();
        return choice;
    }
    
    
    public void saveUpdate() {
        newFirstName.setVisible(false);
        newLastName.setVisible(false);
        newDateOfBirth.setVisible(false);
        newEmailAddress.setVisible(false);
        newAddress.setVisible(false);
        newMobileNumber.setVisible(false);
        newNotes.setVisible(false);
        newGender.setVisible(false);
        newBloodType.setVisible(false);
        
        //Set button addNewDonor visible
        addNewDonor.setVisible(true);
        
        //Hide saveChange button 
        saveUpdate.setVisible(false);
    
        //Save updated information to donorList
        DonorClass currentDonor = donorListView.getSelectionModel().getSelectedItem();
        
        //currentDonor.setFirstName(newFirstName.getText());
        currentDonor.setLastName(newLastName.getText());
        currentDonor.setDOB(newDateOfBirth.getText());
        currentDonor.setEmail(newEmailAddress.getText());
        currentDonor.setMobileNumber(newMobileNumber.getText());
        currentDonor.setNote(newNotes.getText());
        currentDonor.setAddress(newAddress.getText());
       
        newGender.setValue(getChoice(newGender));
        newBloodType.setValue(getChoice(newBloodType));
        
        displayFullInformation();
        //App.setRoot("app");
    }
    
}
    

// 
    
    
    
    
    
 


