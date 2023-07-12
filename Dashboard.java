package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JMenuItem addemploye,addrooms,adddrivers,reception;
    Dashboard(){
        setBounds(0,0,1550,1000);

        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons\\third.jpg"));
        Image i2=il.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text =new JLabel("PARBAT GROUPS WELCOME TO ALL");
        text.setBounds(400,80,1000,100);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.white);
        image.add(text);


        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);

       reception=new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);


        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);//springboots

        addemploye=new JMenuItem("ADD EMPLOYEE");
        addemploye.addActionListener(this);
        admin.add(addemploye);

       addrooms=new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

      adddrivers=new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);
    }

    public static void main(String[] args) {

        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//setVisible(false);
       if (e.getActionCommand().equals("ADD EMPLOYEE")){
           new AddEmployee();
       } else if (e.getActionCommand().equals("ADD ROOMS")) {
           new AddRooms();
       } else if (e.getActionCommand().equals("ADD DRIVERS")) {
           new AddDriver();
       } else if (e.getActionCommand().equals("Reception")) {
           new Reception();
       }

    }

}
