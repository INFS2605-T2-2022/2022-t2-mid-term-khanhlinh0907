package au.edu.unsw.infs2605.donorlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    /*
    Create static donor attributes to pass between screens
    */
    
    private static String firstName;
    private static String lastName;
    private static String dateOfBirth;
    private static String gender;
    private static String bloodType;
    private static String email;
    private static String mobileNumber;
    private static String address;
    private static String notes;
   
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Donor List");
        scene = new Scene(loadFXML("app"));
        stage.setScene(scene);
        stage.show();
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    /*
    Getter and setter method of each attribute
    */
    
    //first_name
    static void setFirstName(String firstName) {
        App.firstName = firstName;
    }
    
    static String getFirstName() {
        return firstName;
    }
    
    //last_name
    static void setLastName(String lastName) {
        App.lastName = lastName;
    }
    
    static String getLastName() {
        return lastName;
    }
    
    //date_of_birth
    static void setDateOfBirth(String dateOfBirth) {
        App.dateOfBirth = dateOfBirth;
    }
    
    static String getDateOfBirth() {
        return dateOfBirth;
    }
    
    //gender
    static void setGender(String gender) {
        App.gender = gender;
    }
    
    static String getGender() {
        return gender;
    }
    
    //blood_type
    static void setBloodType(String bloodType) {
        App.bloodType = bloodType;
    }
    
    static String getBloodType() {
        return bloodType;
    }
    
    //email_address
    static void setEmail(String email) {
        App.email = email;
    }
    
    static String getEmail() {
        return email;
    }
    //mobile_number
    static void setMobileNumber(String mobileNumber) {
        App.mobileNumber = mobileNumber;
    }
    
    static String getMobileNumber() {
        return mobileNumber;
    }
    
    //address
    static void setAddress(String address) {
        App.address = address;
    }
    
    static String getAddress() {
        return address;
    }
    
    //notes
    static void setNotes(String notes) {
        App.notes = notes;
    }
    
    static String getNotes() {
        return notes;
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
