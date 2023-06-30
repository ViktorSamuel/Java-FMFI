import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;
import java.util.*;

public class Circles extends Application {

    private static final int[] RADIUS_OPTIONS = {5, 10, 15, 20, 25}; // Polomer možnosti
    private static final Color BLUE_COLOR = Color.BLUE;
    private static final Color RED_COLOR = Color.RED;
    private static final Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                Circle circle = new Circle(j * 60 + 30, i * 60 + 30, 25);
                circle.setFill(BLUE_COLOR);
                circle.setOnMouseClicked(event -> handleCircleClick(circle));
                pane.getChildren().add(circle);
            }
        }

        Scene scene = new Scene(pane, 600, 600);

        primaryStage.setTitle("Kruhy");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCircleClick(Circle circle) {
        Color currentColor = (Color) circle.getFill();
        Color newColor = (currentColor.equals(BLUE_COLOR)) ? RED_COLOR : BLUE_COLOR;
        circle.setFill(newColor);
        int newRadius = RADIUS_OPTIONS[random.nextInt(RADIUS_OPTIONS.length)];
        circle.setRadius(newRadius);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
