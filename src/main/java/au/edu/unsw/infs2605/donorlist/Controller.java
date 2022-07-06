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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
    
    //Create Text Fields to insert new information
    
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
    
    //Create Choice Box to choose Gender and BloodType
    
    @FXML
    ChoiceBox<String> newGender = new ChoiceBox<>();
 
    @FXML 
    ChoiceBox<String> newBloodType = new ChoiceBox<>(); 
    
    //Edit button
    @FXML
    Button editCurrentDonor;
    
    //Last time updated
    @FXML
    Label lastTimeUpdated;
    
    //Add button
    @FXML
    Button addNewDonor;
    
    //Save button
    @FXML
    Button saveUpdate;
    
    //Count number of donations
    @FXML
    Label bloodCount;
    
    @FXML
    Label plasmaCount;
    
    //Edit number of blood and plasma donations
    @FXML
    Spinner editBloodDonationCount;
    
    @FXML
    Spinner editPlasmaDonationCount;
    
    //Cancel change
    @FXML
    Button cancelChange;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Sample data
        DonorClass donor1 = new DonorClass("Hailey", "Huynh", "02/7/2000", 
                "Female", "O+", "hnha00@gmail.com", "0429351234", 
                "189 Anzac Parade, Kensington NSW 2033", "-", 1, 2, "-");
        DonorClass donor2 = new DonorClass("Kelly", "Dao", "15/10/2000", 
                "Female", "A+", "kelly.dao@gmail.com", "0489214583", 
                "93 Gardeners Road, Kingsford NSW 2032", "allergies", 2, 1, "-");
        DonorClass donor3 = new DonorClass("Oliver", "Tran", "23/7/2001", 
                "Male", "0-", "olivertran01@gmail.com", "0444335252", 
                "235 Maroubra Road, Marboura NSW 2035", "allergic with fruit", 
                0, 3, "-");
        DonorClass donor4 = new DonorClass("Mia", "Dang", "01/2/2002", 
                "Female", "B+", "mia.dang@outlook.com", "0485723512", 
                "18 High Street, Kensington NSW 2033", "-", 1, 3, "-");
        DonorClass donor5 = new DonorClass("Chloe", "Le", "01/8/1999", 
                "Female", "AB+", "chloelee99@gmail.com", "0475823534", 
                "188 Fedgerald Avenue, Maroubra NSW 2035", "-", 3, 1, "-");
        
        //Only add sample data when the list is empty to prevent duplicate data
        if (donorList.isEmpty()){
            donorList.add(donor1);
            donorList.add(donor2);
            donorList.add(donor3);
            donorList.add(donor4);
            donorList.add(donor5);
        }
        
        //Display List of donors in ListView
        donorListView.getItems().addAll(donorList);
        
        //Default - display information of the first donor in the list
        donorListView.getSelectionModel().select(0);
       
        //Display full information of the chosen name
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
        bloodCount.setText(Integer.toString(current.getBloodDonationCount()));
        plasmaCount.setText(Integer.toString(current.getPlasmaDonationCount()));
        lastTimeUpdated.setText(current.getLastTimeUpdated());     
    }
    
    /*
    Edit information of current donor
    */
    
    @FXML
    public void editCurrentDonor() {
        //Selected donor to be edited
        DonorClass currentDonor = donorListView.getSelectionModel().getSelectedItem();

        //Set TextFields and ChoiceBox visible to update new information
       
        newFirstName.setVisible(true);
        newLastName.setVisible(true);
        newDateOfBirth.setVisible(true);
        newEmailAddress.setVisible(true);
        newAddress.setVisible(true);
        newMobileNumber.setVisible(true);
        newNotes.setVisible(true);
        newGender.setVisible(true);
        newBloodType.setVisible(true);
        editBloodDonationCount.setVisible(true);
        editPlasmaDonationCount.setVisible(true);
        bloodCount.setVisible(false);
        plasmaCount.setVisible(false);
         
        //Confirm button and Cancel change button
        saveUpdate.setVisible(true);
        cancelChange.setVisible(true);
        
        //Prevent users from clicking on different donor name when editing
        donorListView.setDisable(true);
          
        //Set button addNewDonor and Edit invisible
        addNewDonor.setVisible(false);
        editCurrentDonor.setVisible(false);
        
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
 
        //Create ChoiceBox to choose Gender and Blood Type
        createChoiceBox(); 
        
        //Edit counts of blood donations
        SpinnerValueFactory<Integer> bloodCountSpinner = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
        bloodCountSpinner.setValue(currentDonor.getBloodDonationCount());
        editBloodDonationCount.setValueFactory(bloodCountSpinner);
        
        //Edit counts of plasma donations
        SpinnerValueFactory<Integer> plasmaCountSpinner = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
        plasmaCountSpinner.setValue(currentDonor.getPlasmaDonationCount());
        editPlasmaDonationCount.setValueFactory(plasmaCountSpinner);     
    }
    
    /*
    Set up Choice Box for choosing Gender and BloodType
    */
    public void createChoiceBox() {
        
        //Create list of choice for Gender
        if (newGender.getItems().isEmpty()) {
            newGender.getItems().add("Male");
            newGender.getItems().add("Female");
            newGender.getItems().add("Other");
            newGender.getItems().add("Prefer not to say");   
        }

        //Create list of choice for BloodType
        if (newBloodType.getItems().isEmpty()) {
            newBloodType.getItems().add("O+");
            newBloodType.getItems().add("O-");
            newBloodType.getItems().add("A+");
            newBloodType.getItems().add("A-");
            newBloodType.getItems().add("B+");
            newBloodType.getItems().add("B-");
            newBloodType.getItems().add("AB+");
            newBloodType.getItems().add("AB-");  
        }  
    }
    
    //Get users's choice from choiceBox
    private String getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();
        return choice;
    }
    
    //Save updated information of current donor
    public void saveUpdate() {
        DonorClass currentDonor = donorListView.getSelectionModel().getSelectedItem();
        
        //Hide Textfield and ChoiceBox to avoid users from mistakenly editing
        newFirstName.setVisible(false);
        newLastName.setVisible(false);
        newDateOfBirth.setVisible(false);
        newEmailAddress.setVisible(false);
        newAddress.setVisible(false);
        newMobileNumber.setVisible(false);
        newNotes.setVisible(false);
        newGender.setVisible(false);
        newBloodType.setVisible(false);
        editBloodDonationCount.setVisible(false);
        editPlasmaDonationCount.setVisible(false);
        bloodCount.setVisible(true);
        plasmaCount.setVisible(true);
        
        //Set button addNewDonor and Edit visible
        addNewDonor.setVisible(true);
        editCurrentDonor.setVisible(true);
        
        //Hide Confirm and Cancel button
        saveUpdate.setVisible(false);
        cancelChange.setVisible(false);
        
        //Set last updated visible
        lastTimeUpdated.setVisible(true);
        
        //Allow users to click on another donor on the list
        donorListView.setDisable(false);
        
        //Update new information of current donor
        currentDonor.setFirstName(newFirstName.getText());
        currentDonor.setLastName(newLastName.getText());
        currentDonor.setDOB(newDateOfBirth.getText());
        currentDonor.setEmail(newEmailAddress.getText());
        currentDonor.setMobileNumber(newMobileNumber.getText());
        currentDonor.setNote(newNotes.getText());
        currentDonor.setAddress(newAddress.getText());
        currentDonor.setGender(getChoice(newGender));
        currentDonor.setBloodType(getChoice(newBloodType));  
        
        /*
        Update last time updated
        Note: only update when either count of blood donations or 
        plasma donations updated
        */  
        if (currentDonor.getBloodDonationCount() != (int) editBloodDonationCount.getValue()
                || currentDonor.getPlasmaDonationCount() != (int) editPlasmaDonationCount.getValue()) {
            //Save last time updated
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String currentTime = now.format(dateTimeFormat);
            currentDonor.setLastTimeUpdated(currentTime);
        }
        
        //Update new count of blood and plasma donations
        currentDonor.setBloodDonationCount((int)editBloodDonationCount.getValue());
        currentDonor.setPlasmaDonationCount((int)editPlasmaDonationCount.getValue());
        
        donorListView.refresh();
        displayFullInformation(); 
    }   
    
    //Cancel changes
    public void cancelChange() throws IOException {
        App.setRoot("app");
    }
    
    /*
    Create new Donor
    */
    
    @FXML
    public void toNewDonorController() throws IOException {
        App.setRoot("newDonor");
    }  
}
    
    
    
    
    
 


