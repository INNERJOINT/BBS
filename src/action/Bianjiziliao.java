package action;

import dao.BbsUserDao;
import model.BbsUser;
import model.SimpleUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Bianjiziliao extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringsex = request.getParameter("sex");
        HttpSession session = request.getSession();

        if (null == session.getAttribute("user")) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        SimpleUser su = (SimpleUser) session.getAttribute("user");
        BbsUserDao bud = new BbsUserDao();
        BbsUser bu = null;
        try {
            bu = bud.mainquery(su.getId());

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }
        if (bu == null) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;

        }


        if (null == stringsex) {
            request.setAttribute("sex", bu.getSex());
            request.setAttribute("birth", bu.getBirth());
            request.setAttribute("qianming", bu.getSignature());
            request.setAttribute("email", bu.getEmail());
            request.setAttribute("tel", bu.getTel());
            request.getRequestDispatcher("bianjiziliao.jsp").forward(request, response);
        } else {
            String email = request.getParameter("email");
            String tel = request.getParameter("tel");
            String stringbirth = request.getParameter("birth");
            String stringsignature = request.getParameter("qianming");
            int numsex = 1;
            if (email != null && tel != null && stringsex != null && stringbirth != null && stringsignature != null) {
                numsex = Integer.parseInt(stringsex);

            } else {
                request.getRequestDispatcher("404.html").forward(request, response);
                return;
            }

            if (numsex < 1 || numsex > 2) {
                numsex = 1;

            }

            bu.setBirth(stringbirth);
            bu.setSex(numsex);
            bu.setSignature(stringsignature);
            bu.setEmail(email);
            bu.setTel(tel);
            try {
                bud.updateziliao(bu);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.getRequestDispatcher("person?uid=" + su.getId()).forward(request, response);
            return;

        }


    }

}
