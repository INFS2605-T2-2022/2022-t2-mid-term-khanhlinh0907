/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donorlist;

//import java.sql.Connection;
//import java.sql.DriverManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.net.URL;
import java.util.ResourceBundle;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author khanhlinh0907
 */

//Show donor list names on ListView
import javafx.scene.control.Label;
public class Controller implements Initializable {
    @FXML
    private ListView<DonorClass> donorListView;
    
    //Create sample data
    public static List<DonorClass> donorList = new ArrayList<>();
    
    @FXML
    Label firstName;
    
    @FXML
    Label lastName;
    
    @FXML
    Label gender;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DonorClass donor1 = new DonorClass("Hailey", "Huynh", "02/7/2000");
        DonorClass donor2 = new DonorClass("Kelly", "Dao", "15/10/2000");
        DonorClass donor3 = new DonorClass("Oliver", "Tran", "23/7/2001");
        DonorClass donor4 = new DonorClass("Mia", "Dang", "01/2/2002");
        DonorClass donor5 = new DonorClass("James", "Pham", "12/6/1999");
        
        donorList.add(donor1);
        donorList.add(donor2);
        donorList.add(donor3);
        donorList.add(donor4);
        donorList.add(donor5);
        
        //make sure ListView is clear before adding
        donorListView.getItems().clear();
        
        //add donor name to the ListView
        donorListView.getItems().addAll(donorList);
        
        //retrieve default information
        donorListView.getSelectionModel().select(0);
        displayFullInfo();
        
        
        //firstName.setText(currentDonor.getFirstName());
        //lastName.setText(currentDonor.getLastName());
        
           
        }
    
        public void displayFullInfo() {
            DonorClass current = donorListView.getSelectionModel().getSelectedItem();
            firstName.setText(current.getFirstName());
            lastName.setText(current.getLastName());
     
        }
        
        /* Change to New Donor Screen
        @FXML
        public void toNewDonorController() throws IOException {
            App.setRoot("newDonorController");
        }
        */
    }
    
// 
    
    
    
    
    
 


