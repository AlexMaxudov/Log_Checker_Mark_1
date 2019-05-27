package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Check_Err_Window {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> err_list;

    @FXML
    private Button view_check_err;

    @FXML
    private Button view_check_err_all;

    @FXML
    private Button refresh_err;

    @FXML
    private Button add_edit;

    @FXML
    private Button all_err_file;

    @FXML
    private Button err_file;

    @FXML
    private TextArea more_list;

    @FXML
    void initialize() {
        assert err_list != null : "fx:id=\"err_list\" was not injected: check your FXML file 'check_err.fxml'.";
        assert view_check_err != null : "fx:id=\"view_check_err\" was not injected: check your FXML file 'check_err.fxml'.";
        assert view_check_err_all != null : "fx:id=\"view_check_err_all\" was not injected: check your FXML file 'check_err.fxml'.";
        assert refresh_err != null : "fx:id=\"refresh_err\" was not injected: check your FXML file 'check_err.fxml'.";
        assert add_edit != null : "fx:id=\"add_edit\" was not injected: check your FXML file 'check_err.fxml'.";
        assert all_err_file != null : "fx:id=\"all_err_file\" was not injected: check your FXML file 'check_err.fxml'.";
        assert err_file != null : "fx:id=\"err_file\" was not injected: check your FXML file 'check_err.fxml'.";
        assert more_list != null : "fx:id=\"more_list\" was not injected: check your FXML file 'check_err.fxml'.";

    }
}
