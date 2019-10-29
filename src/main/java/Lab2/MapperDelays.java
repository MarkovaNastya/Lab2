package Lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class MapperDelays extends Mapper<LongWritable, Text, KeyValue, Text> {
    private static final int AIRPORT_ID = 14;
    private static final int DELAY = 17;
    private static final String AIRPORT_FLAG = "1";
    private static final String TITLE="\"YEAR\",\"QUARTER\",\"MONTH\",\"DAY_OF_MONTH\",\"DAY_OF_WEEK\",\"FL_DATE\",\"UNIQUE_CARRIER\",\"AIRLINE_ID\",\"CARRIER\",\"TAIL_NUM\",\"FL_NUM\",\"ORIGIN_AIRPORT_ID\",\"ORIGIN_AIRPORT_SEQ_ID\",\"ORIGIN_CITY_MARKET_ID\",\"DEST_AIRPORT_ID\",\"WHEELS_ON\",\"ARR_TIME\",\"ARR_DELAY\",\"ARR_DELAY_NEW\",\"CANCELLED\",\"CANCELLATION_CODE\",\"AIR_TIME\",\"DISTANCE\",";

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        if (!value.toString().equals(TITLE)) {
            ReaderCSV readerCSV = new ReaderCSV();

            readerCSV.parsLine(value);

            KeyValue keyValue = new KeyValue(
                    Integer.parseInt(readerCSV.getColumn(AIRPORT_ID)),
                    AIRPORT_FLAG
            );

            context.write(keyValue, new Text(readerCSV.getColumn(DELAY)));
        }

    }
}
