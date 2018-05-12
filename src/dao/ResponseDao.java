package dao;

import model.Response;
import randomdata.RandomTool;
import tool.DBUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponseDao {

	public int mainquery(int topicid) throws SQLException {

		Connection cnn = DBUtill.getConnection();
		String sql = "" + "select COUNT(*) from response where topicid=?";
		PreparedStatement ptmt = cnn.prepareStatement(sql);

		ptmt.setInt(1, topicid);

		int tmp = 1;

		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			tmp = rs.getInt(1);

		}
		return tmp;

	}

	public int userquery(int userid) throws SQLException {

		// ��ȡtopic��Ŀ
		// ��ȡtopic��Ŀ
		Connection cnn = DBUtill.getConnection();
		String sql = "" + "select COUNT(*) from response where userid=?";
		PreparedStatement ptmt = cnn.prepareStatement(sql);

		ptmt.setInt(1, userid);

		int tmp = 1;

		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			tmp = rs.getInt(1);

		}
		return tmp;

	}

	public List<Response> mainqurey(int page, int topicid) throws SQLException {
		List<Response> result = new ArrayList<Response>();
		// ��ȡResponse�б�
		Connection cnn = DBUtill.getConnection();
		String sql = "" + "select * from response where topicid=? LIMIT ?,20";
		PreparedStatement ptmt = cnn.prepareStatement(sql);
		Response tmp = null;

		ptmt.setInt(1, topicid);
		ptmt.setInt(2, 20 * (page - 1));

		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			tmp = new Response();
			tmp.setId(rs.getInt("id"));
			tmp.setRespcontent(rs.getString("respcontent"));
			tmp.setSendtime(rs.getString("sendtime"));
			tmp.setTopicid(rs.getInt("topicid"));
			tmp.setUserid(rs.getInt("userid"));
			result.add(tmp);

		}
		return result;
	}

	public List<Response> userqurey(int page, int userid) throws SQLException {
		List<Response> result = new ArrayList<Response>();
		// ��ȡResponse�б�
		Connection cnn = DBUtill.getConnection();
		String sql = "" + "select * from response where userid=? LIMIT ?,20";
		PreparedStatement ptmt = cnn.prepareStatement(sql);
		Response tmp = null;

		ptmt.setInt(1, userid);
		ptmt.setInt(2, 20 * (page - 1));

		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			tmp = new Response();
			tmp.setId(rs.getInt("id"));
			tmp.setRespcontent(rs.getString("respcontent"));
			tmp.setSendtime(rs.getString("sendtime"));
			tmp.setTopicid(rs.getInt("topicid"));
			tmp.setUserid(rs.getInt("userid"));
			result.add(tmp);

		}
		return result;
	}

	public void addresponse(Response response) throws SQLException {
		Connection cnn = DBUtill.getConnection();
		String sql = "" + "INSERT INTO response(respcontent,sendtime,userid,topicid) VALUES(?,current_date(),?,?)";
		PreparedStatement ptmt = cnn.prepareStatement(sql);
		/*
		 *
		 * ptmt.setInt(, ); ptmt.setString(, );
		 */
		ptmt.setString(1, response.getRespcontent());
		ptmt.setInt(2, response.getUserid());

		ptmt.setInt(3, response.getTopicid());

		ptmt.execute();
		String sql1 = "" + "UPDATE topic SET responsetime=current_date() where id= ?";
		PreparedStatement ptmt1 = cnn.prepareStatement(sql1);
		/*
		 *
		 * ptmt.setInt(, ); ptmt.setString(, );
		 */

		ptmt1.setInt(1, response.getTopicid());

		ptmt1.execute();
		cnn.commit();

	}

	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		RandomTool rdt = new RandomTool();
		ResponseDao rsd = new ResponseDao();
		Response tp = null;
		for (int i = 1; i <= 16000; i++) {
			System.out.println(i);
			tp = new Response();

			tp.setRespcontent(rdt.Randomchenghu() + rdt.Randomfuhao() + rdt.Randomchenghu() + rdt.Randomfuhao()
					+ rdt.Randomchenghu() + rdt.Randomchenghu() + rdt.Randomfuhao() + rdt.Randomchenghu()
					+ rdt.Randomfuhao() + rdt.Randomchenghu() + rdt.Randomfuhao() + rdt.Randomchenghu()
					+ rdt.Randomfuhao() + rdt.Randomchenghu());
			tp.setUserid(rdt.Randomnum(2, 41));
			tp.setTopicid(rdt.Randomnum(2, 801));
			rsd.addresponse(tp);
		}

	}

}
