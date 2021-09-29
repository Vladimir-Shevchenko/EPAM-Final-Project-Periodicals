package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReplenishDao {


    private static final Logger log = Logger.getLogger(ReplenishDao.class);


    public  static String replenish(String amount, String username){


       // Connection conn = ConnectionPool.getInstance().getConnection();
        Connection conn =    MySqlDataSourceFactory.createMySqlDataSource();  //getConnection();


      int moneyNow =  MoneyDao.getMoney(username);
int am = Integer.parseInt(amount);
        System.out.println("am:  "+am);

        System.out.println("moneyNow:  "+moneyNow);
       if( moneyNow >0  ){

           MoneyDao.updateMoney(am+moneyNow+"",username);
           return "updated replenish";
       }else {


           String sql = "insert into money (username, money) values(?,?)";
           //String sql = "insert into orders ( username) values(?)";
           try {
               conn.setAutoCommit(false);
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, username);
               ps.setInt(2, Integer.parseInt(amount));

               ps.executeUpdate();
               conn.commit();
           } catch (SQLException e) {
               try {
                   conn.rollback();
               } catch (SQLException ex) {
                   log.error("Это сообщение ошибки", ex);

               }
               log.error("Это сообщение ошибки", e);
           } finally {
               try {
                   conn.setAutoCommit(true);
                   conn.close();
               } catch (SQLException e) {
                   log.error("Это сообщение ошибки", e);
               }
           }
           return "Condrats, you have replenished successfully!";


       }//if


       }


}
