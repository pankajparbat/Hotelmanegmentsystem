package Hotel.Managment.System;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn()  {
        try {
            Class.forName("com.mysql-connector-java-8.0.28.jar");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Papa@123");
            s=c.createStatement();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
