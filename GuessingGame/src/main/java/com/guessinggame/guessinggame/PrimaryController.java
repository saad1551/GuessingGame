package com.guessinggame.guessinggame;

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

/**
 * This is the PrimaryController class responsible for handling user interactions in the game.
 * It implements the IView interface and is initialized with JavaFX elements.
 * This controller connects the user interface with the game logic.
 */
public class PrimaryController implements IView, Initializable {
    
    private Game game; // Reference to the game instance
    private int counter; // Counter (not currently used)
    
    /**
     * Initialize the controller with the game.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.game = new Game(this); // Initialize the game with this controller as the view.
    }
    
    /**
     * Bind the controller to an existing game instance.
     *
     * @param g The game instance to bind to.
     */
    public void bind(Game g) {
        this.game = g;
    }

    @FXML
    private void handlePlayGameClick() {
        game.play(); // Handle the "Play Game" button click by starting the game.
    }
    
    @FXML
    private TextArea textarea; // Text area to display messages.
        
    @FXML
    private void handleLoadClick() {
        game.load(); // Handle the "Load" button click by loading a saved game.
    }
    
    @FXML
    private void handleSaveClick() {
        game.save(); // Handle the "Save" button click by saving the current game state.
    }
    
    @FXML
    private void handleDisplayTreeClick() {
        game.display(); // Handle the "Display Tree" button click by displaying the current game tree.
    }
    
    @FXML
    private void handleExitClick() {
        Platform.exit(); // Handle the "Exit" button click by exiting the application.
    }
    
    /**
     * Display the provided text in the TextArea.
     *
     * @param s The text to display.
     */
    @Override
    public void display(String s) {
        textarea.setText(s);
    }
    
    /**
     * Append the provided text to the TextArea.
     *
     * @param s The text to append.
     */
    @Override
    public void append(String s) {
        textarea.appendText(s);
    }
    
    /**
     * Ask a yes/no question and return the user's choice as a Boolean.
     *
     * @param q The question to ask.
     * @return True if the user chooses "Yes," else false.
     */
    @FXML
    @Override
    public Boolean choose(String q) {
        String r = choose(q, "Yes", "No");
        return r.equals("Yes");
    }
    
    /**
     * Ask a question with two possible answers and return the user's choice as a String.
     *
     * @param q The question to ask.
     * @param a1 The first answer choice.
     * @param a2 The second answer choice.
     * @return The user's chosen answer.
     */
    @FXML
    @Override
    public String choose(String q, String a1, String a2) {
        ButtonType b1 = new ButtonType(a1);
        ButtonType b2 = new ButtonType(a2);
        Alert alert = new Alert(Alert.AlertType.NONE, q, b1, b2);
        alert.setTitle("Choose");
        // Block execution until the user responds
        java.util.Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == b1)
            return a1;
        return a2;
    }
    
    /**
     * Validate user input to ensure it's not empty or whitespace.
     *
     * @param s The input to validate.
     * @return True if the input is valid, else false.
     */
    private boolean validate(String s) {
        // Check for a non-empty string or just whitespace
        // (should never be null but check anyway)
        return !((s == null) || ("".equals(s)) || (s.matches("\\s*")));
    }

    /**
     * Ask a question and get a non-empty text response from the user.
     *
     * @param q The question to ask.
     * @return The user's response as a trimmed string.
     */
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
        // Remove leading and/or trailing whitespace
        return s.trim();
    }
}
