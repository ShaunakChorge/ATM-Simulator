
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.*;
import java.text.ParseException;



public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {
        setLayout(null);

        // Generating a random application number
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        // Label for application form number and page title

        JLabel formno = new JLabel("APPLICATION FORM NO: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);


        // Label and text field for Name

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);


        // Label and text field for Father's Name

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 150, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);


        // Label and date chooser for Date of Birth

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 150, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);


        // Gender options labels, Radio buttons and groups 

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 150, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);


        // Label and text field for Email Address

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 150, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);


        // Marital Status options labels, Radio buttons and groups 

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 150, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Others");
        other.setBounds(630, 390, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);


        // Label and text field for Address

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 150, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);


        // Label and text field for City

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 150, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);


         // Label and text field for State

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 150, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);


        // Label and text field for Pincode

        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 150, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);


        // Next button to proceed

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660, 80, 30);
        next.addActionListener(this);
        add(next);


        // Frame settings

        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
        // Action to be performed on button click

        // Retrieve the application form number and user inputs
        String formno = "" + random; 
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        
        // Get the date of birth from the date chooser
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        // Determine the selected gender
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } 
        
        // Retrieve the email address input
        String email = emailTextField.getText();
       
        // Determine the selected marital status
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        } 

        // Retrieve address, city, state, and pincode inputs
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            // Validate user inputs
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Father's Name is required");
            } else if (dob.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required");
            } else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Gender selection is required");
            } else if (email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(null, "Valid Email is required");
            } else if (marital == null) {
                JOptionPane.showMessageDialog(null, "Marital status selection is required");
            } else if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address is required");
            } else if (city.isEmpty()) {
                JOptionPane.showMessageDialog(null, "City is required");
            } else if (state.isEmpty()) {
                JOptionPane.showMessageDialog(null, "State is required");
            } else if (pincode.isEmpty() || !pincode.matches("\\d{6}")) {
                JOptionPane.showMessageDialog(null, "Valid 6-digit Pincode is required");
            } 
            else {
                // If all inputs are valid, insert data into the database
                Conn c = new Conn();
                String query = "INSERT into signup_1 values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pincode + "', '" + state + "')";

                // Execute the query to insert the data
                c.s.executeUpdate(query);
                
                // Hide the current frame and show the next signup page
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        } catch (Exception e) {
            // Print any exceptions that occur during the process
            System.out.println(e);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Create an instance of SignupOne to display the signup form
        new SignupOne();
    }
}