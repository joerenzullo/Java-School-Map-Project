package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.JFrame;

public class Map 
{

	public static void main(String[] args) throws IOException 
	{
		/**
		 * create the map frame
		 */
		final int FRAME_HEIGHT = 615;
		final int FRAME_WIDTH = 690;
		
		String sourceString = "CC2";
		String destinationString = "VSV";
		
		//MapFrame mapFrame = new MapFrame();
		
		MapPanel panel = new MapPanel();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setTitle("Pathfinding Map");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		
		User user = new User(0);
		
		pathFind(sourceString, destinationString, user, panel);
		
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
        //System.out.println("Path: " + path);
        user.resetPFD();
		panel.path = path;
	}
	
	/**
	 *  used to initialize the pathfinding data to be from whatever vertex.
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
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

}