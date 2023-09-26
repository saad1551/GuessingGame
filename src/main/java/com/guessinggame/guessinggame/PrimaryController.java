package com.guessinggame.guessinggame;

//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class PrimaryController implements IView, Initializable{
    
    private Game game;
    private int counter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.game = new Game(this);
    }
    
    public void bind(Game g) {
        this.game = g;   
    }

    @FXML
    private void handlePlayGameClick() {
        game.play();
    }
    
    @FXML
    private TextArea textarea;
        
    @FXML
    private void handleLoadClick() {
//        System.out.println(game);
        game.load();
    }
    
    
    @FXML
    private void handleSaveClick() {
        game.save();
    }
    
    @FXML
    private void handleDisplayTreeClick() {
        game.display();
    }
    
    
    
    @FXML
    private void handleExitClick() {
        Platform.exit();
    }

    

    @Override
    public void display(String s) {
        textarea.setText(s);
    }
    
    @Override
    public void append(String s) {
        textarea.appendText(s);
    }
    
    // For yes/no responses to a question
    @FXML
    @Override
    public Boolean choose(String q) {
        String r = choose(q, "Yes", "No");
        return r.equals("Yes");
    }
    
    // more general version of choose - used to implement yes/no 
 // version above
    @FXML
    @Override
    public String choose(String q, String a1, String a2) {
        ButtonType b1 = new ButtonType( a1 );
        ButtonType b2 = new ButtonType( a2 );
        Alert alert = new Alert(Alert.AlertType.NONE, q, b1, b2 );
        alert.setTitle( "Choose" );
        // Block execution until the user responds
        java.util.Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == b1 )
            return a1;
        return a2;
    }
    
    // minimal validation - ensure that some non-whitespace is 
    //entered
    private boolean validate(String s) {
        // check non empty string or just whitespace 
        // (should never be null but check anyway)
        
        return !((s == null) || ("".equals(s)) || (s.matches("\\s*")));
    }

    
    @Override
    @FXML
    public String ask(String q) {
        String r = q + "\nText is required.";
        String s = "";
        boolean valid = false;
        while (!valid) {
            TextInputDialog tid = new TextInputDialog("");
            tid.setHeaderText(q);
            // Disable the cancel button
            Button cancel = (Button) tid.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancel.setDisable(true);
            // Block execution until the user responds
            tid.showAndWait();
            s = tid.getEditor().getText();
            valid = validate(s);
            if (!valid) {
                q = r;
            }
        }
        // remove leading and/or trailing whitespace
        return s.trim();
    }

    
}
