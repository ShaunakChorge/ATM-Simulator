
import java.sql.*;  // Importing necessary SQL packages

public class Conn {
    Connection c; // Variable to hold the database connection
    Statement s;  // Variable to hold the statement for executing queries

    // Constructor for the Conn class
    public Conn() {  
        try {  
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  
            // Establish a connection to the database
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");    
            // Create a statement object to execute queries
            s = c.createStatement(); 
        } catch (Exception e) { 
            // Print any exceptions that occur to the console
            System.out.println(e);
        }  
    }  
}