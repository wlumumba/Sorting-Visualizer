package Main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        AnchorPane root = FXMLLoader.load(getClass().getResource("/Style/fxmls/main.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}
