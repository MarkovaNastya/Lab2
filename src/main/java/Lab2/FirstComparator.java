package Lab2;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FirstComparator extends WritableComparator {

    public FirstComparator() {
        super(KeyValue.class, true);
    }

    @Override
    public int compare(WritableComparable kv1, WritableComparable kv2) {
        KeyValue a = (KeyValue) kv1;
        KeyValue b = (KeyValue) kv2;
        return a.compareKeys(b);
    }
}