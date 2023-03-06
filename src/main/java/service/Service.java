package service;

import dao.Dao;
import model.PostInstagram;
import model.User;
import servlet.HomeServlets;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Service {
        private static Dao dao = new Dao();
        private static Service service;

        public static Service getInstance(){
            if(service == null){
                service = new Service();
                try {
                    dao.connectar();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return service;
        }

        public String getId(String username,String password) {
            return dao.getIdUser(username,password);
        }

        public User getUser(String id){
            return dao.getUsername(id);
        }

        public void setPost(String id,byte[] imageBytes,String title,String comment){
            PostInstagram post = new PostInstagram(id,title,imageBytes,comment, DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now()));
            dao.postInstagram(post);
        }

        public ArrayList<PostInstagram> getPosts(){
            return dao.getPosts();
        }

        public void deletePost(String id){
            dao.deletePost(id);
        }

        public void likePost(String id){
            dao.likePost(id);
        }


}
