package sample;

import java.util.ArrayList;

public class Potok_Logiki_Analiza extends Thread {
    static String config = "E:\\config.txt";
    static String name_file_log = "E:\\agr.txt";
    public void run () {
        ArrayList<String> looger;
        Check_File_log check = new Check_File_log();
        Agr_File agr = new Agr_File();
        looger = check.config_check(config);
        agr.agr_file(name_file_log, looger);



    }

}
