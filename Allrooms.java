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

public class Allrooms extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Allrooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        setTitle("Rooms");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

        JLabel l1=new JLabel("Room Nember");
        l1.setBounds(10,10,100,20);
        add(l1);


        JLabel l2=new JLabel("Statues");
        l2.setBounds(100,10,100,20);
        add(l2);


        JLabel l3=new JLabel("Cleanness");
        l3.setBounds(200,10,100,20);
        add(l3);


        JLabel l4=new JLabel("Availablity");
        l4.setBounds(300,10,100,20);
        add(l4);

        JLabel l5=new JLabel("Price");
        l5.setBounds(400,10,100,20);
        add(l5);

        table =new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        try {
            Conn c=new Conn();
            Connection conn= Connectionprovider.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet set=stmt.executeQuery("select * from addroom");
            table.setModel((DbUtils.resultSetToTableModel(set)));

        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);

       setResizable(false);
        setBounds(300,200,1050,600);
    setVisible(true);
    }

    public static void main(String[] args) {
new Allrooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
