package database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;






public class MySqlDataSourceFactory {

    private static final Logger log = Logger.getLogger(MySqlDataSourceFactory.class);


    private static Connection connection;

    public static Connection createMySqlDataSource(){
if(connection!=null){return connection;}
        MysqlDataSource dataSource = new MysqlDataSource();
        //  dataSource.setURL("jdbc:mysql://localhost:3306/sys");
        dataSource.setUser("root");
        dataSource.setPassword("meow");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("sys");
        dataSource.setPort(3306);


        try {
            connection =  dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            log.error("Ошибка", e);         }

        return null;
    }
}
