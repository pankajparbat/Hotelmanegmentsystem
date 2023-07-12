package Hotel.Managment.System;

import lageimage.Connectionprovider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(500,0,600,600);
//        add(image);
        setTitle("Employee Info");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

        JLabel l1=new JLabel("Namer");
        l1.setBounds(12,10,100,20);
        add(l1);


        JLabel l2=new JLabel("Age");
        l2.setBounds(150,10,100,20);
        add(l2);



        JLabel l4=new JLabel("Gender");
        l4.setBounds(280,10,100,20);
        add(l4);

        JLabel l5=new JLabel("Job");
        l5.setBounds(400,10,100,20);
        add(l5);


        JLabel l6=new JLabel("Salary");
        l6.setBounds(520,10,100,20);
        add(l6);


        JLabel l7=new JLabel("Phone");
        l7.setBounds(620,10,100,20);
        add(l7);


        JLabel l8=new JLabel("Email");
        l8.setBounds(740,10,100,20);
        add(l8);


        JLabel l9=new JLabel("Aadhar");
        l9.setBounds(860,10,100,20);
        add(l9);



        table =new JTable();
        table.setBounds(5,40,970,400);
        add(table);
        try {
            Conn c=new Conn();
            Connection conn= Connectionprovider.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet set=stmt.executeQuery("select * from employee");
            table.setModel((DbUtils.resultSetToTableModel(set)));

        }catch (Exception e){
            e.printStackTrace();
        }

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
        new EmployeeInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
