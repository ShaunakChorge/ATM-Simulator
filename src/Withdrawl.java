
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {

    String pinnumber;           // Variable to store the user's PIN number

    JButton withdraw, back;
    JTextField amount;

    // Constructor for the Withdrawl class
    Withdrawl(String pinnumber) {

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
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);


        // Create a text field for entering the withdrawal amount
        
        amount = new JTextField();
        amount.setBackground(Color.BLACK);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(200, 350, 275, 25);
        image.add(amount);


        // Create the Withdraw button
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);


        // Create the Back button

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        // Set frame properties

        setUndecorated(true);
        setSize(900,880);
        setLocation(300, 0);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {
    
    // If the Withdraw button is clicked, perform the withdrawal operation
    if (ae.getSource() == withdraw) {
        String number = amount.getText();       // Get amount entered dor withdrawl
        Date date = new Date();                 // Get current Date

        // Check if the amount field is empty    
        if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter the amount you want to Withdraw");
        } else {
            try {

                // Create Database connection and update it 

                Conn conn = new Conn();
                // Check current balance
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                // Check if balance is sufficient
                if (balance < Integer.parseInt(number)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return; // Exit the method if balance is insufficient
                }

                // Proceed with withdrawal
                String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + number + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + number + " Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Check if the Back button was clicked, return to Transactions page
    } else if (ae.getSource() == back) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}

    // Main method to run the Withdrawl application
    public static void main(String args[]) {
        new Withdrawl("");
    }
}
