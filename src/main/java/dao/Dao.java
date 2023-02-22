package dao;

import utils.Constants;

import java.sql.*;

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
        if(conexion!=null){
            conexion.close();
        }
    }

    public String getIdUser(String username,String password) {
        String select = Constants.RECUPERARID;
        try(PreparedStatement ps = conexion.prepareStatement(select)){
            ps.setString(1,username);
            ps.setString(2,password);
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
}
