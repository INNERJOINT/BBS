package dao;

import model.Topic;
import randomdata.RandomTool;
import tool.DBUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDao {

	
	public Topic namequery(int topicid) throws SQLException{
		
		Connection cnn=DBUtill.getConnection();
		String sql=""+"select * from topic where id=? ";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		
		ptmt.setInt(1, topicid);
		
		Topic tmp=new Topic();;
		
		ResultSet rs=ptmt.executeQuery();
		rs.next();
			
			tmp.setTopiccontent(rs.getString("topiccontent"));
			tmp.setTopicname(rs.getString("topicname"));
			tmp.setUserid(rs.getInt("userid"));
			tmp.setId(rs.getInt("id"));
			

			if(tmp.getTopicname()==null){
				
				tmp.setId(12);
				tmp.setTopiccontent("dsdsa");
				
				tmp.setTopicname("dsdsa");
			}
		
		return tmp;
		
	}
	public int mainquery(int sortid) throws SQLException{

		Connection cnn=DBUtill.getConnection();
		String sql=""+"select COUNT(*) from topic where sortid=?";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		
		ptmt.setInt(1, sortid);
	
		int tmp=1;
		
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			tmp=rs.getInt(1);
			
			
		}
		return tmp;
		
	}
public int userquery(int userid) throws SQLException{
		
		//��ȡtopic��Ŀ
		Connection cnn=DBUtill.getConnection();
		String sql=""+"select COUNT(*) from topic where userid=?";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		
		ptmt.setInt(1, userid);
	
		int tmp=1;
		
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			tmp=rs.getInt(1);
			
			
		}
		return tmp;
		
	}
	public List<Topic> mainquery(int page, int sortid) throws SQLException{
		List<Topic> result=new ArrayList<>();

		Connection cnn=DBUtill.getConnection();
		String sql=""+"select * from topic where sortid=? LIMIT ?,20";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		
		ptmt.setInt(1, sortid);
		ptmt.setInt(2, 20*(page-1));
		Topic tmp=null;
		
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			tmp=new Topic();
			tmp.setId(rs.getInt("id"));
			tmp.setResponsetime(rs.getString("responsetime"));
			tmp.setSendtime(rs.getString("sendtime"));
			tmp.setSortid(rs.getInt("sortid"));
			tmp.setTopicname(rs.getString("topicname"));
			tmp.setUserid(rs.getInt("userid"));
			tmp.setSendtime(rs.getString("sendtime"));
			
			result.add(tmp);
		}
		return result;
		
	}
	public List<Topic> userquery(int page, int userid) throws SQLException{
		List<Topic> result=new ArrayList<>();
		//��ȡtopic�б�
				Connection cnn=DBUtill.getConnection();
				String sql=""+"select * from topic where userid=? LIMIT ?,20";
				PreparedStatement ptmt=cnn.prepareStatement(sql);
				
				ptmt.setInt(1, userid);
				ptmt.setInt(2, 20*(page-1));
				Topic tmp=null;
				
				ResultSet rs=ptmt.executeQuery();
				while(rs.next()){
					tmp=new Topic();//rs.getString();rs.getInt();
					tmp.setId(rs.getInt("id"));
					tmp.setResponsetime(rs.getString("responsetime"));
					tmp.setSendtime(rs.getString("sendtime"));
					tmp.setSortid(rs.getInt("sortid"));
					tmp.setTopicname(rs.getString("topicname"));
					tmp.setUserid(rs.getInt("userid"));
					tmp.setSendtime(rs.getString("sendtime"));
					
					result.add(tmp);
				}
		
		
		
		return result;
		
	}
	public void addtopic(Topic topic) throws SQLException{
		Connection cnn=DBUtill.getConnection();
		String sql=""+"INSERT INTO topic(topicname,topiccontent,sendtime ,responsetime,userid, sortid) VALUES(?,?,current_date(),current_date(),?,?)";
		PreparedStatement ptmt=cnn.prepareStatement(sql);
		/*
		 *
		 * ptmt.setInt(, );
			ptmt.setString(, );
		*/
		ptmt.setString(1,topic.getTopicname() );
		ptmt.setString(2, topic.getTopiccontent());
		
		 ptmt.setInt(3,topic.getUserid() );
		 ptmt.setInt(4, topic.getSortid());
		
		ptmt.execute();
		
	}
	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		RandomTool rdt=new RandomTool();
		TopicDao tpd=new TopicDao();
		Topic tp=null;
		for(int i=1;i<=800;i++){
			System.out.println(i);
			tp=new Topic();
			tp.setTopicname(rdt.Randomchenghu()+rdt.Randomchenghu());
			tp.setTopiccontent(rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu()+rdt.Randomfuhao()+rdt.Randomchenghu());
			tp.setUserid(rdt.Randomnum(2, 41));
			tp.setSortid(rdt.Randomnum(2,5));
			tpd.addtopic(tp);
		}
	}

}
