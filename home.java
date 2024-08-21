import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class home extends JFrame implements ActionListener{
Container c;
JButton Add,delete,check,leave;
JLabel head,ladd,ldelete,lcheck;

    home(){
     JFrame h=new JFrame();
        h.setBounds(100, 100, 800, 600);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h.setTitle("Home page");
        
        c=h.getContentPane();
        c.setLayout(null);
        //c.setBackground("images.jpeg");

        head=new JLabel("    Home Page ");
        head.setBounds(450,100,500,60);
        c.add(head);
        head.setForeground(Color.white);
       
        Font f=new Font("TIMESNEWROMAN",Font.BOLD,50);
        head.setFont(f);
      //  head.setBackground(Color.red);
       // head.setOpaque(true);

        ladd=new JLabel("Add the new guest");
        ladd.setBounds(120,250,200,30);
        c.add(ladd);
        ladd.setForeground(Color.WHITE);


        Add=new JButton("Add the guest");
        Add.setBounds(80,300,200,30);
        c.add(Add);
        Add.addActionListener(this);
        Add.setForeground(Color.WHITE);
        Add.setBackground(Color.black);

        ldelete=new JLabel("  Check out guest");
        ldelete.setBounds(550,250,200,30);
        c.add(ldelete);
        ldelete.setForeground(Color.WHITE);


        delete=new JButton("Check out");
        delete.setBounds(510,300,200,30);
        c.add(delete);
        delete.addActionListener(this);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.BLACK);

        lcheck=new JLabel("Info guest");
        lcheck.setBounds(980,250,200,30);
        c.add(lcheck);
        lcheck.setForeground(Color.WHITE);
        


        check=new JButton("Info guest");
        check.setBounds(910,300,200,30);
        c.add(check);
        check.addActionListener(this);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);

        leave=new JButton("Guest Leaves");
        leave.setBounds(1100,10,150,30);
        c.add(leave);
        leave.addActionListener(this);
        leave.setForeground(Color.WHITE);
        leave.setBackground(Color.BLACK);

        ImageIcon img=new ImageIcon("add.jpg");
        JLabel image=new JLabel(img);
        image.setBounds(55,370,230,200);
        c.add(image);

        ImageIcon img1=new ImageIcon("checkout.jpg");
        JLabel image1=new JLabel(img1);
        image1.setBounds(480,350,250,250);
        c.add(image1);

        ImageIcon img2=new ImageIcon("check.jpg");
        JLabel image2=new JLabel(img2);
        image2.setBounds(880,350,250,250);
        c.add(image2);

ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("myres2.jpg"));
Image i1=imageicon.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
ImageIcon imageicon1=new ImageIcon(i1);
JLabel lab=new JLabel(imageicon1);
lab.setBounds(0,0,1955,1000);
h.add(lab);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==Add){

            this.dispose();
            add a=new add();
        }
        if(e.getSource()==check){
            this.dispose();
            HotelManagementGUI cg=new HotelManagementGUI();
        }
       if(e.getSource()==delete){
        this.dispose();
        Deleteguest dg=new Deleteguest();
        
       }

       if(e.getSource()==leave){
        this.dispose();
        leaveguest l=new leaveguest();
       }
        

}

    public static void main (String[] args) {
            home h=new home();
            
        }
}
// }