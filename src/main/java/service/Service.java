package service;

import dao.Dao;
import servlet.HomeServlets;

import java.sql.SQLException;

public class Service {
        private Dao dao = new Dao();
        private static Service service;

        public static Service getInstance(){
            if(service == null){
                service = new Service();
            }
            return service;
        }

        public String getId(String username,String password) {
            try {
                dao.connectar();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return dao.getIdUser(username,password);
        }

}
