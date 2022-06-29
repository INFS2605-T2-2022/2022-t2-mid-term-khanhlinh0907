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
    
    private static DonorClass donor;
   
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
    
    //donor
    static void setDonor(DonorClass donor) {
        App.donor = donor;
    }
    static DonorClass getDonor() {
        return donor;
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
