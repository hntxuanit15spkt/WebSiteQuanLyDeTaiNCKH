package connect;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnect {
    public static Connection getConnection() {
	Connection c = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");// initialize jdbc driver
	    c = (Connection) DriverManager
		    .getConnection("jdbc:mysql://localhost/quanlydetainghiencuukhoahoc?user=root&password=15110376");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return c;
    }
}
