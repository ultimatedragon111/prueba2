package servlet;

import model.PostInstagram;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/delete")
public class DeleteServelet extends HttpServlet {
    public DeleteServelet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error","");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_post = req.getParameter("post");
        String id = req.getParameter("id");
        if(id.isEmpty()){
            req.setAttribute("error","");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else{
            Service.getInstance().deletePost(id_post);
            ArrayList<PostInstagram> array = Service.getInstance().getPosts();
            req.setAttribute("posts",array);
            req.setAttribute("id",id);
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req,resp);
        }
    }
}
