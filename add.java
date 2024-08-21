import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

class add extends JFrame implements ActionListener {

    Container c;
    static JLabel info, name, location, Room_allo, book_id, no_days, room1, room2, person;
    static JTextArea nameb, locationb, room, room1b, room2b;
    static JTextArea booki_idb;
    static JTextArea no_dayb;
    static JTextArea personb;
    static JButton submit, back, allot1, allot2;

    Random rand = new Random();
    int rand_id = rand.nextInt(100, 10000);

    add() {
        JFrame f = new JFrame();
        f.setBounds(100, 100, 800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Add page");

        c = f.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(2, 48, 32));
        

        info = new JLabel("Add the guest details");
        info.setBounds(500, 20, 400, 50);
        c.add(info);
        info.setForeground(Color.white);
        info.setFont(new Font("Times New Roman", Font.ITALIC, 40));

        book_id = new JLabel("Booking id:");
        book_id.setBounds(300, 150, 150, 30);
        c.add(book_id);
        book_id.setForeground(Color.white);

        booki_idb = new JTextArea(Integer.toString(rand_id));
        booki_idb.setBounds(400, 150, 150, 30);
        c.add(booki_idb);
        booki_idb.setBackground(new Color(79, 121, 66));
        booki_idb.setForeground(Color.white);

        name = new JLabel("Name:");
        name.setBounds(300, 230, 150, 30);
        c.add(name);
        name.setForeground(Color.white);

        nameb = new JTextArea();
        nameb.setBounds(400, 230, 150, 30);
        c.add(nameb);
        nameb.setBackground(new Color(79, 121, 66));
        nameb.setForeground(Color.white);

        location = new JLabel("Location:");
        location.setBounds(300, 310, 150, 30);
        c.add(location);
        location.setForeground(Color.white);

        locationb = new JTextArea();
        locationb.setBounds(400, 310, 150, 30);
        c.add(locationb);
        locationb.setBackground(new Color(79, 121, 66));
        locationb.setForeground(Color.white);

        Room_allo = new JLabel("No of Room:");
        Room_allo.setBounds(650, 150, 150, 30);
        c.add(Room_allo);
        Room_allo.setForeground(Color.white);

        no_days = new JLabel("No. of Days:");
        no_days.setBounds(650, 310, 150, 30);
        c.add(no_days);
        no_days.setForeground(Color.white);

        no_dayb = new JTextArea();
        no_dayb.setBounds(750, 310, 150, 30);
        c.add(no_dayb);
        no_dayb.setBackground(new Color(79, 121, 66));
        no_dayb.setForeground(Color.white);

        person = new JLabel("No of person");
        person.setBounds(650, 230, 150, 30);
        c.add(person);
        person.setForeground(Color.white);

        personb = new JTextArea();
        personb.setBounds(750, 230, 150, 30);
        c.add(personb);
        personb.setBackground(new Color(79, 121, 66));
        personb.setForeground(Color.white);

        room1 = new JLabel("Room 1:");
        room1.setBounds(10, 450, 0, 0);
        c.add(room1);
        room1.setEnabled(false);
        room1.setForeground(Color.white);

        room1b = new JTextArea();
        c.add(room1b);
        room1b.setEnabled(false);
        room1b.setBackground(new Color(79, 121, 66));
        room1b.setForeground(Color.white);

        room2 = new JLabel("Room2:");
        room2.setBounds(10, 450, 0, 0);
        c.add(room2);
        room2.setEnabled(false);
        room2.setForeground(Color.white);

        room2b = new JTextArea();

        c.add(room2b);
        room2b.setEnabled(false);
        room2b.setBackground(new Color(79, 121, 66));
        room2b.setForeground(Color.white);

        allot1 = new JButton("Allot 1");
        allot1.setBounds(750, 150, 70, 30);
        c.add(allot1);
        allot1.addActionListener(this);
        allot1.setBackground(Color.black);
        allot1.setForeground(Color.white);

        allot2 = new JButton("Allot 2");
        allot2.setBounds(850, 150, 70, 30);
        c.add(allot2);
        allot2.addActionListener(this);
        allot2.setBackground(Color.black);
        allot2.setForeground(Color.white);

        submit = new JButton("Submit");
        submit.setBounds(600, 550, 100, 30);
        c.add(submit);
        submit.addActionListener(this);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);

        back = new JButton("Home");
        back.setBounds(10, 10, 70, 20);
        c.add(back);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("hotellog.gif"));
        Image i1 = imageicon.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(i1);
        JLabel lab = new JLabel(imageicon1);
        lab.setBounds(980, 130, 300, 250);
        c.add(lab);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            home h = new home();
        }
        if (e.getSource() == allot1) {

            room1.setBounds(450, 450, 100, 30);
            room1b.setBounds(500, 450, 50, 30);
            room1.setEnabled(true);
            room1b.setEnabled(true);
            room2.setEnabled(false);
            room2b.setEnabled(false);
        }

        if (e.getSource() == allot2) {

            room1.setBounds(450, 450, 100, 30);
            room1b.setBounds(500, 450, 50, 30);

            room2.setBounds(600, 450, 100, 30);
            room2b.setBounds(650, 450, 50, 30);

            room1.setEnabled(true);
            room1b.setEnabled(true);
            room2.setEnabled(true);
            room2b.setEnabled(true);

        }

        if (e.getSource() == submit) {
            int a = Integer.parseInt(booki_idb.getText());
            String na = nameb.getText();
            String lo = locationb.getText();
            String nd = no_dayb.getText();
            int r1 = Integer.parseInt(room1b.getText());

            if (room2b.isEnabled()) {

                int r2 = Integer.parseInt(room2b.getText());
            }

            String query = "insert into Guests(booking_id,guest_name,room_id,loaction,no_of_days) values (?,?,?,?,?)";
            String q = "update Rooms set is_occupied=TRUE where room_id=?";
            try {
                Connection con = UserDAO.getConnection();
                PreparedStatement pstmt = con.prepareStatement(query);
                PreparedStatement up = con.prepareStatement(q);

                pstmt.setInt(1, a);
                pstmt.setString(2, na);
                pstmt.setInt(3, r1);
                pstmt.setString(4, lo);
                pstmt.setString(5, nd);
                pstmt.executeUpdate();

                up.setInt(1, r1);
                up.executeUpdate();

                System.out.println("inserted");

            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        add z = new add();
    }
}
