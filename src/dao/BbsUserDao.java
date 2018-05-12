package dao;

import model.BbsUser;
import randomdata.RandomTool;
import tool.DBUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BbsUserDao {
public BbsUser mainquery(int id) throws SQLException{
		
		//��ȡSimpleUser
				Connection cnn=DBUtill.getConnection();
				String sql=""+"select * from bbsuser where id= ? ";
				PreparedStatement ptmt=cnn.prepareStatement(sql);
				ptmt.setInt(1, id);
				BbsUser tmp=null;
				ResultSet rs=ptmt.executeQuery();
				while(rs.next()){
					tmp=new BbsUser();
					tmp.setId(rs.getInt(1));
					tmp.setName(rs.getString(2));
					tmp.setPassword(rs.getString(3));
					tmp.setOlds(rs.getInt(10));
					tmp.setEmail(rs.getString(11));
					tmp.setTel(rs.getString(12));
					tmp.setBirth(rs.getString(6));
					tmp.setJoindate(rs.getString(7));
					tmp.setAvatarid(rs.getInt(9));
					tmp.setSignature(rs.getString(8));
					tmp.setLv(rs.getInt(4));
					tmp.setSex(rs.getInt(5));
					
					
					
				}
		return tmp;
		
	}
	public void updateziliao(BbsUser bbsuser) throws SQLException{
		Connection cnn=DBUtill.getConnection();
		String sql="UPDATE bbsuser SET sex=? ,birth=? ,signature=? ,olds =?,email=? ,tel=? WHERE id= ?;";
		PreparedStatement ptmt=cnn.prepareStatement(sql);


		ptmt.setInt(1,bbsuser.getSex());
		ptmt.setString(2, bbsuser.getBirth());
		ptmt.setString(3, bbsuser.getSignature());
		ptmt.setInt(4, bbsuser.getOlds());
		ptmt.setString(5, bbsuser.getEmail());
		ptmt.setString(6, bbsuser.getTel());
		ptmt.setInt(7,bbsuser.getId());
		ptmt.execute();
		
		
		
	}
	public void updatetouxiang(BbsUser bbsuser) throws SQLException{
		Connection cnn=DBUtill.getConnection();
		String sql=""+"	UPDATE bbsuser SET avatarid= ? WHERE id= ?;";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		/*
		 *
		 * ptmt.setInt(, );
			ptmt.setString(, );
		*/
		ptmt.setInt(1,bbsuser.getAvatarid());
		
		ptmt.setInt(2,bbsuser.getId());
		
		ptmt.execute();;
		
		
	}
	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		RandomTool rdt=new RandomTool();
		BbsUser bu=null;
		BbsUserDao bud=new BbsUserDao();
		for(int i=12;i<=41;i++){
			bu=new BbsUser();
			/*bu.setSex(rdt.Randomnum(1, 2));
			int date=rdt.RandomDate();
			bu.setBirth(date+"");
			bu.setSignature(rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu());
			int olds=(100+17-(date/10000));
			bu.setOlds(olds);
			bu.setId(i);
			bud.updateziliao(bu);*/
			bu.setAvatarid(rdt.Randomnum(1, 9));
			bu.setId(i);
			bud.updatetouxiang(bu);
		}
	}

}
