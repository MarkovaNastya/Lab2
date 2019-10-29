package Lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FirstPartitioner extends Partitioner<KeyValue, Text> {
    @Override
    public int getPartition(KeyValue key, Text value, int numReduceTasts){
        return Integer.hashCode(key.getKey()) % numReduceTasts;
    }
}
