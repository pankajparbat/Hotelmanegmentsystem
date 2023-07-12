package Hotel.Managment.System;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddEmployee extends JFrame implements ActionListener {
   JTextField tfname,TAGE,tfsalary,tfphone,tfemail,tfadhar ;
   JRadioButton rbmale,rbfemal;
   JComboBox cbjob;

    AddEmployee(){
        setLayout(null);






        JLabel ibiname=new JLabel("NAME");
        ibiname.setBounds(60,30,120,30);
        ibiname.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(ibiname);

       tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);


        JLabel AGE=new JLabel("AGE");
        AGE.setBounds(60,80,120,30);
       AGE.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(AGE);

       TAGE=new JTextField();
        TAGE.setBounds(200,80,150,30);
        add(TAGE);

        JLabel ibigender=new JLabel("GENDER");
        ibigender.setBounds(60,130,120,30);
        ibigender.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(ibigender);

         rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN,17));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

         rbfemal=new JRadioButton("Femal");
        rbfemal.setBounds(280,130,70,30);
        rbfemal.setFont(new Font("Tahoma", Font.PLAIN,17));
        rbfemal.setBackground(Color.WHITE);
        add(rbfemal);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbfemal);
        bg.add(rbmale);

        JLabel ibijob=new JLabel("JOB");
        ibijob.setBounds(60,180,120,30);
        ibijob.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(ibijob);

        String str[]={"Front Desk Clerks","Porters","House kiping","kitchen staff","Room Services","cheif",
                "Waiter/Waitress","Manager","Accountent"};
         cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel ibsalary=new JLabel("SALARY");
        ibsalary.setBounds(60,230,120,30);
        ibsalary.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(ibsalary);

         tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);


        JLabel ibiphone=new JLabel("Phone");
        ibiphone.setBounds(60,280,120,30);
        ibiphone.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(ibiphone);

    tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);


        JLabel ibiemail=new JLabel("Email");
        ibiemail.setBounds(60,330,120,30);
        ibiemail.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(ibiemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        JLabel ibiadhar=new JLabel("ADHAR");
        ibiadhar.setBounds(60,380,120,30);
        ibiadhar.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(ibiadhar);
        setResizable(false);
        setTitle("Add Employes in Form");
        tfadhar=new JTextField();
        tfadhar.setBounds(200,380,150,30);
        add(tfadhar);

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());
        JButton submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);


//        JButton cancel=new JButton("Cancel");
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.setBounds(350,430,150,30);
//        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setBounds(330,200,940,600);
        setVisible(true);
    }

    public static void main(String[] args) {
      new AddEmployee();
    }

 @Override
 public void actionPerformed(ActionEvent e) {

     String name=tfname.getText();
     String age=TAGE.getText();
     String salary=tfsalary.getText();
     String phone=tfphone.getText();
     String email=tfemail.getText();
     String aadhar=tfadhar.getText();

     String gender=null;
     if (rbmale.isSelected()){
         gender="Male";
     }
     else if (rbfemal.isSelected()){
         gender="Femal";
     }
     String job=(String) cbjob.getSelectedItem();

     try {
         Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Pankaj@123");
         PreparedStatement stat=conn.prepareStatement("insert into employee (name,age,gender,job,salary,phone,email,aadhar) values(?,?,?,?,?,?,?,?)");
         stat.setString(1,name);
         stat.setString(2,age);
         stat.setString(3,gender);
         stat.setString(4,job);
         stat.setString(5,salary);
         stat.setString(6,phone);
         stat.setString(7,email);
         stat.setString(8,aadhar);
         stat.executeUpdate();
         JOptionPane.showMessageDialog(null,"Employee add successfully");
         conn.close();

     }
     catch (Exception ex){
         ex.printStackTrace();
     }

 }
}
