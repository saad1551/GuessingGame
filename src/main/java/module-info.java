module com.guessinggame.guessinggame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.guessinggame.guessinggame to javafx.fxml;
    exports com.guessinggame.guessinggame;
}
