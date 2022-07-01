package model;

        import java.sql.DriverManager;
        import java.sql.Connection;
        
public class Conexion {
    
        private static final String bbdd="jdbc:mysql://localhost:3306/disquera";
        private static final String usuario="root";
        private static final String clave="";
        private static Connection con;

        public static Connection conectar(){

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection(bbdd,usuario,clave);
                System.out.println("Conexion exitosa");
            }catch(Exception e) {
                System.out.println("Error de conexion a la base de datos "+e.getMessage().toString());
                }
                return con;
        } 

        public static void main(String[] args) {
        Conexion.conectar();
        }
}

