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
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connnected to database : " + db);
            System.out.println(dots + "1");
            Statement statement = conn.createStatement();
            System.out.println(dots + "2");
            //statement.executeUpdate(query0);
            System.out.println(dots + "3");
            statement.executeUpdate(query);
            System.out.println(dots + "4");
            statement.executeUpdate(query2);
            statement.executeUpdate(query21);
            System.out.println(dots + "5");
            ResultSet resultSet = statement.executeQuery(query3);
            System.out.println(dots + "6");
            System.out.println(resultSet.getRow());
            while (resultSet.next())
            {
              int id = resultSet.getInt("PersonID");

              // print the results
              System.out.println(id);
            }
            System.out.println(dots + "7");
        } catch (SQLException e) {
            System.out.println("SQLException: "+e.getMessage());
            System.out.println("SQLState: "+e.getSQLState());
            System.out.println("VendorError: "+e.getErrorCode());
        }//end Catch
    }//end main
}//end class
