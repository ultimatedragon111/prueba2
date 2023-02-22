package servlet;

import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/home")
public class HomeServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public HomeServlets(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String id = Service.getInstance().getId(username,password);
        if (id.isEmpty()){
            getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
        }
        else{
            req.setAttribute("id", id);
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req,resp);
        }

    }
}
