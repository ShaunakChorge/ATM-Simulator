
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

    String pinnumber;                   // Variable to store the user's PIN number

    JPasswordField pin, repin;
    JButton change, back;

    // Constructor for the PinChange class
    public PinChange(String pinnumber) {

        this.pinnumber = pinnumber;     // Initialize the PIN number

        setLayout(null);


        // Load and scale the ATM image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        // Create and customize the instruction text
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(260, 300, 500, 35);
        image.add(text);


        // New PIN input
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 340, 180, 25);
        image.add(pintext);
    
        pin = new JPasswordField();
        pin.setBackground(Color.BLACK);
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(330, 340, 180, 25);
        image.add(pin);


        // Re PIN input

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 380, 180, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setBackground(Color.BLACK);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("Raleway", Font.BOLD, 20));
        repin.setBounds(330, 380, 180, 25);
        image.add(repin);

        
        // Change and Back Buttons

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        // Set frame properties
        
        setUndecorated(true);
        setSize(900,850);
        setLocation(300, 0);
        setVisible(true);

        
    }

    public void actionPerformed(ActionEvent ae) {
        
        // Check if the "CHANGE" button was clicked
        if (ae.getSource() == change) {
            try {

                // Get the new PIN and re-entered PIN from the password fields
                String npin = pin.getText();
                String rpin = repin.getText();
    
                // Check if the new PIN and re-entered PIN match
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
    
                // Check if the new PIN is empty
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a new PIN");
                    return;
                }
    
                // Check if the re-entered PIN is empty
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter a new PIN");
                    return;
                }
    
                // Check if the new PIN is exactly 4 digits
                if (npin.length() != 4 || !npin.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits long");
                    return;
                }
    
                
                // Create a database connection and update it
                Conn conn = new Conn(); 
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinnumber + "' ";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinnumber + "' ";
                String query3 = "update signup_3 set pin = '" + rpin + "' where pin = '" + pinnumber + "' ";
    
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully!!");
    
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                    
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    // Main method to run the PinChange application
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
        // Create a new PinChange object with an empty PIN number
    }
}
