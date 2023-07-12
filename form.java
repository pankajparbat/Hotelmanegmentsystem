package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form extends JFrame implements ActionListener {
    JTextField username;
        JButton login,cancle;
    JPasswordField password;

    form(){
        getContentPane().setBackground(Color.white);

        setLayout(null);

        JLabel user=new JLabel("User name");
        user.setBounds(40,20,100,30);
        add(user);

        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        password=new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);

        login=new JButton("Login");
        login.setBounds(40,150,120,30);
        login.addActionListener(this);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        add(login);

        cancle=new JButton("Cancle");
        cancle.setBounds(180,150,120,30);
        cancle.setBackground(Color.blue);
        cancle.setForeground(Color.white);
        cancle.addActionListener(this);
        add(cancle);

        setTitle("Login");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

setResizable(false);
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons\\second.jpg"));
        Image i2=il.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        setBounds(500,200,600,300);
        setVisible(true);

    }

    public static void main(String[] args) {
        new form();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Pankaj@123");
            PreparedStatement stat=conn.prepareStatement("select * from hotel where username=? and password=?");

            stat.setString(1,username.getText());
            stat.setString(2,password.getText());
            ResultSet r=stat.executeQuery();
            if (r.next()){
                new Dashboard();
                setVisible(true);
                JOptionPane.showMessageDialog(rootPane,"welcome "+username.getText()+" to hotel");
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);

            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Invalid user name and password");
        }

    }
}
