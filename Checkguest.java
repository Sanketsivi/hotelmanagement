import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkguest extends JFrame implements ActionListener{
    Container c;
    JLabel name_of_guest,name,head,details;
    JTextArea name_guest,detailsb;
    JButton submit,back;


    Checkguest(){
        JFrame f=new JFrame();
        f.setBounds(100,100,800,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Check Guest Page");

        c=f.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(2, 48, 32));
        
       head=new JLabel("Information of guest");
       head.setBounds(450,20, 500, 60);
       c.add(head);
       head.setFont(new Font("Times New Roman",Font.BOLD,50));
       head.setForeground(Color.white);


        name_of_guest=new JLabel("Name you are looking for");
        name_of_guest.setBounds(450,200,200,30);
        c.add(name_of_guest);
        name_of_guest.setForeground(Color.white);

        name_guest=new JTextArea();
        name_guest.setBounds(650,200,200,30);
        c.add(name_guest);
        name_guest.setBackground(new Color(79, 121, 66));
        name_guest.setForeground(Color.white);

        submit=new JButton("Submit");
        submit.setBounds(600,300,100,30);
        c.add(submit);
        submit.addActionListener(this);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
   
        details=new JLabel("Details");
        details.setBounds(630,450,0,0);
        c.add(details);
        details.setFont(new Font("Arial",Font.BOLD,15));
        details.setForeground(Color.white);


       detailsb=new JTextArea();
       detailsb.setBounds(450, 500, 0, 0);
       c.add(detailsb);
       detailsb.setBackground(new Color(79, 121, 66));
       detailsb.setForeground(Color.white);

       back=new JButton("Home");
       back.setBounds(10,10,70,20);
       c.add(back);
       back.addActionListener(this);
       back.setForeground(Color.white);
       back.setBackground(Color.black);
       
    }


     @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==submit){
        details.setBounds(630,450,100,30);
        detailsb.setBounds(450, 500, 400, 200);
        detailsb.setText("Details come from database");
      }
      if(e.getSource()==back){
        this.dispose();
        home h=new home();
      }
    }

    public static void main(String[] args) {
        Checkguest x=new Checkguest();

    }
}
