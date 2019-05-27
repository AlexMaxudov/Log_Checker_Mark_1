package sample;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Modal_1_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button yes;

    @FXML
    void initialize() {
        assert yes != null : "fx:id=\"yes\" was not injected: check your FXML file 'Modal_1.fxml'.";
        yes.setOnAction(event -> {
          Open_File del_file = new Open_File();
          ArrayList<String> list_del = new ArrayList<String>(del_file.buf_file(Main.config));
          for (String i : list_del) {
              if (i != null) {
                File file = new File(i);
                file.delete();
              }
            }
            yes.getScene().getWindow().hide();
        });

    }
}
