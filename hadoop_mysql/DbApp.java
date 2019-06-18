package hadoop_mysql;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
 
public class DbApp {
 
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
 
        job.setJarByClass(DbApp.class);
        job.setJobName("mysql read write");
        job.setMapperClass(MysqlDbMapper.class);
        job.setReducerClass(MysqlDbReducer.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(MysqlDb_scoreWritable.class);
        job.setOutputKeyClass(MysqlDb_scoreWritable.class);
        job.setOutputValueClass(NullWritable.class);
 
 
        //�������ݿ���Ϣ
        String driverclass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.1.215:3306/school";
        String username = "root";
        String passwd = "root";
 
        DBConfiguration.configureDB(job.getConfiguration(),driverclass,url,username,passwd);
        //������������
        DBInputFormat.setInput(job,MysqlDb_scoreWritable.class,"select * from score","select count(id) from score");
 
        //�����������,��һ��string�Ǳ�����������Ը����string�Ǳ��ֶ���
        DBOutputFormat.setOutput(job,"topscore","sid","totalscore");
        job.waitForCompletion(true);
 
    }
}