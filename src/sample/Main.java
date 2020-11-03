package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        //Creating a print statement to output - Moses
        System.out.println("Hello, I am Moses");

        //Cliff is creating a print statement
        System.out.print("Hello, this is Ciff");

        //Khalid creating print statement
        System.out.println("Hello, this is Khalid");

    }


    public static void main(String[] args) {

        launch(args);
    }
}
