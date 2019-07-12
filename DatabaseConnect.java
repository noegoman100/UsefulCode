/*The code below sets up a connection with a MySql database. It then creates a bunch of strings of SQL code to send to the database. 
This SQL code creates a table (if needed), inserts integers into the table, and queries the new table. That's all. */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
    public static void main(String[] argv) throws ClassNotFoundException {
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        String db = "U05jog";
        String url = "jdbc:mysql://52.206.157.109/" + db;
        String user = "U05jog";
        String pass = "53688523223";
        String dots = "*******";
        String query0 = "DROP TABLE Persons;";
        String query = "CREATE TABLE IF NOT EXISTS Persons (PersonID int);";
        String query2 = "INSERT INTO Persons (PersonID) VALUES ('3');";
        String query21 = "INSERT INTO Persons (PersonID) VALUES ('4');";
        String query3 = "SELECT * FROM Persons;";
        
        try {
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass); //Make a connection
            System.out.println("Connnected to database : " + db); //won't make it here if connection throws
            System.out.println(dots + "1"); //Divider
            Statement statement = conn.createStatement();
            System.out.println(dots + "2"); //Divider
            //statement.executeUpdate(query0); //Delete the table. Didn't work. 
            System.out.println(dots + "3"); //Divider
            statement.executeUpdate(query); //Create the table, if needed.
            System.out.println(dots + "4"); //Divider
            statement.executeUpdate(query2); //Add sample value
            statement.executeUpdate(query21); //Add sample value
            System.out.println(dots + "5"); //Divider
            ResultSet resultSet = statement.executeQuery(query3); //Execute a Select Query
            System.out.println(dots + "6"); //Divider
            //System.out.println(resultSet.getRow()); //I'm not sure what this one did. Seems like nothing. 
            while (resultSet.next()) //while there is another row to return
            {
              int id = resultSet.getInt("PersonID");

              // print the results
              System.out.println(id);
            }//End While
            System.out.println(dots + "7"); //Divider
        } //End Try Block 
        catch (SQLException e) {
            System.out.println("SQLException: "+e.getMessage());
            System.out.println("SQLState: "+e.getSQLState());
            System.out.println("VendorError: "+e.getErrorCode());
        }//end Catch
    }//end main
}//end class
