package action;

import dao.SimpleUserDao;
import model.SimpleUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class Login extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = (String) req.getParameter("username");
        String password = req.getParameter("password");

        RequestDispatcher reqDispatcher = null;
//		if(name==null||name==""||password==null||password==""){
//			reqDispatcher=req.getRequestDispatcher("errorlogin.html");
//			reqDispatcher.forward(req,resp);
//			return;
//		}

        SimpleUserDao sud = new SimpleUserDao();
        SimpleUser su = null;
        try {
            su = sud.mainquery(name);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            reqDispatcher = req.getRequestDispatcher("errorlogin.html");
            reqDispatcher.forward(req, resp);
            return;
        }
        if (su == null) {
            reqDispatcher = req.getRequestDispatcher("errorlogin.html");
            reqDispatcher.forward(req, resp);
            return;

        }
        ;
//		System.out.printf("su.getPassword(): %s\n",su.getPassword());
//		System.out.printf("su.getName(): %s\n",su.getName());
//		System.out.println("-------------------------");
//		System.out.printf("req.getParameter(username): %s\n",req.getParameter("username"));
//		System.out.printf("req.getParameter(password): %s\n",req.getParameter("password"));
        if (su.getPassword().equals(password)) {
//			System.out.printf("output.jsp %s\n"," ");
            HttpSession session = req.getSession();
            session.setAttribute("user", su);
            reqDispatcher = req.getRequestDispatcher("selectsort");

        } else {
//			System.out.printf("404.html %s\n"," ");

            reqDispatcher = req.getRequestDispatcher("errorlogin.html");

        }

        reqDispatcher.forward(req, resp);
        return;
    }

    public static void main(String[] args) throws SQLException {
        String name = "zhushi";
        SimpleUserDao sud = new SimpleUserDao();
        SimpleUser su = sud.mainquery(name);
        if (su == null)
            return;
        System.out.println("-----------------");
        System.out.println(su.getName() + "  " + su.getPassword() + su.getId());
        System.out.println("-----------------");
    }


}
