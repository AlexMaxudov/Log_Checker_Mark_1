package sample;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;



public class Open_File {

    public  ArrayList<String> buf_file(String name) {
        BufferedReader bufer = null;
        try {

            bufer = new BufferedReader(new FileReader(name));
            ArrayList<String> file = new ArrayList<String>();
            String x;
            while((x=bufer.readLine()) != null) {
                file.add(x);

                //System.out.println(file);
            }  return file;
        } catch (IOException e) {
            //return("Error" +e);
        } finally {
            try {
                if (bufer != null) {
                    bufer.close();
                }
            } catch (IOException e) {
                // return("Error" +e);
            }
        }

        return null;
    }


}
