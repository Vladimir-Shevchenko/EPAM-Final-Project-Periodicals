package database;

import Bean.LoginBean;
import org.apache.log4j.Logger;

import java.sql.*;

public class LoginDao {

    private static final Logger log = Logger.getLogger(LoginDao.class);


    public boolean validate(LoginBean loginBean) {

        Connection connection = ConnectionPool.getInstance().getConnection();
        // Connection connection =  MySqlDataSourceFactory.createMySqlDataSource();   // getConnection();
        boolean status = false;
        String sql = "select * from member where uname = ? and password = ?";
        PreparedStatement ps;
        try {
            ps =   connection.prepareStatement(sql);
            ps.setString(1, loginBean.getUsername());
            ps.setString(2, loginBean.getPassword());

            ResultSet rs = ps.executeQuery();
           // status = rs.next();

            while (rs.next()){
            String isBlocked =   rs.getString("isBlocked");
                status = true;
                if(isBlocked==null){isBlocked="Blocked";}
               if(isBlocked==null||isBlocked.equals("Blocked")) {
                   status = false;
               }
            }
        } catch (SQLException e) {
            log.error("Ошибка", e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Ошибка", e);          }
        }

        System.out.println("status: "+status);
        return status;
    }
}
