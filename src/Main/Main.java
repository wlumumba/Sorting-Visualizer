package Main;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = FXMLLoader.load(getClass().getResource("/Style/fxmls/main.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();

    }


        /*
        Label label = new Label("Bla bla bla bla");

        Button btn = new Button("flash");
        VBox box = new VBox(10, label, btn);
        box.setPadding(new Insets(10));

        btn.setOnAction((ActionEvent event) -> {

            //**************************
            //this animation changes the background color
            //of the VBox from red with opacity=1
            //to red with opacity=0
            //**************************
            final Animation animation = new Transition() {

                {
                    setCycleDuration(Duration.millis(1000));
                    setInterpolator(Interpolator.EASE_OUT);
                }

                @Override
                protected void interpolate(double frac) {
                    Color vColor = new Color(1, 0, 0, 1 - frac);
                    box.setBackground(new Background(new BackgroundFill(vColor, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            };
            animation.play();

        });

        Scene scene = new Scene(box, 100, 100);

        primaryStage.setScene(scene);
        primaryStage.show();

*/


    public static void main(String[] args) {

        launch(args);
    }
}
