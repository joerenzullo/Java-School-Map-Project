package test;

/**
 * a vertex- the basis of pathfinding via dijkstra's algorithm.
 * @author Bobby
 */
public class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public int posx;
    public int posy;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    
    /**
     * creates a vertex with a name, x position and y position.
     * @param argName string name of the vertex
     * @param x amount of pixels from the left
     * @param y amount of pixels from the top
     */
    public Vertex(String argName, int x, int y)
    {
    	name = argName;
    	posx = x;
    	posy = y;
    }
    
    /**
     * returns the string representation of the vertex.
     */
    public String toString()
    { 
    	return name + "(" + posx + "," + posy +")";
    }
    
    /**
     * compares vertex to another by their mindistance- initually they will be equal, but after
     * compute paths is run, they can then be ordered by distance from the source vertex.
     */
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    
    /**
     * resets the pathfinding data so that the paths can be set from a new sources.
     */
    public void reset()
    {
    	minDistance = Double.POSITIVE_INFINITY;
    	previous = null;
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    /**
     * constructor for an edge- just needs the vertex it points to and the weight.
     * @param argTarget vertex it goes to.
     * @param argWeight weight to that vertex.
     */
    public Edge(Vertex argTarget, double argWeight)
    { 
    	target = argTarget;
    	weight = argWeight; 
    }
}