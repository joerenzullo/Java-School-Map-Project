package test;

public class Building 
{
    String name;
    int minX, minY, maxX, maxY;

    public Building(String Name, int minX, int minY, int maxX, int maxY)
    {
        name = Name;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isWithin(int inX, int inY)
    {
        if(inX > minX && inY > minY && inX < maxX && inY < maxY)
        return true;
        return false;
    }
}