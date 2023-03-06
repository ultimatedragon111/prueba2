package dao;

import model.PostInstagram;
import model.User;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    private Connection conexion;

    public void connectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = Constants.CONNECTION;
        String user = Constants.USER_CONNECTION;
        String pass = Constants.PASS_CONNECTION;
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public String getIdUser(String username, String password) {
        String select = Constants.RECUPERARID;
        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("id");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public void postInstagram(PostInstagram post) {
        try (PreparedStatement ps = conexion.prepareStatement(Constants.INSERT_POST)) {
            ps.setString(1, post.getId_usuari());
            ps.setString(2, post.getTitle());
            ps.setBytes(3, post.getImage());
            ps.setString(4, post.getMessage());
            ps.setString(5, post.getDat());
            ps.setInt(6, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<PostInstagram> getPosts() {
        ArrayList<PostInstagram> array = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(Constants.GET_POSTS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    PostInstagram post = new PostInstagram(rs.getString("likes"), rs.getString("id"), rs.getString("id_usuari"), rs.getString("title"), rs.getBytes("image"), rs.getString("message"), rs.getString("dat"));
                    array.add(post);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    public User getUsername(String id) {
        try (PreparedStatement ps = conexion.prepareStatement(Constants.GET_USERNAME)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User(id, rs.getString("usuari"), rs.getString("email"), rs.getString("linkedin"), rs.getString("gitlab"));
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deletePost(String id) {
        try (PreparedStatement ps = conexion.prepareStatement(Constants.DELETE_POST)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void likePost(String id) {
        try (PreparedStatement ps = conexion.prepareStatement(Constants.LIKE_POST)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
