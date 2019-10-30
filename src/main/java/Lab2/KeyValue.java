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

    public int compareKeys(KeyValue kv){
        return Integer.compare(this.key, kv.key);
    }

    @Override
    public int compareTo(KeyValue kv) {
        if (Integer.compare(this.key, kv.key) != 0) {
            return Integer.compare(this.key, kv.key);
        } else {
            return Integer.compare(this.value, kv.value);
        }
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
        KeyValue keyValue = (KeyValue) o;
        return key == keyValue.key &&
                Objects.equals(value, keyValue.value);
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
