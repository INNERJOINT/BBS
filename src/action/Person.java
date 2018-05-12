package action;

import dao.BbsUserDao;
import model.BbsUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Person extends HttpServlet {

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
        String uidstring = request.getParameter("uid");

        if (uidstring == null || uidstring == "") {
            request.getRequestDispatcher("errorperson.html").forward(request, response);
            return;
        }
        int uid;
        BbsUser bu = null;

        try {
            uid = Integer.parseInt(uidstring);

            BbsUserDao bud = new BbsUserDao();
            bu = bud.mainquery(uid);

            if (bu == null) {
                double s = 10 / 0;
            }

        } catch (Exception e) {
            request.getRequestDispatcher("errorperson.html").forward(request, response);
            return;

        }
        request.setAttribute("person", bu);
        request.getRequestDispatcher("person.jsp").forward(request, response);


    }

}
