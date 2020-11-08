package Main;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;


public class AnimationTest {

    public void start(Stage primaryStage) throws Exception {
        //Loading in and setting it to scene
        //Parent Main = FXMLLoader.load(getClass().getResource("AnimationTest.fxml"));
        //Scene mainScene = new Scene(Main);

        int rowNum = 10;
        int colNum = 10;

        GridPane grid = new GridPane();
        Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED};
        Random rand = new Random();


        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                int n = rand.nextInt(4);
                javafx.scene.shape.Rectangle rec = new Rectangle();

                rec.setWidth(10);
                rec.setHeight(7);
                //rec.setFill(colors[n]);
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.setHgap(2);
                grid.getChildren().addAll(rec);
            }
        }

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setTitle("Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
