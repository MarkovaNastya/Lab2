package Lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapperAirports extends Mapper<LongWritable, Text, KeyValue, Text> {
    private static final int AIRPORT_ID=0;
    private static final int AIRPORT_NAME=1;
    private static final String 

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        ReaderCSV readerCSV = new ReaderCSV();

        readerCSV.parsLine(value);

        KeyValue keyValue = new KeyValue(
                readerCSV.getColumn(0),
                "0"
        );



    }
}
