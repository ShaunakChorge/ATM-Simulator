
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;



public class SignupTwo extends JFrame implements ActionListener{

    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;

    // Constructor for SignupTwo class
    SignupTwo(String formno) {

        this.formno = formno;       // Store the form number
        setLayout(null);    // Set layout to null for absolute positioning


        // Create and add label for the page title
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
    
        JLabel additionalDetails = new JLabel("Page 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);


        // Religion selection

        JLabel Religion_n = new JLabel("Religion: ");
        Religion_n.setFont(new Font("Raleway", Font.BOLD, 20));
        Religion_n.setBounds(100, 140, 100, 30);
        add(Religion_n);

        String valReligion[] = {"Select Option", "Hindu", "Muslim", "Christian", "Sikh", "Buddhist", "Jain", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);


        // Category selection

        JLabel Category_n = new JLabel("Category: ");
        Category_n.setFont(new Font("Raleway", Font.BOLD, 20));
        Category_n.setBounds(100, 190, 150, 30);
        add(Category_n);

        String valCategory[] = {"Select Option", "General", "OBC", "SC", "ST", "NT", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);


        // Income selection

        JLabel Income = new JLabel("Income: ");
        Income.setFont(new Font("Raleway", Font.BOLD, 20));
        Income.setBounds(100, 240, 150, 30);
        add(Income);

        String valIncome[] = {"Select Option", "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,0,000", "more than 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);


        // Educational qualification selection

        JLabel Educational_n = new JLabel("Educational: ");
        Educational_n.setFont(new Font("Raleway", Font.BOLD, 20));
        Educational_n.setBounds(100, 290, 150, 30);
        add(Educational_n);

        JLabel Qualification_n = new JLabel("Qualification: ");
        Qualification_n.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification_n.setBounds(100, 315, 150, 30);
        add(Qualification_n);

        String educationValues[] = {"Select Option", "Non Graduate", "Graduate", "Post Graduate", "Doctrate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);


         // Occupation selection

        JLabel Occupation = new JLabel("Occupation: ");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 150, 30);
        add(Occupation);
        
        String occupationValues[] = {"Select Option", "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        // PAN number input

        JLabel pan_no = new JLabel("PAN Number: ");
        pan_no.setFont(new Font("Raleway", Font.BOLD, 20));
        pan_no.setBounds(100, 440, 200, 30);
        add(pan_no);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);


         // Aadhar number input

        JLabel aadhar_no = new JLabel("AADHAR Number: ");
        aadhar_no.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar_no.setBounds(100, 490, 250, 30);
        add(aadhar_no);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);


        // Yes/No questions for Senior Citizen

        JLabel Senior_c = new JLabel("Senior Citizen: ");
        Senior_c.setFont(new Font("Raleway", Font.BOLD, 20));
        Senior_c.setBounds(100, 540, 200, 30);
        add(Senior_c);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 60, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 120, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);


        // Yes/No questions for Existing Account

        JLabel Exist_c = new JLabel("Existing Account: ");
        Exist_c.setFont(new Font("Raleway", Font.BOLD, 20));
        Exist_c.setBounds(100, 590, 250, 30);
        add(Exist_c);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 60, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 120, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existGroup = new ButtonGroup();
        existGroup.add(eyes);
        existGroup.add(eno);


        // Next button to proceed to the next step

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
        
        // Retrieve selected values from the combo boxes and text fields
        
        String s_religion = (String) religion.getSelectedItem();
        String s_category = (String) category.getSelectedItem();
        String s_income = (String) income.getSelectedItem();
        String s_education = (String) education.getSelectedItem();
        String s_occupation = (String) occupation.getSelectedItem();
        
        String s_pan = pan.getText();
        String s_aadhar = aadhar.getText();
        

        // Check if the user is a senior citizen
        
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        } 
        
        
        // Check if the user has an existing account
        
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        } 


        try {
                // Validate that all required fields are filled correctly
            
                if (s_religion.equals("Select Option") ||
                 s_category.equals("Select Option") ||
                 s_income.equals("Select Option") ||
                 s_education.equals("Select Option") ||
                 s_occupation.equals("Select Option") ||
                 s_pan.isEmpty() ||
                 s_aadhar.isEmpty() ||
                 seniorcitizen == null || 
                 existingaccount == null) {

                    JOptionPane.showMessageDialog(null, "Please fill all fields correctly before proceeding.");
                    return;

                
                } else {

                    Conn c = new Conn();
                    String query = "INSERT into signup_2 values('"+formno+"', '"+s_religion+"', '"+s_category+"', '"+s_income+"', '"+s_education+"', '"+s_occupation+"', '"+s_pan+"', '"+s_aadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";

                    c.s.executeUpdate(query);

                    
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);

                }
                
            } catch (Exception e) {

                System.out.println(e);
            }
    }
   
// Main method to run the SignupTwo class

    public static void main(String[] args) {
        new SignupTwo(""); 
    }
}
