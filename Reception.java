package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JButton newcusto=new JButton("New Customer From");
        newcusto.setBounds(10,30,200,30);
        newcusto.setBackground(Color.BLACK);
        newcusto.setForeground(Color.WHITE);
        newcusto.addActionListener(this);
        add(newcusto);

        JButton rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        JButton department=new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        JButton employees=new JButton("All Employees");
        employees.setBounds(10,150,200,30);
        employees.setBackground(Color.BLACK);
        employees.addActionListener(this); employees.setForeground(Color.WHITE);
        add(employees);

        JButton custoinfo=new JButton("Customer Info");
        custoinfo.setBounds(10,190,200,30);
        custoinfo.setBackground(Color.BLACK);
        custoinfo.setForeground(Color.WHITE);
        custoinfo.addActionListener(this);
        add(custoinfo);


        JButton mageinfo=new JButton("Maneger Info");
        mageinfo.setBounds(10,230,200,30);
        mageinfo.setBackground(Color.BLACK);
        mageinfo.setForeground(Color.WHITE);
        mageinfo.addActionListener(this);
        add(mageinfo);


        JButton checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        JButton updateStatus=new JButton("Update Status");
        updateStatus.setBounds(10,310,200,30);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.addActionListener(this);
        add(updateStatus);

        JButton updateRoomStatus=new JButton("Update Room Status");
        updateRoomStatus.setBounds(10,350,200,30);
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.setForeground(Color.WHITE);
        updateRoomStatus.addActionListener(this);
        add(updateRoomStatus);

        JButton pickupService=new JButton("Pickup Service");
        pickupService.setBounds(10,390,200,30);
        pickupService.setBackground(Color.BLACK);
        pickupService.addActionListener(this);

        pickupService.setForeground(Color.WHITE);
        add(pickupService);

        JButton searchRoom=new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.addActionListener(this);
        searchRoom.setForeground(Color.WHITE);
        add(searchRoom);

        JButton logout=new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.addActionListener(this);
        logout.setForeground(Color.WHITE);
        add(logout);

        setTitle("Reception");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(150,30,690,450);
        add(image);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

        setBounds(350,200,800,570);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        if (e.getActionCommand().equals("New Customer From")){
            new AddCustomer();
        } else if (e.getActionCommand().equals("Rooms")) {
            new Allrooms();
        } else if (e.getActionCommand().equals("Department")) {
            new Department();
        } else if (e.getActionCommand().equals("All Employees")) {
            new EmployeeInfo();
        }
          else if (e.getActionCommand().equals("Customer Info"))
          {
            new Customerinfo();
          }
           else if (e.getActionCommand().equals("Maneger Info"))
           {
            new Manegerinfo();
           }
            else if (e.getActionCommand().equals("Checkout"))
            {
           //  new Reception();
            }

    }
}
