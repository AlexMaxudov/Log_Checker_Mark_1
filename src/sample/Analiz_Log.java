package sample;
import java.util.ArrayList;

public class Analiz_Log {
    public static ArrayList<String> analiz (ArrayList<String> log) {
// написать код чтения лога и поиска в нем ошибки, затем возвращать строку или список с ошибкой
        ArrayList<String> log_err = new ArrayList<>();
        for (String logs : log) {

            if (logs.contains("(ERR)")) {
                log_err.add(logs);
            }
        } return log_err;
    }


}
