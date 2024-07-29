import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;   
public class registration {
    public static void main(String args[]) throws Exception
    {
        JFrame  f=new JFrame("Registration");
        final JLabel label=new JLabel();
        label.setBounds(20,30,40,50);

        JLabel rn=new JLabel("Enter Roll.No:");
        rn.setBounds(20,20,100,30);      //creating roll_no
        final JTextField text1 = new JTextField();
        text1.setBounds(120,20, 100,30);
        f.add(rn);
        f.add(text1);

        JLabel name=new JLabel("Enter name:");
        name.setBounds(20,60,100,30);   //creating name
        final JTextField text2 = new JTextField();
        text2.setBounds(120,60, 100,30);
        f.add(name);
        f.add(text2);

        JLabel l1=new JLabel("Enter Username:");
        l1.setBounds(20,100,200,30);  //creating username
        final JTextField text = new JTextField();
        text.setBounds(120,100, 100,30);

        JLabel l2=new JLabel("Enter Password:");
        final JPasswordField value = new JPasswordField();
        value.setBounds(120,153,120,24);   //creating password
        l2.setBounds(20,150,100,30);

        JLabel l3=new JLabel("Gender:");
        l3.setBounds(20,190,80,30);       //creating gender
        JRadioButton r1=new JRadioButton("Male");    
        JRadioButton r2=new JRadioButton("Female");
        ButtonGroup bg=new ButtonGroup();    
        bg.add(r1);bg.add(r2);   
        r1.setBounds(175,190,100,30);    
        r2.setBounds(75,190,100,30); 

        JLabel l4=new JLabel("Phone no:");
        l4.setBounds(20,240,80,30);
        final JTextField t1=new JTextField("+91");    //creating phone-no
        t1.setBounds(100,245,100,20);

       /*  JLabel l5=new JLabel("DOB:");
        l5.setBounds(20,290,80,30);
        JComboBox d=new JComboBox();                     //creating DOB
        d.setBounds(70, 295,50,20);
        JComboBox m=new JComboBox();
        m.setBounds(130, 295,50,20);
        JTextField y=new JTextField();    
        y.setBounds(200, 295,50,25); */

       /* JLabel l6=new JLabel("Hobbies:");
        l6.setBounds(20,240,80,30);
        JCheckBox checkBox1 = new JCheckBox("Cricket");  
        checkBox1.setBounds(200,240, 80,30);  
        JCheckBox checkBox2 = new JCheckBox("Readingbooks", true);  
        checkBox2.setBounds(110,240,80,30);
        JCheckBox checkBox3 = new JCheckBox("Watching tv", true);  
        checkBox3.setBounds(110,280,80,30);
        JCheckBox checkBox4 = new JCheckBox("football", true);  
        checkBox4.setBounds(300,280,80,30);*/
        JButton b = new JButton("Submit");  
        b.setBounds(20,350, 80,30);    //submit-button

        JButton cancel=new JButton("Cancel") ;
        cancel.setBounds(150,350,80,30); //cancel-button

        /*Adding in frame👇👇 */
        f.add(text);
        //f.add(checkBox1);  
        //f.add(checkBox2);
        //f.add(checkBox3);  
        //f.add(checkBox4);
        f.add(b);
        f.add(l4);
        //f.add(l5);
        //f.add(d);
        //f.add(m);
        //f.add(y);
        //f.add(l6);
        f.add(label);
        f.add(value);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(r1);
        f.add(r2);
        f.add(t1); f.setSize(300,300);f.setLayout(null);f.setVisible(true);

        
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the window
            }
        });
        f.add(cancel);

/*Action-Listener to the submit button and maintaining backend database JDBC */
         b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                String url = "jdbc:mysql://localhost:3306/OnlineExam";
                String usern="root";
                String pass="Lokeshk@2003";
                String roll_no=text1.getText();
                String username = text.getText();
                String password =value.getText();
                String name = text2.getText();

                System.out.println("Name: " + name);
                System.out.println("Roll_no:"+roll_no);       //output
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                
            Connection connection = DriverManager.getConnection(url,usern,pass);//connection

            String query="insert into student values(?,?,?,?)";                 //query
           PreparedStatement ps=connection.prepareStatement(query);         
            ps.setString(2,name);
            ps.setString(1,roll_no);
            ps.setString(3,username);
            ps.setString(4,password);
            
            //String sql = "CREATE DATABASE " + database;

            Statement statement = connection.createStatement();
            //statement.executeUpdate(sql);
            //statement.executeUpdate(table);
            ps.executeUpdate();
            statement.close();
                }
            catch(Exception l){
                System.out.println(l);
            }
            }
        });

    }}
            