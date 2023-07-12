package Hotel.Managment.System;
import lageimage.Connectionprovider;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField txtnumber, txtname, txtcountry,txtdeposit, checkinTime;
    Calendar calendar;
    SimpleDateFormat timeFormat;
    JComboBox<String>  comboid;
    JRadioButton rbmale, rbfemal;
    Choice croom;



  //  JLabel checkinTime;




  AddCustomer(){
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);

          JLabel heading =new JLabel("NEW CUSTOMER FROM");
          heading.setForeground(Color.BLUE);
          heading.setFont(new Font("Tahoma",Font.PLAIN,20));
          heading.setBounds(100,20,300,30);
          add(heading);

          JLabel lblid =new JLabel("ID");
          lblid.setFont(new Font("Tahoma",Font.BOLD,14));
          lblid.setBounds(35,80,100,20);
          add(lblid);

      String availableOptions[]={"Aadhar Card","Passsport","Driving License","Voter-id Card","Ration Card"};
      comboid=new JComboBox<>(availableOptions);
      comboid.setBounds(200,80,150,25);
      comboid.setBackground(Color.WHITE);
      add(comboid);


      JLabel lblnumber =new JLabel("Number");
      lblnumber.setFont(new Font("Tahoma",Font.BOLD,14));
      lblnumber.setBounds(35,120,150,25);
      add(lblnumber);

      txtnumber = new JTextField();
      txtnumber.setFont(new Font("Tahoma",Font.BOLD,14));
      txtnumber.setBounds(200,120,150,25);
      add(txtnumber);

          JLabel lblname =new JLabel("Name");
          lblname.setFont(new Font("Tahoma",Font.BOLD,14));
          lblname.setBounds(35,160,150,25);
          add(lblname);

          txtname = new JTextField();
          txtname.setFont(new Font("Tahoma",Font.BOLD,14));
          txtname.setBounds(200,160,120,25);
          add(txtname);

      JLabel ibigender=new JLabel("Gender");
      ibigender.setBounds(35,200,120,25);
      ibigender.setFont(new Font("Tahoma", Font.BOLD,14));
      add(ibigender);

      rbmale=new JRadioButton("Male");
      rbmale.setBounds(200,200,60,25);
      rbmale.setFont(new Font("Tahoma", Font.PLAIN,14));
      rbmale.setBackground(Color.WHITE);
      add(rbmale);

      rbfemal=new JRadioButton("Femal");
      rbfemal.setBounds(280,200,90,25);
      rbfemal.setFont(new Font("Tahoma", Font.PLAIN,14));
      rbfemal.setBackground(Color.WHITE);
      add(rbfemal);
      ButtonGroup bg=new ButtonGroup();
      bg.add(rbfemal);
      bg.add(rbmale);
      setTitle("Customer");


          JLabel ibicountry=new JLabel("Country");
          ibicountry.setBounds(35,240,150,30);
          ibicountry.setFont(new Font("Tahoma",Font.BOLD,14));
          add(ibicountry);
      ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
      setIconImage(icon.getImage());
          txtcountry = new JTextField();
          txtcountry.setFont(new Font("Tahoma",Font.BOLD,14));
          txtcountry.setBounds(200,240,150,25);
          add(txtcountry);


          JLabel lblavsill =new JLabel("Room Number");
          lblavsill.setFont(new Font("Tahoma",Font.BOLD,14));
          lblavsill.setBounds(35,280,150,20);
          add(lblavsill);

          croom=new Choice();
          try {
              Connection conn= Connectionprovider.getConnection();
              String query="select * from addroom where Available ='Available'";


              Statement stmt=conn.createStatement();
              ResultSet set=stmt.executeQuery(query);
              while (set.next()){
                  croom.add(set.getString("Room_No"));
              }
          }catch (Exception e){
              e.printStackTrace();
          }
          croom.setBounds(200,280,150,25);

          add(croom);

      JLabel ibitime =new JLabel("Checkin Time");
      ibitime.setFont(new Font("Tahoma",Font.BOLD,14));
      ibitime.setBounds(35,320,150,20);
      add(ibitime);

      Calendar calendar = Calendar.getInstance();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      String currentDate = dateFormat.format(calendar.getTime());
     checkinTime = new JTextField(currentDate);
      checkinTime.setFont(new Font("Tahoma",Font.BOLD,14));
      checkinTime.setBounds(200, 320, 200, 20);
      add(checkinTime);
//      time t=new time();
// //Date date=new Date();
//     JLabel label = new JLabel(String.valueOf(t.timetamp()));
//     add(label);

//      label.setText(anotherClass.getLabelText());


      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
      Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(380,60,450,370);
      add(image);

      JLabel ibideposit=new JLabel("Deposit");
      ibideposit.setBounds(35,360,150,30);
      ibideposit.setFont(new Font("Tahoma",Font.BOLD,14));
      add(ibideposit);

      txtdeposit = new JTextField();
      txtdeposit.setFont(new Font("Tahoma",Font.BOLD,14));
      txtdeposit.setBounds(200,360,150,25);
      add(txtdeposit);

      JButton addcustomer=new JButton("Add ");
      addcustomer.setFont(new Font("Tahoma",Font.BOLD,14));
      addcustomer.setBackground(Color.black);
      addcustomer.setForeground(Color.white);
      addcustomer.setBounds(70,420,100,20);
      addcustomer.addActionListener(this);
      add(addcustomer);

      JButton canclecusto=new JButton("Back");
      canclecusto.setFont(new Font("Tahoma",Font.BOLD,14));
      canclecusto.setBackground(Color.black);
      canclecusto.setForeground(Color.white);
      canclecusto.setBounds(230,420,100,20);
      canclecusto.addActionListener(this);
      add(canclecusto);


      setBounds(350,200,800,550);
      setVisible(true);

}

    public static void main(String[] args) {
        new AddCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
        if (e.getActionCommand().equals("Back")){
            new Reception();
        } else if (e.getActionCommand().equals("Add")) {


            String id=(String) comboid.getSelectedItem();
            String number= txtnumber.getText();
            String name= txtname.getText();
            String gender=null;
            if (rbmale.isSelected()){
                gender="Male";
            }
            else if (rbfemal.isSelected()){
                gender="Femal";
            }
            String country= txtcountry.getText();
            String roomno= croom.getSelectedItem();
            String time= checkinTime.getText();
            String deposit= txtdeposit.getText();


try {


            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Pankaj@123");
            PreparedStatement stat=conn.prepareStatement("insert into addcustomer (document,number,name,gender,country,room,checkintime,deposit) values(?,?,?,?,?,?,?,?)");
            PreparedStatement stat2 = conn.prepareStatement("update addroom set Available = 'Occupied' where Room_NO = ?");
            stat2.setString(1, roomno);

            stat.setString(1,id);
            stat.setString(2,number);
            stat.setString(3,name);
            stat.setString(4,gender);
            stat.setString(5,country);
            stat.setString(6,roomno);
            stat.setString(7,time);
            stat.setString(8,deposit);
    JOptionPane.showMessageDialog(null,"New costomer  added successfully");
            stat.executeUpdate();
           stat2.executeUpdate();

            conn.close();

            new Reception();
}
catch (Exception ew)
{

    JOptionPane.showMessageDialog(null,ew);
    //this aboue

}
        }
    }
}
