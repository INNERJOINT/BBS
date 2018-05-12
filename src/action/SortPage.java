package action;

import dao.SimpleUserDao;
import dao.SortDao;
import dao.TopicDao;
import model.Sort;
import model.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SortPage extends HttpServlet {

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
        String sortnumstring = req.getParameter("sortnum");
        String pagestring = req.getParameter("page");
        int sortnum = 1;
        int topicnum = 1;
        if (sortnumstring != null && sortnumstring != "") {
            sortnum = Integer.parseInt(sortnumstring);

        }
        if (sortnum > 5 || sortnum < 1) {
            sortnum = 1;
        }
        int page = 1;
        if (pagestring != null && pagestring != "") {
            page = Integer.parseInt(pagestring);

        }

        SortDao sd = new SortDao();
        Sort sort = new Sort();
        try {
            sort = sd.mainqurey().get(sortnum - 1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.getRequestDispatcher("404.html").forward(req, resp);
            return;
        }
        if (sort == null) {
            req.getRequestDispatcher("404.html").forward(req, resp);
            return;

        }
        TopicDao td = new TopicDao();

        List<Topic> topiclist = null;
        ;
        try {
            topiclist = td.mainquery(page, sortnum);
            topicnum = td.mainquery(sortnum);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.getRequestDispatcher("404.html").forward(req, resp);
            return;
        }
        if (topiclist == null) {
            req.getRequestDispatcher("404.html").forward(req, resp);
            return;
        }
        SimpleUserDao sud = new SimpleUserDao();
        List<String> usernamelist = new ArrayList<String>();
        String tmp = null;
        for (int i = 0; i < topiclist.size(); i++) {
            try {
                tmp = sud.mainquery(topiclist.get(i).getUserid()).getName();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();


            }
            usernamelist.add(tmp);


        }
        req.setAttribute("sort", sort);
        req.setAttribute("topiclist", topiclist);
        req.setAttribute("usernamelist", usernamelist);
        req.setAttribute("topicnum", topicnum);
        req.setAttribute("pagenum", page);
        RequestDispatcher reqDispatcher = null;
        reqDispatcher = req.getRequestDispatcher("sortpage.jsp");
        reqDispatcher.forward(req, resp);
        return;
    }


}
