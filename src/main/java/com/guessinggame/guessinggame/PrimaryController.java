package com.guessinggame.guessinggame;

//import java.io.IOException;
//import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Button;

public class PrimaryController implements IView {

    
    // For yes/no responses to a question
    @Override
    public Boolean choose(String q) {
        String r = choose(q, "Yes", "No");
        return r.equals("Yes");
    }
    
    // more general version of choose - used to implement yes/no 
 // version above
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
