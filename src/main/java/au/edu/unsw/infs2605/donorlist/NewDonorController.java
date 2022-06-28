/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donorlist;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


/**
 *
 * @author khanhlinh0907
 */
public class NewDonorController {
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
    
    //Get User Input
    @FXML
    public void getUserInput() {
        App.setFirstName(firstName.getText());
        App.setLastName(lastName.getText());
        App.setEmail(emailAddress.getText());
        String dateOfBirth = date.getText() + "/" + month.getText() + "/"
                + year.getText();
        App.setDateOfBirth(dateOfBirth);
        App.setMobileNumber(mobileNumber.getText());
        App.setAddress(address.getText());
        App.setNotes(notes.getText());  
    }
        private void createChoiceBox() {
            
            ChoiceBox<String> gender = new ChoiceBox<>();
 
            ChoiceBox<String> bloodType = new ChoiceBox<>();  
        
            //Create list of choice for Gender
            gender.getItems().add("Male");
            gender.getItems().add("Female");
            gender.getItems().add("Other");
            gender.getItems().add("Prefer not to say");
        
            //Create list of choice for BloodType
            bloodType.getItems().add("O+");
            bloodType.getItems().add("O-");
            bloodType.getItems().add("A+");
            bloodType.getItems().add("A-");
            bloodType.getItems().add("B+");
            bloodType.getItems().add("B-");
            bloodType.getItems().add("AB+");
            bloodType.getItems().add("AB-");
    
            //Set a default value
            gender.setValue("Female");
            bloodType.setValue("O+");
        
            //Get choice
            App.setGender(getChoice(gender));
            App.setBloodType(getChoice(bloodType));
            
            
            //bloodType.setOnAction((event) -> getChoice(bloodType));
        } 
        
        private String getChoice(ChoiceBox<String> choiceBox) {
            String choice = choiceBox.getValue();
            return choice;
        }
        
        @FXML
        public void navigateToMainScreen() throws IOException{
            App.setRoot("app");
            
        }
    }
    
    
        

   
        //button.setOnAction(e -> getChoice(gender));
        
        
        
        
        
        
        
        
}
