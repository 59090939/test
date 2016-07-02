package tryCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class tryMd5 {
    static String getMD5 (int length){
        Random rand = new Random();
        Random randdata = new Random();
        StringBuilder sb = new StringBuilder();
        int data = 0;
        for(int i = 0; i < length; ++i) {
            int index = rand.nextInt(3);
            switch (index) {
                case 0:
                    data = randdata.nextInt(10);          
                    StringBuilder append = sb.append(data);
                    break;
                case 1:
                    data = randdata.nextInt(26) + 65;  
                    sb.append((char) data);
                    break;
                case 2:
                    data = randdata.nextInt(26) + 97;  
                    sb.append((char) data);
                    break;
            }
        }
        return sb.toString();
    }

    static void insertSql(int number) throws SQLException {
        String user = "root";
        String secret = "222222";
        String url = "jdbc:mysql://192.168.103.105:3306/try";
        Connection conn = DriverManager.getConnection(url, user, secret);
 for(int i = 0; i < number; ++i){
            String sql = "insert into md5_2 (md5) values (\"" + getMD5(32) + "\");";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.executeUpdate();
        }
    }
   
    public static void main(String[] args) throws SQLException {
        insertSql(1000);
    }
}
