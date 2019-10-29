package Lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class KeyValue implements WritableComparable<KeyValue> {
    private int key;
    private int value;

    public KeyValue() {
        this.key = 0;
        this.value = 0;
    }

    public KeyValue(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int compareKeys(KeyValue tp){
        return Integer.compare(this.key, tp.key);
    }

    @Override
    public int compareTo(KeyValue tp) {
        if (this.key == tp.key ){
            if (this.value == tp.value){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.key);
        dataOutput.writeInt(this.value);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.key=dataInput.readInt();
        this.value = dataInput.readInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyValue)) return false;
        KeyValue textPair = (KeyValue) o;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
