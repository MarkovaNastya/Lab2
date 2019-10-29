package Lab2;

import org.apache.hadoop.io.Text;

import java.awt.*;
import java.util.ArrayList;

public class ReaderCSV {

    private static final char QUOTES = '"';
    private static final char COMMA = ',';
    private static final char SPACE = ' ';

    private ArrayList<String> columns;

    public ReaderCSV(){
        columns=new ArrayList<>();
    }

    public void parsLine(Text t){
        String line = t.toString();
        for (int i = 0; i < line.length(); i++){
            if
        }
    }



}
