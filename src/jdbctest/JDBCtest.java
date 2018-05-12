package jdbctest;

import tool.DBUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCtest {
	

	public static void main(String[] args) throws SQLException {

		Connection cnn=DBUtill.getConnection();
		String sql=""+"select * from sort LIMIT 0,1 ";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		
		
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			System.out.println("---------------------------------------");
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("sortname"));
			System.out.println(rs.getString("info"));
			System.out.println("---------------------------------------");
			
			
		}
		
	}

}
