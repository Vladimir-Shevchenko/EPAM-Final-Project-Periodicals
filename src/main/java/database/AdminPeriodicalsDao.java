package database;

import Bean.Periodical;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminPeriodicalsDao {


    private static final Logger log = Logger.getLogger(AdminPeriodicalsDao.class);


    public static List<Periodical> getPeriodicals() {

        List<Periodical> list = new ArrayList<>();

        Connection connection = ConnectionPool.getInstance().getConnection();

        //Connection connection =  MySqlDataSourceFactory.createMySqlDataSource();                // getConnection();

        String sql = "select * from periodicals";
        PreparedStatement ps;
        try {
            ps =   connection.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                int id =                 rs.getInt("Periodicals_id");
                String name =            rs.getString("name");
                int price =              rs.getInt("price");
                String type        =     rs.getString("type");
                String  description =    rs.getString("description");

                Periodical periodical = new Periodical(id,name,price,type, description);
                list.add(periodical);
            }//while
            return list;

        } catch (SQLException e) {
            log.error("Это сообщение ошибки", e);
        }finally {
//            try {
//                connection.close();
                ConnectionPool.getInstance().close(connection);
//
//            } catch (SQLException e) {
//                log.error("Это сообщение ошибки", e);
//            }
        }

        return Collections.emptyList();

    }


    public static void addPeriodical(String name, String price, String type, String description) {

        Connection con = ConnectionPool.getInstance().getConnection();

       // Connection con = MySqlDataSourceFactory.createMySqlDataSource();

        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("insert into periodicals (name,price,type,description)values(?,?,?,?)");
            ps.setString(1,name);
            ps.setInt(2,Integer.parseInt(price));
            ps.setString(3,type);
            ps.setString(4,description);

            ps.executeUpdate();

            con.commit();


        } catch (SQLException e) {
            try {
                con.rollback();
                log.error("Это сообщение ошибки", e);

            } catch (SQLException ex) {
                log.error("Это сообщение ошибки", ex);

            }

        }finally {
//            try {
//                con.setAutoCommit(true);
//                con.close();
                ConnectionPool.getInstance().closeAndSetAutoCommit(con);
//
//            } catch (SQLException exc) {
//                log.error("Это сообщение ошибки", exc);            }
        }



    }

    public static void deletePeriodical(String id) {

        Connection con = ConnectionPool.getInstance().getConnection();
      //  Connection con = MySqlDataSourceFactory.createMySqlDataSource();


        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("delete from periodicals where periodicals_id = ?");
        ps.setInt(1,Integer.parseInt(id));
ps.executeUpdate();
con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                log.error("Это сообщение ошибки", e);
            } catch (SQLException ex) {
                log.error("Это сообщение ошибки", e);
            }

        }finally {
//            try {
//                con.setAutoCommit(true);
//               con.close();
                ConnectionPool.getInstance().closeAndSetAutoCommit(con);

//            } catch (SQLException e) {
//                log.error("Это сообщение ошибки", e);
//            }
        }
    }

    public static void editPeriodical(String id, String name, String price, String type, String description) {

        Connection con = ConnectionPool.getInstance().getConnection();
        //Connection con = MySqlDataSourceFactory.createMySqlDataSource();

        System.out.println("next.....   "+id);
        System.out.println("next.....   "+price);
        System.out.println("next.....   "+name);
        System.out.println("parseint:  "+ Integer.parseInt(price));

        try {
            con.setAutoCommit(false);
            String sql = "update periodicals set name = ?  , price = ? , type = ? , description = ? where periodicals_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,Integer.parseInt(price));
            ps.setString(3,type);
            ps.setString(4,description);
            ps.setInt(5,Integer.parseInt(id));

            ps.executeUpdate();
            con.commit();

        } catch (SQLException e) {
            try {
                con.rollback();
                log.error("Это сообщение ошибки", e);
            } catch (SQLException ex) {
                log.error("Это сообщение ошибки", e);
            }

        }finally {
//            try {
//                con.setAutoCommit(true);
//                  con.close();
                ConnectionPool.getInstance().closeAndSetAutoCommit(con);

//            } catch (SQLException e) {
//                log.error("Это сообщение ошибки", e);
//            }
        }
    }
}
