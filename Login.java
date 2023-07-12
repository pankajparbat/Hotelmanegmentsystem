//package Hotel.Managment.System;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//public class Login extends JFrame implements ActionListener {
//    JTextField username;
//    JButton login,cancle;
//    JPasswordField password;
//    Login(){
//        getContentPane().setBackground(Color.white);
//
//        setLayout(null);
//
//
//
//        JLabel user=new JLabel("User name");
//        user.setBounds(40,20,100,30);
//        add(user);
//
//         username=new JTextField();
//        username.setBounds(150,20,150,30);
//        add(username);
//
//        JLabel pass=new JLabel("Password");
//        pass.setBounds(40,70,100,30);
//        add(pass);
//
//      password=new JPasswordField();
//        password.setBounds(150,70,150,30);
//        add(password);
//
//        login=new JButton("Login");
//        login.setBounds(40,150,120,30);
//        login.addActionListener(this);
//        login.setBackground(Color.blue);
//        login.setForeground(Color.white);
//        add(login);
//
//        cancle=new JButton("Cancle");
//        cancle.setBounds(180,150,120,30);
//        cancle.setBackground(Color.blue);
//        cancle.setForeground(Color.white);
//        cancle.addActionListener(this);
//        add(cancle);
//
//        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons\\second.jpg"));
//        Image i2=il.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(350,10,200,200);
//        add(image);
//
//        setTitle("Login");
//        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
//        setIconImage(icon.getImage());
//
//        setBounds(500,200,600,300);
//        setVisible(true);
//
//    }
//
//    public static void main(String[] args) {
//     new form();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//       if (ae.getSource()==login){
//          String user= username.getText();
//          String pass=password.getText();
//
//          try {
//              Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Pankaj@123");
//              PreparedStatement stat=conn.prepareStatement("select * from login where username=? and password=?");
//              stat.setString(1,user);
//              stat.setString(2,pass);
//
//
//              ResultSet rs = stat.executeQuery();
//            if (rs.next()){
//                setVisible(false);
//                new Dashboard();
//                dispose();
//            }else {
//                JOptionPane.showMessageDialog(null,"Invalid username or password");
//                setVisible(false);
//            }
//          }catch (Exception e){
//              e.printStackTrace();
//          }
//       }else if(ae.getSource()==cancle){
//           setVisible(false);
//       }
//
//    }
//}
