package dao;
import model.Sort;
import tool.DBUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SortDao {
public Sort sortnamequery(int topicid) throws SQLException{
		
		Connection cnn=DBUtill.getConnection();
		String sql=""+"select  * from sort where id in ( select sortid from topic where id= ?) ";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		
		ptmt.setInt(1, topicid);
		
		Sort tmp=new Sort();;
		
		ResultSet rs=ptmt.executeQuery();
		rs.next();
			
			tmp.setId(rs.getInt("id"));
			tmp.setSortname(rs.getString("sortname"));
			
			
			
			
		
		if(tmp.getSortname()==null){
			
			tmp.setId(12);
			tmp.setSortname("dsdsa");
			
			
		}
		return tmp;
		
	}
	public List<Sort> mainqurey() throws SQLException{
		List<Sort> result=new ArrayList<>();

		Connection cnn=DBUtill.getConnection();
		String sql=""+"select * from sort ";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		Sort tmp=null;
		
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			tmp=new Sort();
			tmp.setId(rs.getInt("id"));
			tmp.setSortname(rs.getString("sortname"));
			tmp.setInfo(rs.getString("info"));
			result.add(tmp);
			
			
		}
		return result;
		
	}
	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		SortDao sd=new SortDao();
		List<Sort> result=sd.mainqurey();
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).getId());
			System.out.println(result.get(i).getSortname());
			System.out.println(result.get(i).getInfo());
			
		}
		
	}

}
