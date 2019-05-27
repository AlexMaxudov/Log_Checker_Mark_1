package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class List_View_View {
    public static ObservableList<String> config_open (String conf_adr){
        Open_File file = new Open_File();
        ArrayList<String> list_adr = new ArrayList<String> (file.buf_file(conf_adr));
        ObservableList<String> list = FXCollections.observableArrayList(list_adr);
        return list;
    }
}
