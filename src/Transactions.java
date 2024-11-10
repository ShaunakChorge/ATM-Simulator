
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{

    String pinnumber;                   // Variable to store the PIN number
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;

    // Constructor for the Transactions class
    Transactions(String pinnumber) {

        this.pinnumber = pinnumber;     // Initialize the PIN number
        setLayout(null);


        // Load and scale the ATM image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        // Create and customize the transaction selection text
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 300, 700, 35);
        image.add(text);


        // Creating Transaction buttons

        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.addActionListener(this);
        withdrawl.setBounds(355, 415, 150, 30);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.addActionListener(this);
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.addActionListener(this);
        ministatement.setBounds(355, 450, 150, 30);
        image.add(ministatement);
        
        pinchange = new JButton("PIN Change");
        pinchange.addActionListener(this);
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.addActionListener(this);
        balanceenquiry.setBounds(355, 485, 150, 30);
        image.add(balanceenquiry);
        

        exit = new JButton("EXIT");
        exit.addActionListener(this);
        exit.setBounds(355, 520, 150, 30);
        image.add(exit);


        // Set frame properties

        setSize(900, 850);
        setLocation(300, 0);
        
        setUndecorated(true);
        setVisible(true); 

    }
    
    public void actionPerformed(ActionEvent ae) {

        // Action listener method to handle button clicks

        if (ae.getSource() == exit) {       // Exit the application 
            System.exit(0);
        } else if (ae.getSource() == deposit) {     // Go to Deposit page
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        
        } else if (ae.getSource() == withdrawl) {   // Go to Withdrawl page
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);

        } else if (ae.getSource() == fastcash) {    // Go to FastCash page
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        } else if (ae.getSource() == pinchange) {   // Go to PinChange page
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);

        } else if (ae.getSource() == balanceenquiry) {  // Go to Balance Enquiry page
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);

        } else if (ae.getSource() == ministatement) {   //Print Mini Statement page
            
            new MiniStatement(pinnumber).setVisible(true);

        } 


    }

    // Main method to run the Transactions application
    public static void main(String[] args) {

        new Transactions("");   // Create a new Transactions object with an empty PIN number
        

    }

    
}
