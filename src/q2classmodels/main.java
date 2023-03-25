/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package q2classmodels;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author isaac
 */
public class main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //switch what code is commented to see the 2 screens
        Parent root = FXMLLoader.load(getClass().getResource("Screens/StartMenu.fxml"));
        Scene scene = new Scene(root);
        Ship ship = new Ship("alcor",9,9,9);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
