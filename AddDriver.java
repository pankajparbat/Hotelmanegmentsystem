package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddDriver extends JFrame implements ActionListener {
    JTextField txtname,txtage,txtcar,txtcarname,txtlocation;
    JComboBox gendercombo,availlcombo;
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Add A Driver");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

        JLabel heading =new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblname =new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(60,60,200,20);
        add(lblname);

        txtname = new JTextField();
        txtname.setFont(new Font("Tahoma",Font.BOLD,14));
        txtname.setBounds(190,60,120,20);
        add(txtname);

        JLabel lblage =new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.BOLD,14));
        lblage.setBounds(60,110,200,20);
        add(lblage);

        txtage = new JTextField();
        txtage.setFont(new Font("Tahoma",Font.BOLD,14));
        txtage.setBounds(190,110,120,20);
        add(txtage);


        JLabel ibigender=new JLabel("GENDER");
        ibigender.setBounds(60,160,120,30);
        ibigender.setFont(new Font("Tahoma",Font.BOLD,14));
        add(ibigender);


        String genderOptions[]={"Male","Femal"};
        gendercombo=new JComboBox<>(genderOptions);
        gendercombo.setBounds(190,160,120,20);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel ibicarname=new JLabel("Car Company");
        ibicarname.setBounds(60,210,120,30);
        ibicarname.setFont(new Font("Tahoma",Font.BOLD,14));
        add(ibicarname);

        txtcarname = new JTextField();
        txtcarname.setFont(new Font("Tahoma",Font.BOLD,12));
        txtcarname.setBounds(190,210,120,20);
        add(txtcarname);


        JLabel ibimodel=new JLabel("Car Model");
        ibimodel.setBounds(60,260,120,30);
        ibimodel.setFont(new Font("Tahoma",Font.BOLD,14));
        add(ibimodel);

        txtcar = new JTextField();
        txtcar.setFont(new Font("Tahoma",Font.BOLD,12));
        txtcar.setBounds(190,260,120,20);
        add(txtcar);


        JLabel lblavsill =new JLabel("Availlable");
        lblavsill.setFont(new Font("Tahoma",Font.BOLD,14));
        lblavsill.setBounds(60,310,200,20);
        add(lblavsill);

        String availlOptions[]={"Availlable","Not Availlable"};
        availlcombo=new JComboBox<>(availlOptions);
        availlcombo.setBounds(190,310,120,20);
        availlcombo.setBackground(Color.WHITE);
        add(availlcombo);


        JLabel lbllocation =new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.BOLD,14));
        lbllocation.setBounds(60,360,200,20);
        add(lbllocation);

        txtlocation = new JTextField();
        txtlocation.setFont(new Font("Tahoma",Font.BOLD,14));
        txtlocation.setBounds(190,360,120,20);
        add(txtlocation);

        JButton addroom=new JButton("Add");
        addroom.setFont(new Font("Tahoma",Font.BOLD,14));
        addroom.setBounds(70,410,100,20);
        addroom.addActionListener(this);
        add(addroom);

        JButton cancleroom=new JButton("Cancel");
        cancleroom.setFont(new Font("Tahoma",Font.BOLD,14));
        cancleroom.setBounds(190,410,100,20);
        add(cancleroom);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image originalImage = i1.getImage();
        Image scaledImage = originalImage.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(scaledImage);
        JLabel image = new JLabel(i2);
        image.setBounds(400, 30, 500, 400);
        add(image);


        setBounds(300,200,940,500);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddDriver();
    }


    public void actionPerformed(ActionEvent e) {

        String name=txtname.getText();
        String age=txtage.getText();
        String carname=txtcarname.getText();
        String carmodel=txtcar.getText();
        String location=txtlocation.getText();
      //  String carmodel=txtcar.getText();

//
//
//        String gender=null;
//        if (rbmale.isSelected()){
//            gender="Male";
//        }
//        else if (rbfemal.isSelected()){
//            gender="Femal";
//        }
        String gender=(String) gendercombo.getSelectedItem();
        String availab=(String) availlcombo.getSelectedItem();
      //  String bed=(String) bedcombo.getSelectedItem();
        try {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Pankaj@123");
            PreparedStatement stat=conn.prepareStatement("insert into adddriver (Name,Age,Carname,Carmodel,Gender,Available,Location) values(?,?,?,?,?,?,?)");
            stat.setString(1,name);
            stat.setString(2,age);
            stat.setString(3,carname);
            stat.setString(4,carmodel);
            stat.setString(5,gender);
            stat.setString(6,availab);
            stat.setString(7,location);
//            stat.setString(6,phone);
//            stat.setString(7,email);
//            stat.setString(8,aadhar);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Driver add successfully");
            conn.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

