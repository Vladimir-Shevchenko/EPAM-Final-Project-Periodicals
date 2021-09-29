package database;

import Bean.Member;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    private static final Logger log = Logger.getLogger(RegisterDao.class);


    public   String insert(Member member){

        Connection con = ConnectionPool.getInstance().getConnection();
        //Connection con =    MySqlDataSourceFactory.createMySqlDataSource();  //getConnection();
        String sql = "insert into member (uname, password, email,phone, isBlocked) values(?,?,?,?,?)";
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,member.getUname());
            ps.setString(2,member.getPassword());
            ps.setString(3,member.getEmail());
            ps.setString(4,member.getPhone());
            ps.setString(5, "");
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                log.error("Это сообщение ошибки", ex);

            }
            log.error("Это сообщение ошибки", e);
        }finally {
//            try {
//                con.setAutoCommit(true);
//                 con.close();
                ConnectionPool.getInstance().closeAndSetAutoCommit(con);
//            } catch (SQLException e) {
//                log.error("Это сообщение ошибки", e);
//            }
        }
        return "Condrats, you have registered successfully!";
    }
}
