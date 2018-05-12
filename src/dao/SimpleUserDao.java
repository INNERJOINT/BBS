package dao;

import model.SimpleUser;
import randomdata.RandomTool;
import tool.DBUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleUserDao {

	public SimpleUser mainquery(String name) throws SQLException{

				Connection cnn=DBUtill.getConnection();
				String sql=""+"select * from bbsuser where username= ? ";
				PreparedStatement ptmt=cnn.prepareStatement(sql);
				ptmt.setString(1, name);
				SimpleUser tmp=null;
				ResultSet rs=ptmt.executeQuery();
				while(rs.next()){
					tmp=new SimpleUser();
					tmp.setId(rs.getInt("id"));
					tmp.setName(rs.getString("username"));
					tmp.setPassword(rs.getString("password"));
					tmp.setLv(rs.getInt("lv"));
				}
		return tmp;
		
	}
public SimpleUser mainquery(int id) throws SQLException{
		
		//��ȡSimpleUser
				Connection cnn=DBUtill.getConnection();
				String sql=""+"select * from bbsuser where id= ? ";
				PreparedStatement ptmt=cnn.prepareStatement(sql);
				ptmt.setInt(1, id);
				SimpleUser tmp=null;
				ResultSet rs=ptmt.executeQuery();
				while(rs.next()){
					tmp=new SimpleUser();
					tmp.setId(rs.getInt("id"));
					tmp.setName(rs.getString("username"));
					tmp.setPassword(rs.getString("password"));
					tmp.setLv(rs.getInt("lv"));
				}
		return tmp;
		
	}
	public void adduser(SimpleUser simpleuser) throws SQLException{
		Connection cnn=DBUtill.getConnection();
		String sql=""+"INSERT INTO bbsuser(username,password,lv,joindate,avatarid,olds,email,tel) VALUES(?,?,1,current_date(),?,?,?,?)";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		/*
		 *
		 * ptmt.setInt(, );
			ptmt.setString(, );
		*/
		ptmt.setString(1,simpleuser.getName() );
		ptmt.setString(2,simpleuser.getPassword() );
		ptmt.setInt(3,1 );
		ptmt.setInt(4,1 );
		ptmt.setString(5,"youremail@email.com");
		ptmt.setString(6,"yourtelnum" );
		
		ptmt.execute();
		
		
	}
	public boolean isExist(String name) throws SQLException{
		SimpleUser su=mainquery(name);
		if(su==null)
			return false;
		return true;
	}
	public void updatemima(SimpleUser simpleuser) throws SQLException{
		Connection cnn=DBUtill.getConnection();
		String sql=""+"	UPDATE bbsuser SET password= ? WHERE id= ?;";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		/*
		 *
		 * ptmt.setInt(, );
			ptmt.setString(, );
		*/
		ptmt.setString(1,simpleuser.getPassword());
		
		ptmt.setInt(1,simpleuser.getId());
		
		ptmt.execute();
		
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		/*SimpleUserDao sud=new SimpleUserDao();
		System.out.println(sud.isExist("xiaotian"));
		System.out.println(sud.mainquery("xiaotian").getPassword());*/
		RandomTool rdt=new RandomTool();
		SimpleUser su=null;
		for(int i=0;i<30;i++){
			su=new SimpleUser();
			su.setName(rdt.Randomname(i));
			su.setPassword("123456");
			SimpleUserDao sud=new SimpleUserDao();
			sud.adduser(su);
			
		}
	}

}
