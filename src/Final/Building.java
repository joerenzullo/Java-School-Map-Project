package Final;

/**
 * Class to represent the data about a building (name is usable by DB, location
 * is usable by mouse interaction).
 * @author Bobby
 */
public class Building 
{
    String name;
    int minX, minY, maxX, maxY;
    
    /**
     * @param Name Name of the building
     * @param minX x coordinate of upper left corner
     * @param minY y coordinate of upper left corner
     * @param maxX x coordinate of lower right corner
     * @param maxY y coordinate of lower right corner
     */
    public Building(String Name, int minX, int minY, int maxX, int maxY)
    {
        name = Name;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Checks if a click is within this building
     * @param inX the mouse x coordinate
     * @param inY the mouse y coordinate
     * @return a boolean - true if within this building, false otherwise
     */
    public boolean isWithin(int inX, int inY)
    {
        if(inX > minX && inY > minY && inX < maxX && inY < maxY)
        return true;
        return false;
    }
}