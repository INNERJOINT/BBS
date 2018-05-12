package action;

import dao.BbsUserDao;
import dao.ResponseDao;
import dao.SortDao;
import dao.TopicDao;
import model.BbsUser;
import model.Response;
import model.Sort;
import model.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Topics extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringtopicid = (String) request.getParameter("topicid");
		if (stringtopicid == null) {
			request.getRequestDispatcher("404.html").forward(request, response);
			return;
		}
		int numpage=1;
		
		int topicid=Integer.parseInt(stringtopicid);
		String	stringpage=request.getParameter("page");
		if(stringpage!=null)
			numpage=Integer.parseInt(stringpage);
		int begin,end,total=1;
		TopicDao td=new TopicDao();
		Topic topic =new Topic();
		SortDao sd=new SortDao();
		
		Sort sort=null;
		
		try {
			topic=td.namequery(topicid);
			sort = sd.sortnamequery(topicid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseDao rd=new ResponseDao();
		BbsUserDao bud=new BbsUserDao();
		BbsUser spc=null;
		List<Response> r=null;
		try {
			
			spc=bud.mainquery(topic.getUserid());
			 r=rd.mainqurey(numpage, topicid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<BbsUser> bulist=new ArrayList<BbsUser>();
		
		for(int i=0;i<r.size();i++){
			
			try {
				bulist.add(bud.mainquery(r.get(i).getUserid()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			total=rd.mainquery(topicid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		total=(total+19)/20;
		
		if (total<7) {
		if(total>1){
			begin = 1;
			end = total;
		}else{
			begin = 1;
			end = 1;
			
		}
		
	} else {
		if (numpage - 2 > 1 && numpage + 3 < total + 1) {
			begin = numpage - 2;
			end = numpage + 3;
		} else {if(numpage - 2 < 2){
			begin = 1;
			end = 6;
		}else{
			begin = total - 5;
			end = total;
			}
		}
	}
		request.setAttribute("topic", topic);
		
		request.setAttribute("sort", sort);
		request.setAttribute("spc", spc);
		
		request.setAttribute("pagenum", numpage);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.setAttribute("total", total);
		request.setAttribute("responselist", r);
		request.setAttribute("userlist", bulist);
		request.getRequestDispatcher("topic.jsp").forward(request, response);
		return;

	}

}
