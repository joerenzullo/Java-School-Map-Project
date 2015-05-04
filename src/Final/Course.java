package Final;

/**
 * Database object representing a course
 * @author Joe
 */
public class Course 
{
    public String Title;
    public String Status;
    public String Type;
    public String CRN;
    public String Unit;
    public String Meet;
    public String Meeting_Time;
    public String Location;
    public String Cap;
    public String Act;
    public String Rem;
    public String Instructor;
    public String Date;
    public String Weeks;
      
    public Course(String Title, String Status, String Type, String CRN, 
            String Unit, String Meet, String Meeting_Time, String Location, 
            String Cap, String Act, String Rem, String Instructor, String Date, 
            String Weeks)
    {
        this.Title = Title;
        this.Status = Status;
        this.Type = Type;
        this.CRN = CRN;
        this.Unit = Unit;
        this.Meet = Meet;
        this.Meet = Meeting_Time;
        this.Location = Location;
        this.Cap = Cap;
        this.Act = Act;
        this.Rem = Rem;
        this.Instructor = Instructor;
        this.Date = Date;
        this.Weeks = Weeks;
    }
    
    
    
}
