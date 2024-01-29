package MedicalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_connect {
    static Connection c;

    public static Connection createDBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/medicine?useSSL=false";
            String username="root";
            String password="Senthil7103";
            c = DriverManager.getConnection(url,username,password);
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
