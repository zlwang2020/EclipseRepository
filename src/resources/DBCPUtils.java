package resources;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	static{
		try {
			InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties pro = new Properties();
			pro.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
