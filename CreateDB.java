
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import javax.swing.JOptionPane;
public class CreateDB {
    public static void main(String[] args) throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            //String databaseName = "project";
            String userName = "root";
            String password = "Lokeshk@2003";

            //establishing connection.
            Connection connection = DriverManager.getConnection(url,userName, password);

            //create database
            //String sql = "CREATE DATABASE " + databaseName;

            String name="create table stu(sid int primary key,sname varchar(30),address char(10));";

            //statement--> is an objectfor executing  a static sql statement.
            //createStatement--> creates a Statement object for sending sql statements to the database.
            Statement statement = connection.createStatement();
            //statement.executeUpdate(sql);
            statement.executeUpdate(name);
            statement.close();

        /*note: if the database doesnot return value it returns false but it will create the database
        it returns true when we return any query like insert,delete,update etc..*/

            //pop-up to show database connected succesfully(GUI).
           // JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


