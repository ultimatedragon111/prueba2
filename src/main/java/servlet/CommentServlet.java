package servlet;

import model.PostInstagram;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

    public CommentServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error","");
        getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("titol");
        String comment = req.getParameter("missatge");
        Part filePart = req.getPart("image");
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();
        String id = req.getParameter("id");
        if(id.isEmpty()){
            req.setAttribute("error","");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("id", id);
            Service.getInstance().setPost(id,imageBytes,title,comment);
            ArrayList<PostInstagram> array = Service.getInstance().getPosts();
            req.setAttribute("posts",array);
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req,resp);
        }
    }
}
