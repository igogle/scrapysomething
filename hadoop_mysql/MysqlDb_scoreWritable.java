package hadoop_mysql;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;
 
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class MysqlDb_scoreWritable implements Writable,DBWritable {
 
    private int id;
    private int sid;
    private int cid;
    private int score;
    private int totalscore;
 
    /**
     *数据序列化
     */
    public void write(DataOutput out) throws IOException {
        out.writeInt(id);
        out.writeInt(sid);
        out.writeInt(cid);
        out.writeInt(score);
        out.writeInt(totalscore);
    }
 
    public void readFields(DataInput in) throws IOException {
        this.id = in.readInt();
        this.sid = in.readInt();
        this.cid = in.readInt();
        this.score = in.readInt();
        this.totalscore = in.readInt();
    }
 
    
     //* 数据库读写
  //  * 向topscore中写入值

    public void write(PreparedStatement statement) throws SQLException {
        statement.setInt(1,sid);
        statement.setInt(2,totalscore);
    }
//从score中读取成绩
    public void readFields(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt(1);
        sid = resultSet.getInt(2);
        cid = resultSet.getInt(3);
        score = resultSet.getInt(4);
    }
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getTotalscore() {
        return totalscore;
    }
    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id",id);
        json.put("sid",sid);
        json.put("cid",cid);
        json.put("score",score);
        return json.toString();
    }
}