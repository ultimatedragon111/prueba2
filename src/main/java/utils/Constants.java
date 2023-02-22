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
}
