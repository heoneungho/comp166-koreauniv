
public class User {
	public String name;
	public Point[] horse = new Point[4];
	
	public User(String name)
	{
		this.name = name;
		
		for (int i=0;i<4;i++)
		{
			horse[i] = Point.NOT_IN_GAME;
		}
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}

// ���� �����Ѵ�. 4���� ���� ���´�.