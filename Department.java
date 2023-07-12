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

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setTitle("Department and Budget");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

        JLabel l1=new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);


        JLabel l2=new JLabel("Budget");
        l2.setBounds(450,10,100,20);
        add(l2);



        table =new JTable();
        table.setBounds(5,50,700,350);
        add(table);
        try {
            Conn c=new Conn();
            Connection conn= Connectionprovider.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet set=stmt.executeQuery("select * from department");
            table.setModel((DbUtils.resultSetToTableModel(set)));

        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setBounds(280,450,120,30);
        add(back);

        setResizable(false);
        setBounds(300,200,730,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
