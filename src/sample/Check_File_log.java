package sample;
import java.util.ArrayList;
import java.util.regex.Pattern;


public  class Check_File_log {

    public ArrayList<String> config_check (String conf_adr) {

        try {
            ArrayList<String>  rez_log = new ArrayList<String>();
            Open_File file1 = new Open_File();
            Open_File file2 = new Open_File();
            ArrayList<String> log_adr = new ArrayList<String> (file1.buf_file(conf_adr));
            for (String i : log_adr) {
                ArrayList<String> log = file2.buf_file(i);
                //Log_Checker.name_log = i.split("\\\\")[1];
                //rez_log = Analiz_Log.analiz(log);
                rez_log.add(i.split("\\\\")[1]);
                for (String s : Analiz_Log.analiz(log)) {
                    rez_log.add(s);
                } rez_log.add("\n");
            } return rez_log;

        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    // public static ArrayList<String> open_file () {
    //   ArrayList<String> log = Open_File.buf_file("E:\\notes.txt");
    //    return log;
    // }
}
