package action;

import dao.BbsUserDao;
import dao.ResponseDao;
import dao.SortDao;
import dao.TopicDao;
import model.Response;
import model.SimpleUser;
import model.Sort;
import model.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Xinhuifu extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SimpleUser su = (SimpleUser) session.getAttribute("user");
		if (su == null) {
			request.getRequestDispatcher("405.html").forward(request, response);
			return;
		}
		String huifu=request.getParameter("neirong");
		String topicids = (String) request.getParameter("topicid");
		if (huifu == null) {

			int topicid = Integer.parseInt(topicids);
			TopicDao td = new TopicDao();
			Topic topic = new Topic();
			SortDao sd = new SortDao();

			Sort sort = null;

			try {
				topic = td.namequery(topicid);

				sort = sd.sortnamequery(topicid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BbsUserDao bud = new BbsUserDao();
			request.setAttribute("topic", topic);
			request.setAttribute("sort", sort);
			request.getRequestDispatcher("xinhuifu.jsp").forward(request, response);
			return;
		} else {
			int topicid = Integer.parseInt(topicids);
			
			Response a=new Response();
			a.setTopicid(topicid);
			a.setUserid(su.getId());
			a.setRespcontent(huifu);
			ResponseDao rd=new ResponseDao();
			try {
				rd.addresponse(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("topic?topicid="+topicid).forward(request, response);
			return;
		}

	}

}
