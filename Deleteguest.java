
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Deleteguest extends JFrame implements ActionListener {
    Container c;
    JLabel name_of_guest, room, head;
 public static  JTextArea name_guest, roomb, details;
    JButton submit, back, show;
    int room_no;

    Deleteguest() {
        JFrame f = new JFrame();
        f.setBounds(100, 100, 800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Check out Page");
        f.setForeground(Color.white);

        c = f.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(128,0,128));

        head = new JLabel("Check out page");
        head.setBounds(500, 20, 400, 50);
        c.add(head);
        head.setFont(new Font("Times New Roman", Font.ITALIC, 50));
        head.setForeground(Color.white);

        room = new JLabel("Booking Id:");
        room.setBounds(450, 480, 200, 30);
        c.add(room);
        room.setForeground(Color.white);

        roomb = new JTextArea();
        roomb.setBounds(550, 480, 200, 30);
        c.add(roomb);
        roomb.setBackground(new Color(195,181,223));
        roomb.setForeground(Color.black);
       
        name_of_guest = new JLabel("Name :");
        name_of_guest.setBounds(450, 150, 200, 30);
        c.add(name_of_guest);
        name_of_guest.setForeground(Color.white);

        name_guest = new JTextArea();
        name_guest.setBounds(550, 150, 200, 30);
        c.add(name_guest);
        name_guest.setBackground(new Color(195,181,225));
        name_guest.setForeground(Color.black);

        show = new JButton("Show details");
        show.setBounds(550, 230, 100, 30);
        c.add(show,BorderLayout.SOUTH);
        show.addActionListener(this);
        show.setBackground(Color.black);
        show.setForeground(Color.white);

        submit = new JButton("Submit");
        submit.setBounds(550, 620, 100, 30);
        c.add(submit);
        submit.addActionListener(this);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);

        details = new JTextArea();
     
        c.add(details);
        details.setFont(new Font("Arial", Font.BOLD, 15));
        details.setBackground(Color.MAGENTA);
        details.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        details.setBackground(new Color(195,181,225));
        details.setForeground(Color.black);


        back = new JButton("Home");
        back.setBounds(10, 10, 70, 20);
        c.add(back);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("checklog.png"));
        Image i1 = imageicon.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(i1);
        JLabel lab = new JLabel(imageicon1);
        lab.setBounds(980, 130, 300, 250);
        c.add(lab);

        
    }
    
    private void displayGuests() throws SQLException {
        List<Guest> guests = guestch.getDetails();
        StringBuilder sb = new StringBuilder();
        for (Guest guest : guests) {
            sb.append(guest.toString()).append("\n");
        }
        details.setText(sb.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            
            int a = Integer.parseInt(roomb.getText());
            String n = name_guest.getText();
            try {
                Connection con = UserDAO.getConnection();
                String l1="select *from Guests where booking_id=?";
                String l2="insert into leaveguests (booking_id,guest_name,room_no,location) values (?,?,?,?)";
                String q = "delete from Guests where booking_id=?";
                String q1 = "update Rooms set is_occupied=FALSE where room_id=?";
                PreparedStatement pstmt = con.prepareStatement(q);
                PreparedStatement up = con.prepareStatement(q1);
                PreparedStatement l1pst=con.prepareStatement(l1);
                PreparedStatement l2pst=con.prepareStatement(l2);

               l1pst.setInt(1, a);
               ResultSet rs=l1pst.executeQuery();
               if(rs.next()){
               int  booking_id=rs.getInt("booking_id");
                String guest_name=rs.getString("guest_name");
                int room_no1=rs.getInt("room_id");
                String location=rs.getString("loaction");
                
              
               
               l2pst.setInt(1, booking_id);
               l2pst.setString(2, guest_name);
               l2pst.setInt(3, room_no1);
               l2pst.setString(4, location);
               l2pst.executeUpdate();



                pstmt.setInt(1, a);
                pstmt.executeUpdate();

                up.setInt(1, room_no1);
                up.executeUpdate();
                System.out.println("deleted");
               }

            } catch (Exception x) {
                x.printStackTrace();
            }

        }

        if (e.getSource() == back) {
            this.dispose();
            home a = new home();
        }

        if (e.getSource() == show) {
            details.setBounds(250,300,800,100);
            try {
                displayGuests();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
 
            }

        

        
        
        
        public static void main(String[] args) {
            Deleteguest x = new Deleteguest();
            
        }
    }


    class guestch{
        public static List<Guest> getDetails() throws SQLException {
            List<Guest> g = new ArrayList<>();
            String n = Deleteguest.name_guest.getText();
            String q = "select * from Guests where guest_name=?";
            try {
                Connection con = UserDAO.getConnection();
              
                PreparedStatement pst = con.prepareStatement(q);

                pst.setString(1, n);
                ResultSet set = pst.executeQuery();
                System.out.println("executed");

                while(set.next()) {
                    int id = set.getInt(1);
                    String name = set.getString(2);
                   int  roomn = set.getInt(3);
                    String l = set.getString(4);
                    int days = set.getInt(5);

                    Guest guests = new Guest(id, name, roomn, l, days);
                    g.add(guests);
                    System.out.println("guests"+guests);
                } 
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(g.size());
            return g;
}
    }