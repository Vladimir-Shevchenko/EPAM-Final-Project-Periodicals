package database;

import Bean.LoginBean;
import Bean.Periodical;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeriodicalsDao {

    private static final Logger log = Logger.getLogger(PeriodicalsDao.class);


    public static List<Periodical> getPeriodicals() {

        List<Periodical> list = new ArrayList<>();

        Connection connection = ConnectionPool.getInstance().getConnection();
       // Connection connection =  MySqlDataSourceFactory.createMySqlDataSource();                // getConnection();

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
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Это сообщение ошибки", e);           }
        }

        return Collections.emptyList();

    }


}
