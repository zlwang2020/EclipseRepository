package resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3P0Utils {
	@Test
	public void test() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//从连接池中获取连接
//			conn = C3P0Utills.getConnection();
			conn = DBCPUtils.getConnection();
			String sql="select * from firsttable";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+"---"+rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, rs);
		}
	}
}
