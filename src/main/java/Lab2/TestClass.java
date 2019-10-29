package Lab2;

public class TestClass {

    public static void main(String[] args) {
        String s ="\"10001\",\"Afognak Lake, AK: Afognak Lake Airport\"";
        ReaderCSV readerCSV = new ReaderCSV();
        readerCSV.parsLine(s);
    }
}
