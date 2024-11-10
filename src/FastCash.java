
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;


public class FastCash extends JFrame implements ActionListener{

    String pinnumber;       // Variable to store the user's PIN number
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;

    // Constructor for the FastCash class
    FastCash(String pinnumber) {

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
        
        JLabel text = new JLabel("Select Withdrwl Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 300, 700, 35);
        image.add(text);


        // Create buttons for different withdrawal amounts

        rs100 = new JButton("Rs 100");
        rs100.addActionListener(this);
        rs100.setBounds(170, 415, 150, 30);
        image.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.addActionListener(this);
        rs500.setBounds(355, 415, 150, 30);
        image.add(rs500);

        rs1000 = new JButton("Rs 1000");
        rs1000.addActionListener(this);
        rs1000.setBounds(170, 450, 150, 30);
        image.add(rs1000);

        rs2000 = new JButton("Rs 2000");
        rs2000.addActionListener(this);
        rs2000.setBounds(355, 450, 150, 30);
        image.add(rs2000);
        
        rs5000 = new JButton("Rs 5000");
        rs5000.addActionListener(this);
        rs5000.setBounds(170, 485, 150, 30);
        image.add(rs5000);
        
        rs10000 = new JButton("Rs 10000");
        rs10000.addActionListener(this);
        rs10000.setBounds(355, 485, 150, 30);
        image.add(rs10000);
        

        // Create the Back button
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(355, 520, 150, 30);
        image.add(back);


        // Set frame properties
        
        setUndecorated(true);
        setSize(900, 850);
        setLocation(300, 0);
        setVisible(true); 

    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == back) {       //Onclick Back go to Transactions page
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);


       
            // Handle withdrawal button clicks
            
        } else { 

             // Get the amount from the button text by removing the "Rs " prefix
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            
            // Create a new database connection 
            Conn c = new Conn();

            try {

                // Query to retrieve the current balance based on the user's PIN
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                
                int balance = 0;                // Initialize balance variable


                // Calculate the balance by iterating through the transaction records
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")) {

                        // Add deposit amounts
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {

                        // Subtract withdrawal amounts
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }


                // Check if the balance is sufficient for the requested withdrawal
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }


                // Proceed with the withdrawal transaction
                Date date = new Date();
                String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"' )";
                c.s.executeUpdate(query);
                
                // Show success message
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
                
            }
        
        }


    }

    // Main method to run the FastCash application
    public static void main(String[] args) {

        new FastCash("");
        // Create a new FastCash object with an empty PIN number


    }

    
}
