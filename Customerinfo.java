package Hotel.Managment.System;

import lageimage.Connectionprovider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;


    public void  custo(){
        try {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Pankaj@123");

            PreparedStatement stat=conn.prepareStatement("select * from addcustomer");
            ResultSet rs = stat.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (SQLException sq){
            JOptionPane.showMessageDialog(rootPane,sq);
        }}

    Customerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(500,0,600,600);
//        add(image);
        setTitle("Customer Information");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

        JLabel l1=new JLabel("ID");
        l1.setBounds(12,10,100,20);
        add(l1);


        JLabel l2=new JLabel("Number");
        l2.setBounds(150,10,100,20);
        add(l2);



        JLabel l4=new JLabel("Name");
        l4.setBounds(280,10,100,20);
        add(l4);

        JLabel l5=new JLabel("Gender");
        l5.setBounds(400,10,100,20);
        add(l5);


        JLabel l6=new JLabel("Country");
        l6.setBounds(520,10,100,20);
        add(l6);


        JLabel l7=new JLabel("Room No");
        l7.setBounds(650,10,100,20);
        add(l7);


        JLabel l8=new JLabel("CheckInTime");
        l8.setBounds(760,10,100,20);
        add(l8);


        JLabel l9=new JLabel("Deposite");
        l9.setBounds(860,10,100,20);
        add(l9);



        table =new JTable();
        table.setBounds(5,40,970,400);
        add(table);
       custo();

        back=new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);

//        setResizable(false);
        setBounds(300,200,1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Customerinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
