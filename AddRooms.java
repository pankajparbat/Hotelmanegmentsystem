package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddRooms extends JFrame implements ActionListener {
    JTextField txtroom,txtroomprice;
    JComboBox availablecombo,cleancombo,bedcombo;
     AddRooms(){
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

         JLabel heading =new JLabel("Add Rooms");
         heading.setFont(new Font("Tahoma",Font.BOLD,18));
         heading.setBounds(150,20,200,20);
         add(heading);

         JLabel lblroomno =new JLabel("Room No");
         lblroomno.setFont(new Font("Tahoma",Font.BOLD,14));
         lblroomno.setBounds(60,60,200,20);
         add(lblroomno);

          txtroom = new JTextField();
         txtroom.setFont(new Font("Tahoma",Font.BOLD,12));
         txtroom.setBounds(190,60,120,20);
         add(txtroom);

         JLabel lblavailable =new JLabel("Avaliable");
         lblavailable.setFont(new Font("Tahoma",Font.BOLD,14));
         lblavailable.setBounds(60,110,200,20);
         add(lblavailable);

         String availableOptions[]={"Available","Occupied"};
          availablecombo=new JComboBox<>(availableOptions);
         availablecombo.setBounds(190,110,120,20);
         availablecombo.setBackground(Color.WHITE);
         add(availablecombo);


         JLabel lblclean =new JLabel("Cleaning status");
         lblclean.setFont(new Font("Tahoma",Font.BOLD,14));
         lblclean.setBounds(60,160,200,20);
         add(lblclean);

         String cleaningOptions[]={"Clean","Dearty"};
          cleancombo=new JComboBox<>(cleaningOptions);
         cleancombo.setBounds(190,160,120,20);
         cleancombo.setBackground(Color.WHITE);
         add(cleancombo);


         JLabel lblprice =new JLabel("Price");
         lblprice.setFont(new Font("Tahoma",Font.BOLD,14));
         lblprice.setBounds(60,210,200,20);
         add(lblprice);

        txtroomprice = new JTextField();
         txtroomprice.setFont(new Font("Tahoma",Font.BOLD,12));
         txtroomprice.setBounds(190,210,120,20);
         add(txtroomprice);


         JLabel lblbed=new JLabel("Bed Type.");
         lblbed.setFont(new Font("Tahoma",Font.BOLD,14));
         lblbed.setBounds(60,260,200,20);
         add(lblbed);

         String bedOptions[]={"singl bed","bouble bed"};
         bedcombo=new JComboBox<>(bedOptions);
         bedcombo.setBounds(190,260,120,20);
         bedcombo.setBackground(Color.WHITE);
         add(bedcombo);
         setTitle("Add Room in Form");
         JButton addroom=new JButton("Add");
         addroom.setFont(new Font("Tahoma",Font.BOLD,14));
         addroom.setBounds(70,310,100,20);
         addroom.addActionListener(this);
         add(addroom);
         setResizable(false);
         ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
         setIconImage(icon.getImage());

         JButton cancleroom=new JButton("Cancel");
         cancleroom.setFont(new Font("Tahoma",Font.BOLD,14));
         cancleroom.setBounds(190,310,100,20);
         add(cancleroom);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
//         Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
//         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i1);
         image.setBounds(380,40,500,370);
         add(image);


         setBounds(330,200,940,470);
         setVisible(true);

    }

    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String room=txtroom.getText();
        String priceofroom=txtroomprice.getText();
//
//
//        String gender=null;
//        if (rbmale.isSelected()){
//            gender="Male";
//        }
//        else if (rbfemal.isSelected()){
//            gender="Femal";
//        }
        String availab=(String) availablecombo.getSelectedItem();
        String clean=(String) cleancombo.getSelectedItem();
        String bed=(String) bedcombo.getSelectedItem();
        try {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Pankaj@123");
            PreparedStatement stat=conn.prepareStatement("insert into addroom (Room_No,Bed_Type,Clean,Available,Price_Room) values(?,?,?,?,?)");
            stat.setString(1,room);
            stat.setString(2,bed);
            stat.setString(3,clean);
            stat.setString(4,availab);
            stat.setString(5,priceofroom);
//            stat.setString(6,phone);
//            stat.setString(7,email);
//            stat.setString(8,aadhar);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Room add successfully");
            conn.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
}}
