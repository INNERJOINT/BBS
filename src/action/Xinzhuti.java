package action;

import dao.SortDao;
import dao.TopicDao;
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

public class Xinzhuti extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		SimpleUser su=(SimpleUser)session.getAttribute("user");
		if(su==null){
			request.getRequestDispatcher("405.html").forward(request, response);
			return;
		}
		
		String stringbiaoti = (String) request.getParameter("biaoti");
		if(stringbiaoti==null){
			String stringsortid = (String) request.getParameter("sortid");
			int sortid=Integer.parseInt(stringsortid);
			SortDao sd=new SortDao();
			
			Sort sort=null;
			
			try {
				
				
				sort = sd.sortnamequery(sortid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("22");
				e.printStackTrace();
			}
			request.setAttribute("sort", sort);
			request.getRequestDispatcher("xinzhuti.jsp").forward(request, response);
			return;
			
			
		}else{
			String stringneitong = (String) request.getParameter("neirong");
			String stringsortid = (String) request.getParameter("sortid");
			int sortid=Integer.parseInt(stringsortid);
			
			
			Topic topic=new Topic();
			topic.setUserid(su.getId());
			topic.setSortid(sortid);
			topic.setTopicname(stringbiaoti);
			topic.setTopiccontent(stringneitong);
			TopicDao td=new TopicDao();
			try {
				td.addtopic(topic);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("33");
			}
			request.getRequestDispatcher("sortpage?sortnum="+(sortid-1)).forward(request, response);
			return;
			
		}
		
		
	}

}
