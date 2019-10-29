package Lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<KeyValue, Text, Text, Text> {

    @Override
    protected void reduce(KeyValue key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        Iterator<Text> iter = values.iterator();


        String airportName = iter.next().toString();

        if (iter.hasNext()){
            float max = Float.parseFloat(iter.next().toString());
            float min = max;
            float average = max;
            int count = 1;


            while (iter.hasNext()) {

                float delay = Float.parseFloat(iter.next().toString());

                if (delay > max) {
                    max = delay;
                }

                if (delay < min) {
                    min = delay;
                }

                average += delay;
                count++;
            }

            average /= count;

            Text outText = new Text(airportName + ";   Average delay time: " + average + ";   Maximum delay time: "+ max+";   Minimum delay time: "+min);

            Text outKey = new Text (String.valueOf(key.getKey()));

            context.write(outKey, outText);

        }
    }
}