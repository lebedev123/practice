package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("В теле метода init()");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("В теле метода start()");

        //Заголовок приложения
        primaryStage.setTitle("Каркас приложения JavaFX.JavaFX");
        //Корневой узел с плавающей компоновкой
        FlowPane rootNode = new FlowPane();

        Scene myscene = new Scene(rootNode,300,200);
        primaryStage.setScene(myscene);
        primaryStage.show();// отображение сцены
    }

    @Override
    public void stop() throws Exception {
        System.out.println("В теле метода stop()");
    }
}
