package action;

import dao.SimpleUserDao;
import model.SimpleUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Regeditclass extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ss = request.getSession();
        String username = request.getParameter("username");
        String userpassword = request.getParameter("password");
        if (username == null || userpassword == null || username == "" || username == "" || userpassword == "") {
            request.getRequestDispatcher("errorregedit.html").forward(request, response);
            return;

        }
        SimpleUser su = new SimpleUser();
        su.setName(username);
        su.setPassword(userpassword);
        SimpleUserDao sud = new SimpleUserDao();
        try {
            sud.adduser(su);
            request.getRequestDispatcher("index.html").forward(request, response);
            //System.out.println("hihi");
            return;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.getRequestDispatcher("errorregedit.html").forward(request, response);
            return;
        }
    }

}
