package Lab2;

import org.apache.hadoop.io.Text;

import java.util.ArrayList;

public class ReaderCSV {

    private static final char QUOTES = '"';
    private static final char COMMA = ',';

    private ArrayList<String> columns;

    public ReaderCSV() {
        columns = new ArrayList<>();
    }

    public void parsLine(Text t) {

        String line = t.toString();

        int countQuotes = 0;

        String currentColumn = "";

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != COMMA) {
                if (line.charAt(i) != QUOTES) {
                    currentColumn += String.valueOf(line.charAt(i));
                } else {
                    countQuotes++;
                }
            } else {
                if (countQuotes % 2 == 1) {
                    currentColumn += String.valueOf(line.charAt(i));
                } else {
                    columns.add(currentColumn);
                    currentColumn = "";
                }

            }
        }
        if (currentColumn.length() > 0) {
            columns.add(currentColumn);
        }
    }

    public String getColumn(int number){
        return this.columns.get(number);
    }

}
