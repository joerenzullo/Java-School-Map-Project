package test;

public class Building 
{
	String name;
	int minX, minY, maxX, maxY;
	
	public Building(String Name, int MINX, int MINY, int MAXX, int MAXY)
	{
		name = Name;
		minX = MINX;
		minY = MINY;
		maxX = MAXX;
		maxY = MAXY;
	}
	
	public boolean isWithin(int inX, int inY)
	{
		if(inX > minX && inY > minY && inX < maxX && inY < maxY)
			return true;
		return false;
	}
}

