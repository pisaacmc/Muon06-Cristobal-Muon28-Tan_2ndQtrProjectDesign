/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package q2classmodels.Screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import q2classmodels.*;
import java.util.ArrayList;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Isaac
 */
public class MerchantScreenController implements Initializable {
    private Ship player;
    private Merchant merchant;
    private ArrayList<Button> merchantItems = new ArrayList();
    private ArrayList<Button> playerItems = new ArrayList();
    @FXML private TilePane merchantItemView;
    @FXML private TilePane playerItemView;
    @FXML private Label playerGold;
    @FXML private Label playerInfluence;
    @FXML private Label playerItemName;
    @FXML private Label playerItemType;
    @FXML private Label playerItemCost;
    @FXML private Label playerItemWorth;
    @FXML private Label merchantItemName;
    @FXML private Label merchantItemType;
    @FXML private Label merchantItemCost;
    @FXML private Label merchantItemWorth;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView influence = new ImageView(new Image(getClass().getResourceAsStream("influence.png")));
        influence.setFitHeight(40);
        influence.setPreserveRatio(true);
        playerInfluence.setGraphic(influence);
    }
    public void setPlayer (Ship player){
        this.player = player;
        playerItems.clear();
        for (Item i : player.getInventory()){
            createPlayerItemTile(i);
        }
    }
    public void createMerchant (){
        this.merchant = new Merchant(player);
        merchantItems.clear();
        merchantItemView.getChildren().clear();
        for (Item i : merchant.getInventory()){
            createMerchantItemTile(i);
        }        
    }
    private void createMerchantItemTile(Item item){        
        merchantItems.add(new Button());
        Button blank =  merchantItems.get(merchantItems.size()-1);
        blank.setText(item.getName());
        blank.setMaxSize(60, 60);
        merchantItemView.getChildren().add(blank);
    }
    private void createPlayerItemTile(Item item){
        
        playerItems.add(new Button());
        Button blank =  playerItems.get(playerItems.size()-1);
        blank.setText(item.getName());
        blank.setMaxSize(60, 60);
        playerItemView.getChildren().add(blank);
    }
    public void updateStats(){
        String gold = String.valueOf(player.getGold());
        System.out.println("name " +player.getName());
        
        System.out.println("gold " +gold);
        //String influence = String.valueOf(player.getInfluence());
        //System.out.println("ahah "+influence);
        //playerInfluence.setText(influence);        
    }
}
