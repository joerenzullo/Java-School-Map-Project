package Final;

import java.sql.*;
import java.util.ArrayList;


public class SQLiteJDBC
{
    public static void main( String args[] )
    {
        ArrayList<Course> Courses = execute_sql("SELECT * from courses;");
        for (Course i : Courses)
        {
            System.out.println(i.Location);
        }
    }
  
 public static ArrayList<Course> execute_sql(String SQL)
 {
    ArrayList<Course> Courses = new ArrayList<>();
     
    Connection c = null;
    Statement stmt = null;
    try 
    {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while ( rs.next() ) 
        {
            String Title = rs.getString("Title");
            String Status = rs.getString("CRN");
            String Type  = rs.getString("Type");
            String CRN = rs.getString("CRN");
            String Unit = rs.getString("Unit");
            String Meet = rs.getString("Meet");
            String Meeting_Time = rs.getString("Meeting_Time");
            String Location = rs.getString("Location");
            String Cap = rs.getString("Cap");
            String Act = rs.getString("Act");
            String Rem = rs.getString("Rem");
            String Instructor = rs.getString("Instructor");
            String Date = rs.getString("Date");
            String Weeks = rs.getString("Weeks");
        
        
            Courses.add(new Course(Title, Status, Type, CRN, Unit, Meet, 
                    Meeting_Time, Location, Cap, Act, Rem, Instructor, Date, 
                    Weeks));
        }
        rs.close();
        stmt.close();
        c.close();
    } 
    catch ( Exception e ) 
    {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
    }
    return Courses;
 }
}