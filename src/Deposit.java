
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {

    String pinnumber;       // Variable to store the user's PIN number

    JButton deposit, back;
    JTextField amount;

    // Constructor for the Deposit class
    Deposit(String pinnumber) {

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
        
        JLabel text = new JLabel("Enter the amount you want to Deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);


        // Create a text field for entering the deposit amount
        
        amount = new JTextField();
        amount.setBackground(Color.BLACK);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(200, 350, 275, 25);
        image.add(amount);


        // Create the Deposit button
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);


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


    public void actionPerformed(ActionEvent ae) {
        
        // Check if the Deposit button was clicked
        if (ae.getSource() == deposit) {

            String number = amount.getText();   // Get the amount entered by the user          
            Date date = new Date();             // Get the current date


            // Check if the amount field is empty
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to Deposit");
            } else {
                try {

                    // Create a new database connection and update database

                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Credited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (Exception e){
                     System.out.println(e);
                }
            }

        // Check if the Back button was clicked and return to Transaction page       
        } else if (ae.getSource() == back) {

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }

    }

    // Main method to run the Deposit application
    public static void main(String args[]) {
        new Deposit("");
    }
}
