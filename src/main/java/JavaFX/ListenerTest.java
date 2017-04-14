package JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListenerTest extends Application {
    Label response;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Using Button and event");
        FlowPane rootNode = new FlowPane(10,10);//10 - зазоры между эл-тами
        rootNode.setAlignment(Pos.CENTER);//центрировать эл-ты управления на сцене
        Scene myscene = new Scene(rootNode,300,100);
        primaryStage.setScene(myscene);
        response = new Label("Push a button");
        Button Up = new Button("Up");
        Button Down = new Button("Down");
        Up.setOnAction(event -> {
            response.setText("You pushed up");
        });
        Down.setOnAction(event -> {
          response.setText("You pressed down");
        });
        rootNode.getChildren().addAll(Up,Down,response);//элементы добавляются в граф
        primaryStage.show();



    }
}
