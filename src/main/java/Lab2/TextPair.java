package Lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TextPair implements WritableComparable<TextPair> {
    private int key;
    private String value;

    public TextPair() {
        this.key = 0;
        this.value = "";
    }


    public TextPair(int key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public int compareTo(TextPair o) {
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
