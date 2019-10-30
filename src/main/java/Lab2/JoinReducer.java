package Lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<KeyValue, Text, Text, Text> {

    private static final String SPACE = " ";
    private static final int AIRPORT_NAME_LENGTH=75;
    private static final int DELAY_LENGTH=15;

    private String formatString(int len, String s){
        for (int i=s.length(); i<len;i++){
            s+=SPACE;
        }
        return s;
    }

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

            Text outText = new Text(formatString(AIRPORT_NAME_LENGTH, airportName) + "Average delay time: " + formatString(DELAY_LENGTH, String.valueOf(average)) + "Maximum delay time: "+ formatString(DELAY_LENGTH, String.valueOf(max))+"Minimum delay time: "+formatString(DELAY_LENGTH, String.valueOf(min)));

            Text outKey = new Text (String.valueOf(key.getKey()));

            context.write(outKey, outText);

        }
    }
}