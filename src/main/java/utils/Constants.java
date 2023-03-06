package utils;

public class Constants {
    public static final String SCHEMA_NAME = "m06uf4servlets"; //modificar con el nombre de vuestro schema (Base de datos)
    public static final String CONNECTION =
            "jdbc:mysql://localhost:3306/" +
                    SCHEMA_NAME +
                    "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public static final String USER_CONNECTION = "root"; //modificar por vuestro usuario de BBDD (root)
    public static final String PASS_CONNECTION = "root"; //modificar por vuestro password de BBDD (root)
    public static final String RECUPERARID = "SELECT id FROM usuari WHERE usuari.usuari LIKE ? && password LIKE ?" ;
    public static final String INSERT_POST = "INSERT INTO post (id_usuari,title,image,message,dat,likes) VALUES (?,?,?,?,?,?)";
    public static final String GET_POSTS = "SELECT * FROM post;";
    public static final String GET_USERNAME = "SELECT * FROM usuari WHERE id LIKE ?";
    public static final String DELETE_POST = "DELETE FROM post WHERE id LIKE ?";

    public static final String LIKE_POST = "UPDATE post SET likes = likes + 1 where id like ?";
}
