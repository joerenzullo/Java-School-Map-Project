package Final;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Map object which does the pathfinding
 * @author Bobby and Joe
 */
public class Map 
{
    public static String sourceString;
    public static String destinationString;
    public static User user = new User(0);
    public static MapPanel mapPanel = new MapPanel();
    private static JPanel dataPanel = new JPanel();
    private static JTextArea textarea = new JTextArea(38,33);
    
    
    public static void main(String[] args) throws IOException 
    {
        //default size for frame
        final int FRAME_HEIGHT = 630;
        final int FRAME_WIDTH = 1050;
        
        //handle layout
        JPanel layoutPanel = new JPanel(new BorderLayout());
        
        //add the map panel
        layoutPanel.add(mapPanel, BorderLayout.CENTER);
        
        //make the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(layoutPanel);
        frame.setTitle("Pathfinding Map");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //handle data panel
        layoutPanel.add(dataPanel, BorderLayout.EAST);
        JScrollPane scrollpane = new JScrollPane(textarea);
        textarea.setEditable(false);
        dataPanel.add(scrollpane);
        dataPanel.setVisible(true);
        
        //set frame visible
        frame.setVisible(true);  

        //initialize with default
        sourceString = "VCC";
        destinationString = "VCC";
        pathFind(sourceString, destinationString, user, mapPanel);
    }
    
    /**
     * This method handles the logic when someone clicks on the map.
     * @param buildings an array of Building objects
     * @param x x coordinate of the click
     * @param y y coordinate of the click
     */
    public static void buildingClick(Building[] buildings, int x, int y)
    {
        for(Building b : buildings)
        {
            if(b.isWithin(x, y))
            {
                String SQL = "SELECT * from courses WHERE Location LIKE '" + b.name + " %'";
                ArrayList<Course> Courses = Final.SQLHandler.execute_sql(SQL);
                textarea.setText("");
                textarea.append("CRN     |  Course Title\n");
                textarea.append("==================================\n");
                for (Course course : Courses)
                {
                    textarea.append(course.CRN + " | " + course.Title + "\n");
                }
                textarea.repaint();
            }
        }
    }

    /**
     * returns a list of vertexes for the path
     * @param source : the string of the name of the starting vertex
     * @param destination : the string of the name of the destination (building)
     * @param user : the user to pull the pathfinding data from and then reset.
     * @param panel : the mapPanel to draw to.
     */
    public static void pathFind(String source, String destination, User user, MapPanel panel)
    {
        computePaths(user.findVertexNamed(source));
        List<Vertex> path = getShortestPathTo(user.findVertexNamed(destination));
        //DEBUG: System.out.println("Path: " + path);
        user.resetPFD();
        panel.path = path;
        panel.repaint();
        
    }


    /**
     * used to initialize the pathfinding data to be from whatever vertex.
     * @param source the vertex to pathfind from to all the others. changes data in all of the vertices.
     */
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) 
        {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) 
                {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    /**
     * once the data is initialized by computePaths, this will create the sorted list of vertices in order of where to visit.
     * @param target the vertex to give the path to.
     * @return list of vertexes to be used by the GUI to draw.
     */
    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
        {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }
}