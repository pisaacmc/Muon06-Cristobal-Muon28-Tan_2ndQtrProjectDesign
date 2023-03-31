/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package q2classmodels.Screens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Isaac
 */
public class StartMenuController implements Initializable {

    @FXML
    private Label instructions;
    @FXML
    private Button prev;
    @FXML
    private Button menu;
    @FXML
    private Button next;
    @FXML
    public void goToPage(ActionEvent e) throws IOException{
        Node source = (Node)e.getSource();
        Scene scene=source.getScene();
        Stage stage = (Stage) scene.getWindow();
        Parent root;
        switch (source.getId()){
            case "startButton":
                root = FXMLLoader.load(getClass().getResource("MerchantScreen.fxml"));
                break;
            case "helpButton":
                root = FXMLLoader.load(getClass().getResource("HelpScreen.fxml"));
                break;
            case "aboutButton":
                root = FXMLLoader.load(getClass().getResource("AboutScreen.fxml"));
                break;
            default:
                root = FXMLLoader.load(getClass().getResource("MerchantScreen.fxml"));
                System.exit(0); 
                break;
        }
        stage.hide();
        stage.setScene(new Scene(root));
        stage.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
