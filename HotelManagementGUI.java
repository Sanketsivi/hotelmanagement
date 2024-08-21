import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Roommanagement {
    public static List<Guest> getallDetails() throws SQLException {

        String query = "select booking_id,guest_name,room_id,loaction,no_of_days from Guests";
        List<Guest> guestlist = new ArrayList<>();
        try {
            Connection con = UserDAO.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("booking_id");
                String guest_name = rs.getString("guest_name");
                int room_no = rs.getInt("room_id");
                String locate =rs.getString("loaction");
                int days=rs.getInt("no_of_days");

                Guest guest = new Guest(bookingId, guest_name, room_no,locate,days);
                guestlist.add(guest);
                System.out.println("retrieved guest"+guest);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("totalguest retrieved "+guestlist.size());
        return guestlist;
    }
}

class Guest {
    private int book_id, room_id,days;
    private String guestname,locate;

    public Guest(int book_id, String guestname, int roomid,String locate,int days) {
        this.book_id = book_id;
        this.guestname = guestname;
        this.room_id = roomid;
        this.locate=locate;
        this.days=days;
    }

    public String toString() {
        return "Guest ID:  " + book_id + "         Guest NAME:" + guestname + "       Room NO:" + room_id
        +"       Location:"+locate+"       Days:"+days;

    }
}

public class HotelManagementGUI extends JFrame {
   

    private JTextArea textArea;

    public HotelManagementGUI() {
        

        setTitle("Hotel Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
      


        textArea = new JTextArea();
        textArea.setForeground(Color.blue);
        
        
        textArea.setEditable(false);
        
      
        JScrollPane scrollPane = new JScrollPane(textArea);
       
       
      
        

        JButton showGuestsButton = new JButton("Show All Guests");
        showGuestsButton.setBackground(Color.black);
        showGuestsButton.setForeground(Color.white);

         ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("logo1.jpeg"));
        Image i1 = imageicon.getImage().getScaledInstance(700, 550, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(i1);
        JLabel lab = new JLabel(imageicon1);
        lab.setBounds(300, 200, 700, 500);
        add(lab);
        
        

       
        showGuestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    displayAllGuests();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(showGuestsButton, BorderLayout.SOUTH);
       
    }

    private void displayAllGuests() throws SQLException {
        List<Guest> guests = Roommanagement.getallDetails();
        StringBuilder sb = new StringBuilder();
        for (Guest guest : guests) {
            sb.append(guest.toString()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelManagementGUI().setVisible(true);
            }
        });
    }
}



