

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update1 {
    // Make these variables static so they can be accessed in the static main method
    private static final String URL = "jdbc:mysql://localhost:3306/Students1";
    private static final String USER = "root"; 
    private static final String PASSWORD = "sujii"; 

    public static void main(String[] update1) {
        try {
            // Connection to the database
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Update Operation - Corrected SQL query
            String updateSQL = "UPDATE Person SET Email = ? WHERE F_Name = ? AND L_Name = ?";
            PreparedStatement updateStatement = con.prepareStatement(updateSQL);

            // Set the new email and the name to update
            updateStatement.setString(1, "suji@gmail.com"); // New email
            updateStatement.setString(2, "Sujitha");  // First name (F_Name)
            updateStatement.setString(3, "karthick");  // Last name (L_Name)

            // Execute the update
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update operation completed. Rows updated: " + rowsUpdated);
            } else {
                System.out.println("No rows updated. Check the provided names.");
            }

        } catch (SQLException e) {
            System.out.println("Error during update: " + e.getMessage());
        }
    }
}
