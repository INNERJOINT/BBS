package action;

import dao.BbsUserDao;
import dao.ResponseDao;
import dao.SimpleUserDao;
import dao.TopicDao;
import model.Response;
import model.SimpleUser;
import model.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Dperson extends HttpServlet {

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numpage = 1;
        int numuid = 23;
        int numturn = 1;
        int touxiangid = 1;
        try {
            String stringpage = request.getParameter("page");
            String stringturn = request.getParameter("turn");
            String stringuid = request.getParameter("uid");
            if (stringpage != null)
                numpage = Integer.parseInt(stringpage);
            if (stringturn != null)
                numturn = Integer.parseInt(stringturn);
            if (!(numturn > 0 && numturn < 3)) {
                int ss = 10 / 0;
            }
            System.out.println("11");
            BbsUserDao bud = new BbsUserDao();
            if (stringuid != null)
                numuid = Integer.parseInt(stringuid);
            SimpleUserDao sud = new SimpleUserDao();
            TopicDao td = new TopicDao();
            ResponseDao rd = new ResponseDao();
            System.out.println("11");
            int begin, end, total;
            SimpleUser user = sud.mainquery(numuid);
            touxiangid = bud.mainquery(numuid).getAvatarid();

            //topic
            List<Topic> topiclist = td.userquery(numpage, numuid);
            request.setAttribute("contentlistt", topiclist);


            //response
            List<Response> responselist = rd.userqurey(numpage, numuid);
            request.setAttribute("contentlistr", responselist);
            if (numturn == 1)
                total = td.userquery(numuid);
            else
                total = rd.userquery(numuid);
            System.out.println("11");
            total = (total + 19) / 20;

            if (total < 7) {
                if (total > 1) {
                    begin = 1;
                    end = total;
                } else {
                    begin = 1;
                    end = 1;

                }

            } else {
                if (numpage - 2 > 1 && numpage + 3 < total + 1) {
                    begin = numpage - 2;
                    end = numpage + 3;
                } else {
                    if (numpage - 2 < 2) {
                        begin = 1;
                        end = 6;
                    } else {
                        begin = total - 5;
                        end = total;
                    }
                }
            }
            request.setAttribute("user", user);
            request.setAttribute("turn", numturn);
            request.setAttribute("pagenum", numpage);
            request.setAttribute("touxiangid", touxiangid);
            request.setAttribute("begin", begin);
            request.setAttribute("end", end);
            request.setAttribute("total", total);

            request.getRequestDispatcher("Dperson.jsp").forward(request, response);
            return;


        } catch (Exception e) {
            request.getRequestDispatcher("errorperson.html").forward(request, response);
            return;

        }

    }

}
