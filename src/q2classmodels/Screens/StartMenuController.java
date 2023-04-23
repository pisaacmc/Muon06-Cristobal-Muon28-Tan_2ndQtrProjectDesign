/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package q2classmodels.Screens;

import java.io.IOException;
import q2classmodels.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Optional;
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
        FXMLLoader loader;
        Parent root;
        switch (source.getId()){
            case "startButton":
                loader = new FXMLLoader(getClass().getResource("MerchantScreen.fxml"));
                root = loader.load();
                MerchantScreenController controller = loader.getController(); 
                TextInputDialog dialog = new TextInputDialog("Player 1");
                dialog.setTitle("Ready Player One");
                dialog.setHeaderText("Input Your Name:");                
                Optional<String> result = dialog.showAndWait();
                String name;
                name = result.orElse("Player 1");
                Ship player = new Ship(name,10,2,999);
                System.out.println("GOOOLD "+player.getGold());
                controller.setPlayer(player);
                controller.createMerchant();
                controller.updateStats();
                
                break;
            case "helpButton":
                loader = new FXMLLoader(getClass().getResource("HelpScreen_1.fxml"));
                root = loader.load();
                
                break;
            case "aboutButton":
                loader = new FXMLLoader(getClass().getResource("AboutScreen.fxml"));
                root = loader.load();
                
                break;
            default:
                loader = new FXMLLoader(getClass().getResource("MerchantScreen.fxml"));
                root = loader.load();
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
