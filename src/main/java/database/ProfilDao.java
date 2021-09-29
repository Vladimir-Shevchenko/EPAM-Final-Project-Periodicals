package database;

import Bean.Periodical;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfilDao {


    private static final Logger log = Logger.getLogger(ProfilDao.class);


    public static List<Periodical> getMyPeriodicals(String username) {


        List<Periodical> list = new ArrayList<>();

        Connection connection = ConnectionPool.getInstance().getConnection();
       // Connection connection =  MySqlDataSourceFactory.createMySqlDataSource();                // getConnection();

        String sql = "select t1.periodicals_id, t1.name,t1.type, t1.price, t1.description" +
                " from periodicals as t1" +
                " join orders as t2 on t1.periodicals_id = t2.periodicals_id" +
                "                       and t2.username = '"+  username   +"'";


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
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Это сообщение ошибки", e);           }
        }

        return Collections.emptyList();

    }




}
