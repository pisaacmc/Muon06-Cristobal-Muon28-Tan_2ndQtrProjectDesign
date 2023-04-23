/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package q2classmodels.Screens;

import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Isaac
 */
public class HelpScreenController implements Initializable {

    @FXML
    private Label instructions;
    @FXML
    private Button prev;
    @FXML
    private Button menu;
    @FXML
    private Button next;
    private ArrayList<String> instructionsList = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instructionsList.add("Ok so This is more of a placeholder than anything, since we havent coded in the main gameplay loop yet.");
        instructionsList.add("Heyo! its another placeholder, just to show that our page-turners work!");
        instructions.setText(instructionsList.get(0));
        prev.setDisable(true);
    }    

    @FXML
    private void goToMenu(ActionEvent e) throws IOException{
        Node source = (Node)e.getSource();
        Scene scene=source.getScene();
        Stage stage = (Stage) scene.getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        stage.hide();
        stage.setScene(new Scene(root));
        stage.show();        

    }
    @FXML
    public void turnPage(ActionEvent e) {
        String instructionText = instructions.getText();
        Button source = (Button) e.getSource();
        int x = instructionsList.indexOf(instructionText);
        if (source == next) {
            next.setDisable(true);
            if(x != instructionsList.size() - 1){
                x++;
                next.setDisable(false);
            }
            instructions.setText(instructionsList.get(x));
            prev.setDisable(false);
       }

        if (source == prev) {
            prev.setDisable(true);
            if(!(x <= 0)){
                x--;
                prev.setDisable(false);
            }
            instructions.setText(instructionsList.get(x));
            next.setDisable(false);
        }

    }

    
}
