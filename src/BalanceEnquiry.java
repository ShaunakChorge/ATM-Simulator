
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinnumber;       // Variable to store the user's PIN number

    JButton back;

    // Constructor for the BalanceEnquiry class
    BalanceEnquiry(String pinnumber) {

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
        
        JLabel text = new JLabel("Your Account Balance is Rs ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(225, 300, 500, 35);
        image.add(text);

        
        // Create a database connection
        Conn c = new Conn();
        
        int balance = 0;                // Initialize balance variable
        
        try {

            // Query to retrieve the account balance based on the user's PIN
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            // Loop through the result set to calculate the balance
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }


        // Display the calculated balance
        
        JLabel balance1 = new JLabel(String.valueOf(balance));
        balance1.setForeground(Color.WHITE);
        balance1.setFont(new Font("System", Font.BOLD, 20));
        balance1.setBounds(275, 350, 500, 35);
        image.add(balance1);


        // Create the Back button
        
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

    public void actionPerformed(ActionEvent ae) {       //Open Transactions page
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    // Main method to run the BalanceEnquiry application
    public static void main(String[] args) {
        new BalanceEnquiry("");
        // Create a new BalanceEnquiry object with an empty PIN number
    }
}
