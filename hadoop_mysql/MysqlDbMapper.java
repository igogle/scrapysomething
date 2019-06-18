package hadoop_mysql;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
 
import java.io.IOException;
 
public class MysqlDbMapper extends Mapper<LongWritable,MysqlDb_scoreWritable,IntWritable,MysqlDb_scoreWritable> {
 
    protected void map(LongWritable key, MysqlDb_scoreWritable value, Context context) throws IOException, InterruptedException {
        System.out.println(value.toString());
        int sid = value.getSid();
        context.write(new IntWritable(sid),value);
    }
}