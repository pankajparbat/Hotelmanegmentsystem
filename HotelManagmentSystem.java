// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in you
package Hotel.Managment.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HotelManagmentSystem extends JFrame implements ActionListener {
    HotelManagmentSystem(){
         // setSize(1366,565);
        // setLocation(100,100);

        setBounds(100,100,1366,565);
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons\\first.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text=new JLabel();
        text.setText("HOTEL MANAGEMENT SYSTEM");
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.PLAIN,50));
        text.setBounds(20,430,1000,100);
        image.add(text);

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo2.png"));
        setIconImage(icon.getImage());

        JButton next=new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.magenta);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,24));
        add(next);

        setVisible(true);
        while (true)
        {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new form();

    }

    public static void main(String[] args) {

        new HotelManagmentSystem();


    }


}