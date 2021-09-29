package database;

import Bean.Member;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllUsersDao {
    private static final Logger log = Logger.getLogger(AllUsersDao.class);










    public  static  List<Member> getAllUsers(){
       String uname = "";
       String email = "";
       String phone = "";
       String isBlocked = "";
       String money = "";
       String numberOrders = "";

       List<Member> list = new ArrayList<>();

        Connection connection = ConnectionPool.getInstance().getConnection();
        // Connection connection =  MySqlDataSourceFactory.createMySqlDataSource();                // getConnection();

        //String sql = "select * from member" ;
        String sql = "\n" +
                "select t1.uname, t1.email, t1.phone, t1.isBlocked, t2.money, t3.numberOrders from member as t1\n" +
                "left join money as t2 on t1.uname = t2.username\n" +
                "left join (select username, count(periodicals_id) as numberOrders from  orders group by username ) as t3 on t1.uname=t3.username;\n" +
                "\n" ;

///прописал скрипт, добавил в мембер поля, выбрать сетом стринг моней, флаг...
        PreparedStatement ps;
        try {
            ps =   connection.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                uname =  rs.getString("uname");
                email =  rs.getString("email");
                phone =  rs.getString("phone");
                isBlocked =  rs.getString("isBlocked")==null?"":rs.getString("isBlocked");
                money =  rs.getInt("money")==0?"":rs.getInt("money")+"";
                numberOrders =  rs.getInt("numberOrders")==0?"": rs.getInt("numberOrders")+"";

                list.add(new Member(uname,phone, email,isBlocked,money,numberOrders));
             //   System.out.println("from users dao:  "+isBlocked+"  "+money+"  "+numberOrders);
             //   System.out.println("isblocked:  "+ rs.getString("isBlocked"));
            }//while
            return list;

        } catch (SQLException e) {
            log.error("Это сообщение ошибки", e);
        }/*finally {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Это сообщение ошибки", e);
            }
        }*/


        return Collections.emptyList();

    }





    public static void blockUser(String blockUser) {

        Connection conn = ConnectionPool.getInstance().getConnection();
      //  Connection conn =    MySqlDataSourceFactory.createMySqlDataSource();
        String sql = "update member set isBlocked = 'Blocked' where uname = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1 ,blockUser);

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

    }






    public static void unblockUser(String unblockUser) {

        Connection conn = ConnectionPool.getInstance().getConnection();
      //  Connection conn =    MySqlDataSourceFactory.createMySqlDataSource();
        String sql = "update member set isBlocked = '' where uname = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1 ,unblockUser);

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

    }
}
