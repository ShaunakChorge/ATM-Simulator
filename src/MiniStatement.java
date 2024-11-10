
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {

    String pinnumber;                   // Variable to store the user's PIN number

    // Constructor for the MiniStatement class
    MiniStatement(String pinnumber) {

        this.pinnumber = pinnumber;     // Initialize the PIN number

        setLayout(null);

        setTitle("Mini Statement");     // Set the title of the window


        // Create and customize the bank label
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);


        // Create a label to display the card number
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);



        try {

            // Create a database connection
            Conn conn = new Conn();
            
            // Query to retrieve the card number based on the user's PIN
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            
            while (rs.next()) {

                // Display the card number with masked digits
                card.setText("Card Number:      " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX"+ rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        // Create and customize the label for transaction history
        
        JLabel state = new JLabel("Your last 5 transactions:");
        state.setBounds(20, 140, 200, 20);
        add(state);


        // Create a label to display the transaction details
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 160, 400, 200);
        add(mini);


        // Create a label to display the account balance
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 300, 20);
        add(bal);

        try {

            // Create a database connection
            Conn conn = new Conn();
            
            int balance = 0;
        
            // Retrieve all transactions to calculate the correct balance
            ResultSet rsBalance = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rsBalance.next()) {
                if (rsBalance.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rsBalance.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rsBalance.getString("amount"));
                }
            }
        
            // Display the last 5 transactions in descending order
            ResultSet rsTransactions = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"' order by date desc limit 5");
            while (rsTransactions.next()) {
                mini.setText(mini.getText() + "<html>" + rsTransactions.getString("date") + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + rsTransactions.getString("type") + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + rsTransactions.getString("amount") + "<br><br><html>");
            }
        
            // Set the balance label
            bal.setText("Your Account Balance is Rs " + balance);
        
        } catch (Exception e) {
            System.out.println(e);
        }


        // Set frame properties
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    // Main method to run the MiniStatement application
    public static void main(String[] args) {
        
        new MiniStatement("").setVisible(true);
        // Create a new MiniStatement object with an empty PIN number
    }
}
