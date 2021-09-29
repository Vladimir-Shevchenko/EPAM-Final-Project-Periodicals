package database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * Connection Pool implementation
 * @author Vladimir Shevchenko
 */

public class ConnectionPool {

    private static final Logger log = Logger.getLogger(ConnectionPool.class);


    private ConnectionPool(){
        //private constructor
    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance(){
        if (instance==null)
            instance = new ConnectionPool();
        return instance;
    }

    public  Connection getConnection(){
        Context ctx;
        Connection c = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/poolName");
            c = ds.getConnection();
        } catch (NamingException e) {
            log.error("Ошибка", e);
        } catch (SQLException e) {
            log.error("Ошибка", e);         }
        return c;
    }

    public void closeAndSetAutoCommit(Connection con){

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close(Connection con){

        try {
            con.close();
        } catch (SQLException e) {
            log.error("Ошибка", e);
        }
    }

}