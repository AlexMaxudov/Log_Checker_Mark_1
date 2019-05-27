package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.collections.*;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.AnchorPane;


public class Controller {
    Label selectedLbl = new Label();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane form_1;

    @FXML
    private TextField ip_adr;

    @FXML
    private TextField track_file;

    @FXML
    private TextField name_file;

    @FXML
    private Button start_check;

    @FXML
    private Button add_adr_in_list;

    @FXML
    private ListView<String> list_log_file;

    @FXML
    private Button del_adr_in_list;

    @FXML
    private Button del_old_log;

    @FXML
    private Button move_old_log;




    @FXML
    void initialize() {
        //ObservableList<String> list = FXCollections.observableArrayList(List_View_View.config_open(Main.config));
        list_log_file.setItems(List_View_View.config_open(Main.config));
       // MultipleSelectionModel<String> langsSelectionModel = list_log_file.getSelectionModel();
      //  langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
          //  public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){

           //     selectedLbl.setText("Selected: " + newValue);
          //  }
     //   });
        del_adr_in_list.setOnAction(event -> {
            Write_Config.del_config(list_log_file.getSelectionModel().getSelectedIndex(), Main.config);
            list_log_file.setItems(List_View_View.config_open(Main.config));
        });

       add_adr_in_list.setOnAction(event -> {
           int status =  Write_Config.up_config(ip_adr.getText(), track_file.getText(), name_file.getText(), Main.config);
           switch (status) {
               case 4:
                    ip_adr.setText("");
                    track_file.setText("");
                    name_file.setText("");
                    list_log_file.setItems(List_View_View.config_open(Main.config));
                    break;

               case 0:
                   System.out.println("Файл config не удалось создать или записать, нужно создать окно с выводом этого сообщения");
                   break;

               case 1:
                   Animate_Form anim_ip = new Animate_Form(ip_adr);
                   anim_ip.play_animate();
                   break;

               case 2:
                   Animate_Form anim_track = new Animate_Form(track_file);
                   anim_track.play_animate();
                   break;

               case 3:
                   Animate_Form anim_name = new Animate_Form(name_file);
                   anim_name.play_animate();
                   break;
           }
       });

       start_check.setOnAction(event -> {

           Open_File del_file = new Open_File();
           ArrayList<String> list_del = new ArrayList<String>(del_file.buf_file(Main.config));
           if (list_del.get(0) != null) {

               start_check.getScene().getWindow().hide();
               Start_Ch new_window = new Start_Ch();
               try {
                   new_window.check_window();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

       });

       del_old_log.setOnAction(event -> {
           Open_File del_file = new Open_File();
           ArrayList<String> list_del = new ArrayList<String>(del_file.buf_file(Main.config));
           if (list_del.get(0) != null) {
               Start_Ch new_modal_win = new Start_Ch();
               try {
                   new_modal_win.modal_1();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });

       move_old_log.setOnAction(event -> {
           Open_File del_file = new Open_File();
           ArrayList<String> list_move = new ArrayList<String>(del_file.buf_file(Main.config));
           if (list_move.get(0) != null) {
               Date date = new Date();
               for (String i : list_move) {
                   if (i != null) {
                       File file = new File(i);
                       String old = "\\old_" + date.toString();
                       old = old.replace(":", "_");
                       String [] fold = i.split("\\\\");
                       i = fold[1];
                       String f = fold[0] + old;
                       //i = i.replace("\\", old);
                       System.out.println(i);
                       System.out.println(f);
                       File old_dir = new File(f);
                       old_dir.mkdir();
                       file.renameTo(new File (old_dir, i));
                   }
               }
           }
       });








    }
}
