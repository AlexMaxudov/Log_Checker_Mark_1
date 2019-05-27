package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Write_Config {
    public static void del_config (int index_list, String conf_adr) {
        if (index_list != -1) {
            Open_File file = new Open_File();
            ArrayList<String> list_adr = new ArrayList<>(Objects.requireNonNull(file.buf_file(conf_adr)));
            list_adr.remove(index_list);
            try (FileWriter writer = new FileWriter(Main.config, false)) {
                for (String i : list_adr) {
                    writer.write(i + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.print(list_adr);
        }

    }

    public static int up_config (String text1, String text2, String text3, String conf_adr) {
        //Запилить проверку что поля не пустые если пустые то уведомить пользователя
        if (text1.trim().isEmpty()) {
            return 1;
        } else if (text2.trim().isEmpty()) {
            return 2;
        } else if (text3.trim().isEmpty()) {
            return 3;
        } else {
            Open_File file = new Open_File();

            ArrayList<String> list_adr = new ArrayList<>(Objects.requireNonNull(file.buf_file(conf_adr)));
            if (!list_adr.contains(text1 + text2 + text3)) {
                list_adr.add(text1 + text2 + text3);
                try (FileWriter writer = new FileWriter(Main.config, false)) {

                    for (String i : list_adr) {
                        writer.write(i + "\n");
                    }
                    return 4;
                } catch (IOException e) {
                    e.printStackTrace();
                    return 0; // нужно создать окно с сообщением, что файл не удалось записать в случае если вернулся 0;
                }
            } else {
                return 5; // нужно создать окно с сообщением, что такой лог уже добавлен в мониторинг;
            }
        }
    }


}
