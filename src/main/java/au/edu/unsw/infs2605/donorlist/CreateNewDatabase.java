/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donorlist;

import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
/**
 *
 * @author khanhlinh0907
 */
public class CreateNewDatabase {
    public static void createNewDatabase(String fileName) {  
   
        String url = "jdbc:sqlite:C:/sqlite/" + fileName;  
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created.");  
            }  
   
        } catch (java.sql.SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
  
    public static void main(String[] args) {  
        createNewDatabase("DonorDatabase.db");  
    }  
}
