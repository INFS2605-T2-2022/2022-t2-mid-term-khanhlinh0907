/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donorlist;

import static au.edu.unsw.infs2605.donorlist.Controller.donorList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


/**
 *
 * @author khanhlinh0907
 */

public class NewDonorController implements Initializable{
    //Create TextField to get user's input
    @FXML
    TextField firstName;
    
    @FXML
    TextField lastName;

    @FXML
    TextField date;
    
    @FXML
    TextField month;
    
    @FXML
    TextField year;
    
    @FXML
    TextField emailAddress;
    
    @FXML
    TextField mobileNumber;
    
    @FXML
    TextField address;
    
    @FXML
    TextField notes;
    
    @FXML 
    ChoiceBox<String> gender = new ChoiceBox<>();
 
    @FXML 
    ChoiceBox<String> bloodType = new ChoiceBox<>(); 
    
    @FXML
    Spinner bloodDonationSpinner;
    
    @FXML
    Spinner plasmaDonationSpinner;
    
    @FXML
    Text firstNameError;
    
    @FXML
    Text lastNameError;
    
    @FXML
    Text dobError; 
    
    @FXML
    Text bloodTypeError;
    
    @FXML
    Text mobileNumberError;
    
//Get User Input
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createChoiceBox();
        
        //Create spinner
        SpinnerValueFactory<Integer> bloodSpinnerValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        bloodDonationSpinner.setValueFactory(bloodSpinnerValue);
        
        SpinnerValueFactory<Integer> plasmaSpinnerValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        plasmaDonationSpinner.setValueFactory(plasmaSpinnerValue);
    }
    
    public void createChoiceBox() {
        //Clear value of the Choice Box before adding
        gender.getItems().clear();
        
        //Create list of choice for Gender       
        gender.getItems().add("Male");
        gender.getItems().add("Female");
        gender.getItems().add("Other");
        gender.getItems().add("Prefer not to say");
            
        //Clear value of the Choice Box before adding
        bloodType.getItems().clear();
        
        //Create list of choice for BloodType
        bloodType.getItems().add("O+");
        bloodType.getItems().add("O-");
        bloodType.getItems().add("A+");
        bloodType.getItems().add("A-");
        bloodType.getItems().add("B+");
        bloodType.getItems().add("B-");
        bloodType.getItems().add("AB+");
        bloodType.getItems().add("AB-");
    
        //Set default value of choiceBox
        gender.setValue(" ");
        bloodType.setValue(" ");                     
    } 
        
    private String getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();
        return choice;
    }
    
    //When navigating to main screen, information of new donor is saved
    @FXML
    public void navigateToMainScreen() throws IOException{
        
        DonorClass newDonor = new DonorClass();
        newDonor.setFirstName(firstName.getText());
        newDonor.setLastName(lastName.getText());
        newDonor.setEmail(emailAddress.getText());
        String dateOfBirth = date.getText() + "/" + month.getText() + "/"
                + year.getText();
        newDonor.setDOB(dateOfBirth);
        newDonor.setMobileNumber(mobileNumber.getText());
        newDonor.setAddress(address.getText());
        newDonor.setNote(notes.getText()); 
        newDonor.setGender(getChoice(gender));
        newDonor.setBloodType(getChoice(bloodType));
            
        //Take blood donation and plasma donation count from Spinners
        newDonor.setBloodDonationCount((int)bloodDonationSpinner.getValue());
        newDonor.setPlasmaDonationCount((int)plasmaDonationSpinner.getValue());
            
        //Add new donor to donorList
        //Check whether compulsory information is provided
        
        if (newDonor.getFirstName().isBlank()) {
            firstNameError.setVisible(true);
        }
        else {
            firstNameError.setVisible(false);
        }
        
        if (newDonor.getLastName().isBlank()) {
            lastNameError.setVisible(true);
        }
        else {
            lastNameError.setVisible(false);
        }
        
        if (newDonor.getBloodType().isBlank()) {
            bloodTypeError.setVisible(true);
        }
        else {
            bloodTypeError.setVisible(false);
        }
        
        if (date.getText().length() == 0 || month.getText().length() == 0
                || year.getText().length() == 0) {
            dobError.setVisible(true);
        }
        else {
            dobError.setVisible(false);
        }
        
        if (newDonor.getMobileNumber().isBlank()) {
            mobileNumberError.setVisible(true);
        }
        else {
            mobileNumberError.setVisible(false);
        }
        
        //If no error messages occur
        if (firstNameError.isVisible() == false 
                && lastNameError.isVisible() == false
                && dobError.isVisible() == false
                && bloodTypeError.isVisible() == false
                && mobileNumberError.isVisible() == false) {
            //Create new donor
            donorList.add(newDonor);
            //Change back to main screen
            App.setRoot("app");
        }
    }
    
    public void cancelButton() throws IOException {
        App.setRoot("app");
    }
}
    
        
        
        
        
        
     
