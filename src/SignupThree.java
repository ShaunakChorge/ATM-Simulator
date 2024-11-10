
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class SignupThree extends JFrame implements ActionListener{

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;


    // Constructor for SignupThree class
    SignupThree(String formno){

        this.formno = formno;
        setLayout(null);


        // Create and add label for the page title
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        

        // Account Type selection
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

    
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);


        // Card Number Section
        
        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number: ");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 330, 300, 20);
        add(carddetail);

        JLabel number = new JLabel("XXXX XXXX XXXX 4184 ");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);
        

        // PIN Number Section

        JLabel pin = new JLabel("PIN Number: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
 
        JLabel pindetail = new JLabel("Your 4 Digit PIN Number: ");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 400, 300, 20);
        add(pindetail);

        JLabel pnumber = new JLabel("XXXX ");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);
       

        // Services Selection

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 230, 30);
        add(c3);

        c4 = new JCheckBox("Email/SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        
        // Form Declaration

        c7 = new JCheckBox("I hereby declare that the information provided is correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);


        // Submit and Cancel

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(420, 720, 100, 30); 
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(250, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);


        // Frame Settings 

        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae) {
    
    // Check if the submit button was clicked

    if (ae.getSource() == submit) {
        

        // Determine which account type radio button is selected
                
        String accountType = null;
        if (r1.isSelected()) {
            accountType = "Saving Account";
        } else if (r2.isSelected()) {
            accountType = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            accountType = "Current Account";
        } else if (r4.isSelected()) {
            accountType = "Recurring Deposit Account";
        }


         // Check which services checkboxes are selected and append to the StringBuilder
           
        String facility = "";
        if (c1.isSelected()) {
            facility += " ATM Card";
        }
        if (c2.isSelected()) {
            facility += " Internet Banking";
        }
        if (c3.isSelected()) {
            facility += " Mobile Banking";
        }
        if (c4.isSelected()) {
            facility += " Email/SMS Alerts";
        }
        if (c5.isSelected()) {
            facility += " Cheque Book";
        }
        if (c6.isSelected()) {
            facility += " E-Statement";
        }

        // Collect validation messages
        StringBuilder validationMessages = new StringBuilder();

        if (accountType == null) {
            validationMessages.append("Please select an Account Type.\n");
        }
        if (facility.isEmpty()) {
            validationMessages.append("Please select at least one Service Required.\n");
        }
        if (!c7.isSelected()) {
            validationMessages.append("Please agree to the Declaration.\n");
        }

        // If there are validation messages, show them
        if (validationMessages.length() > 0) {
            JOptionPane.showMessageDialog(null, validationMessages.toString());
        } else {

            // If all validations pass, generate card number and PIN
                
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            try {

                // Create a connection to the database update in database
                   
                Conn conn = new Conn();
                String query1 = "INSERT INTO signup_3 values ('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "' )";
                String query2 = "INSERT INTO login values ('" + formno + "', '" + cardnumber + "', '" + pinnumber + "' )";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number " + cardnumber + "\n PIN: " + pinnumber);

                setVisible(false);
                new Deposit(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    } else if (ae.getSource() == cancel) {

        // If the cancel button is clicked, hide the current window and show the login page
            
        setVisible(false);
        new Login().setVisible(true);
    }
}
    
    // Main method to run the SignupThree class
   
    public static void main(String[] args) {

        new SignupThree("");
    }

}
