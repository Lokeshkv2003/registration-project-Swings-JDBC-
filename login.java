import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class login {
    public static void main(String ar[]){
        JFrame f=new JFrame("Login-in");
        final JLabel label=new JLabel();
        label.setBounds(20, 30, 40, 50);
        f.add(label);



        JLabel l=new JLabel("Username:");
        l.setBounds(20,20,100,30);
        JTextField lo=new JTextField(null, null, 0);
        lo.setBounds(100,20, 100,30);
        f.add(l);
        f.add(lo);

        JLabel pass=new JLabel("Password:");
        pass.setBounds(20,70,100,30);
        final JPasswordField pa = new JPasswordField();
        pa.setBounds(100,70, 100,30);
        f.add(pass);
        f.add(pa);

       JButton sub=new JButton("Submit");
       sub.setBounds(20, 120, 100, 30);
       f.add(sub);
       f.setSize(300,300);f.setLayout(null);f.setVisible(true);

       sub.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                String url = "jdbc:mysql://localhost:3306/OnlineExam";
                String usern="root";
                String pass="Lokeshk@2003";
                String username = lo.getText();
                String password =pa.getText();
            Connection connection = DriverManager.getConnection(url,usern,pass);//connection

            System.out.println(username);
            System.out.println(password);

            String retrive="select * from student";      
            
            //String sql = "CREATE DATABASE " + database;

            Statement statement = connection.createStatement();
            //statement.executeUpdate(sql);
            //statement.executeUpdate(table);
            
            statement.executeLargeUpdate(retrive);
            statement.close();
            JOptionPane.showMessageDialog(null, retrive + " Record has Found", "System Message", JOptionPane.INFORMATION_MESSAGE);
                }
            catch(Exception l){
                System.out.println(l);
            }
            }
        
       });
    }}
