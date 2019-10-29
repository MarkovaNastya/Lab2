package Lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

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

    public int compareKeys(TextPair tp){
        return Integer.compare(this.key, tp.key);
    }

    @Override
    public int compareTo(TextPair tp) {
        if (this.key == tp.key ){
            if (this.value.equals(tp.value)){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.key);
        dataOutput.writeChars(this.value);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.key=dataInput.readInt();
        this.value = dataInput.readLine();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextPair)) return false;
        TextPair textPair = (TextPair) o;
        return key == textPair.key &&
                Objects.equals(value, textPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
