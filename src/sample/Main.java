package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Main extends Application {
    static String config = "E:\\config.txt";
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Настройка мониторинга");
        primaryStage.setScene(new Scene(root, 800, 500));
       // primaryStage.setX(1111.0);
       // primaryStage.setY(520.0);
        primaryStage.show();
    }

//    public void start1(Stage primaryStage) throws Exception{
    //    Parent root = FXMLLoader.load(getClass().getResource("lights.fxml"));
      //  primaryStage.setTitle("Мониторинг");
    //    primaryStage.setScene(new Scene(root, 165, 220));
        // primaryStage.setX(1111.0);
        // primaryStage.setY(520.0);
    //    primaryStage.show();
   // }
//

    public static void main(String[] args) {
        launch(args);
    }
}
