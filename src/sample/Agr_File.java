package sample;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Agr_File {
    public void agr_file (String name_file_log, ArrayList<String> looger) {
        try (FileWriter writer = new FileWriter (name_file_log, true)) {
            for (String i : looger) {
                writer.write("*-*" + i + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
