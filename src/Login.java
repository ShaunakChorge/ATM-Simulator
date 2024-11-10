import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
    // Declare UI components
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField; 

    // Constructor for Login class
    Login() {
        // Set layout manager
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");

        // Set logo image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Set background color
        getContentPane().setBackground(Color.WHITE);

        // Welcome text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        // Card number label and text field
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        // PIN label and password field
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // Login button
        login = new JButton("LOGIN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Clear button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
      
        // Sign Up button
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Set frame properties
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        // Clear button action
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } 
        // Login button action
        else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "Select * from login where cardNumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";

            try {
                ResultSet rs = conn.s.executeQuery(query);
                // Check if login is successful
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN !!!");
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        // Sign Up button action
        else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new Login();
    }
}