package electricity.billing.system;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

    Connection connection;
    Statement statement;

    database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system?useSSL=false&serverTimezone=UTC","root","root");
            statement = connection.createStatement();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
