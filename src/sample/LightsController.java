package sample;

import java.io.IOException;
import java.lang.management.PlatformManagedObject;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.jmx.snmp.tasks.Task;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LightsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane color_pane;

    @FXML
    void initialize() {
        assert color_pane != null : "fx:id=\"color_pane\" was not injected: check your FXML file 'lights.fxml'.";
        color_pane.setOnMouseClicked(event -> {
            //color_pane.getScene().getWindow().hide();
            Start_Ch new_window_err = new Start_Ch();
            try {
                new_window_err.check_err_w();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // тут будет команда открытия нового окна с информацией по ошибкам
        });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

               // тут будет логика по смене цвета в случае наличия не просмотренной или просмотренной ошибки в agr файле
                // начнем while который будет смотреть есть ли файл в каталоге каждые пол минуты или минуту и если есть то проверять его на наличие ошибок, с доп условием *-* или *+*
                color_pane.setBackground(new Background(new BackgroundFill(Color.color(0.9, 0.0, 0.0), CornerRadii.EMPTY, Insets.EMPTY)));

            }
        });
        color_pane.setBackground(new Background(new BackgroundFill(Color.color(0.0, 0.0, 1.0), CornerRadii.EMPTY, Insets.EMPTY)));




        color_pane.setBackground(new Background(new BackgroundFill(Color.color(0.0, 0.5, 1.0), CornerRadii.EMPTY, Insets.EMPTY)));



        // Добавить условие которое будет менять цвет окна в зависимости от содержимого agr файла. В идеале, что бы оно работало в отдельном потоке.

    }

}
