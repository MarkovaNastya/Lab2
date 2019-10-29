package Lab2;

public class TestClass {

    public static void main(String[] args) {
        //String s ="\"10001\",\"Afognak Lake, AK: Afognak Lake Airport\"";
        String s = "2015,1,1,4,7,2015-01-04,\"AA\",19805,\"AA\",\"N367AA\",\"7\",11298,1129803,30194,13830,\"2050\",\"2056\",261.00,261.00,0.00,\"\",464.00,3711.00,";
        ReaderCSV readerCSV = new ReaderCSV();
        readerCSV.parsLine(s);
    }
}
