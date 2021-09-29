package database;

import Bean.Member;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddOrderDao {


    private static final Logger log = Logger.getLogger(AddOrderDao.class);


    public  static String insertOrder(String periodicalId, String username){


        Connection conn = ConnectionPool.getInstance().getConnection();
      //  Connection conn =    MySqlDataSourceFactory.createMySqlDataSource();  //getConnection();
        String sql = "insert into orders (periodicals_id, username) values(?,?)";
        //String sql = "insert into orders ( username) values(?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(periodicalId));
            ps.setString(2 ,username);

            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                log.error("Это сообщение ошибки", ex);

            }
            log.error("Это сообщение ошибки", e);
        }finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                log.error("Это сообщение ошибки", e);
            }
        }
        return "Condrats, you have added order successfully!";
    }


}
