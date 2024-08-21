import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class leaveguest implements ActionListener{
    Container c;
    JButton showDetails;
    JLabel book,name,room,locate,nday,timest;
    JTextArea det;
    public leaveguest(){
        JFrame f=new JFrame();
        f.setBounds(100,100,700,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Information of Checkout Guest");

        c=f.getContentPane();
        c.setLayout(null);

        showDetails=new JButton("Show Details");
        showDetails.setBounds(0,720,1400,25);
        c.add(showDetails);
        showDetails.setBackground(Color.BLACK);
        showDetails.setForeground(Color.white);
        showDetails.addActionListener(this);

        det=new JTextArea();
        det.setBounds(50,100,1200,500);
        c.add(det);
        det.setBackground(Color.GRAY);
        det.setForeground(Color.GREEN);
  
        book=new JLabel("Booking_Id");
        book.setBounds(50,50,100,20);
        c.add(book);
        


        name=new JLabel("Name");
        name.setBounds(200,50,100,20);
        c.add(name);

        room=new JLabel("Room No");
        room.setBounds(350,50,100,20);
        c.add(room);

        locate=new JLabel("Location");
        locate.setBounds(500,50,100,20);
        c.add(locate);

        nday=new JLabel("No of stay Days");
        nday.setBounds(650,50,100,20);
        c.add(nday);

        timest=new JLabel("Checkout Time");
        timest.setBounds(800,50,100,20);
        c.add(timest);



    

        
        
        
    }
    
    private void displayGuests() throws SQLException {
        List<Guestleave> guests = guestle.getDetails();
        StringBuilder sb = new StringBuilder();
        for (Guestleave guest : guests) {
            sb.append(guest.toString()).append("\n");
        }
        det.setText(sb.toString());
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==showDetails){
            
            try{
                displayGuests();
            }
            catch(Exception x){
                x.printStackTrace();
            }

        }
    }


    
    public static void main(String[] args) {
        leaveguest a=new leaveguest();
    }

    
}

class guestle{
    public static List<Guestleave> getDetails() throws SQLException {
        List<Guestleave> g = new ArrayList<>();
      
        String q = "select * from leaveguests";
        try {
            Connection con = UserDAO.getConnection();
          
            PreparedStatement pst = con.prepareStatement(q);

           
            ResultSet set = pst.executeQuery();
            System.out.println("executed");

            while(set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
               int  roomn = set.getInt(3);
                String l = set.getString(4);
                int days = set.getInt(5);
                java.sql.Timestamp time=set.getTimestamp(6);

                Guestleave guests = new Guestleave(id, name, roomn, l, days,time);
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

class Guestleave{
    private int book_id, room_id,days;
    private String guestname,locate;
    java.sql.Timestamp time;

    public Guestleave(int book_id, String guestname, int roomid,String locate,int days,java.sql.Timestamp time) {
        this.book_id = book_id;
        this.guestname = guestname;
        this.room_id = roomid;
        this.locate=locate;
        this.days=days;
        this.time=time;
    }

    public String toString() {
        return "       "+ book_id + "                                " + guestname + "                                               " + room_id
        +"                                          "+locate+"                                                  "+days+
        "                                      "+time;

    }
}

