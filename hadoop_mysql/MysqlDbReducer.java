package hadoop_mysql;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
 
import java.io.IOException;
 
public class MysqlDbReducer extends Reducer<IntWritable,MysqlDb_scoreWritable,MysqlDb_scoreWritable,NullWritable> {
 
    protected void reduce(IntWritable key, Iterable<MysqlDb_scoreWritable> values, Context context) 
throws IOException, InterruptedException {
        int totalScore = 0;
        for(MysqlDb_scoreWritable m : values){
            totalScore += m.getScore();
        }
        MysqlDb_scoreWritable score = new MysqlDb_scoreWritable();
        score.setSid(key.get());
        score.setTotalscore(totalScore);
        context.write(score,NullWritable.get());
    }
}
