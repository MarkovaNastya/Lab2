package Lab2;

public class TestClass {

    public static void main(String[] args) {
        //String s ="\"10001\",\"Afognak Lake, AK: Afognak Lake Airport\"";
        String s = "2015,1,1,10,6,2015-01-10,\"AA\",19805,\"AA\",\"N790AA\",\"1\",12478,1247802,31703,12892,\"1225\",\"1235\",0.00,0.00,0.00,\"\",345.00,2475.00,";
        ReaderCSV readerCSV = new ReaderCSV();
        readerCSV.parsLine(s);
    }
}
