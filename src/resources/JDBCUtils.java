package resources;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	/* 1. 用ResourceBundle加载配置文件
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
	}
	*/
	
	// 2. 用类加载器获得配置文件
	static{
		try {
			// 1. 通过当前类类加载器
			ClassLoader classLoader = JDBCUtils.class.getClassLoader();
			// 2. 通过类加载器获得一个输入流
			InputStream is = ClassLoader.getSystemResourceAsStream("db.properties");
			// 3. 创建Properties对象
			Properties pro = new Properties();
			// 4. 加载输入流
			pro.load(is);
			// 5. 获取相关参数
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;	
	}

	public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
