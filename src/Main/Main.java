package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Hello World");

//        HBox hBox = new HBox();
//        hBox.setSpacing(5);
//        // 1 pixel padding between child nodes only
//        //hBox.setPadding(new Insets(1));
////        Rectangle r1 = new Rectangle(10, 10);
////        Rectangle r2 = new Rectangle(20, 100);
////        Rectangle r3 = new Rectangle(10, 20);
////        Rectangle r4 = new Rectangle(20, 50);
//
//        Button b1 = new Button("One");
//
//        hBox.setAlignment(Pos.BOTTOM_RIGHT);
//
//        //HBox.setMargin(r1, new Insets(2, 2, 2, 2));
//
//        //hBox.getChildren().addAll(r1, r2, r3, r4);
//        hBox.getChildren().addAll(b1);
//        root.getChildren().add(hBox);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();



    }

    public static void main(String[] args) {

        launch(args);
    }
}
