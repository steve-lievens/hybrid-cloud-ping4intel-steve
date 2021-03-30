package data.util;

import util.Config;
import util.Crypto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

    private static final String KEY_DB_URL = "db.url";
    private static final String KEY_DB_USER = "db.username";
    private static final String KEY_DB_PWD = "db.password";

    private static final String url;
    private static final String username;
    private static final String password;

    private SqlConnection(){}

    static {
        url = Config.getInstance().readSetting(KEY_DB_URL);
        username = Crypto.getInstance().decrypt(Config.getInstance().readSetting(KEY_DB_USER));
        password = Crypto.getInstance().decrypt(Config.getInstance().readSetting(KEY_DB_PWD));

    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }

}
