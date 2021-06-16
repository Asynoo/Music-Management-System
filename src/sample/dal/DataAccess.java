package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class DataAccess {
    private SQLServerDataSource dataSource;

    public DataAccess()
    {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setUser("CSe20B_27");
        dataSource.setPassword("KDgfkyhtfyhO8321749823");
        dataSource.setDatabaseName("iTunes_of_the_world");
    }

    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }
}