
public class Board {
	
	public static Point Run(Point point, YutResult res)
	{
		Point ret = point;
		int idx = 0;
		
		if (res == YutResult.Do)
		{
			idx = 1;
		}
		else if (res == YutResult.Gae)
		{
			idx = 2;
		}
		else if (res == YutResult.Girl)
		{
			idx = 3;
		}
		else if (res == YutResult.Yut)
		{
			idx = 4;
		}
		else if (res == YutResult.Mo)
		{
			idx = 5;
		}
		
		if (res == YutResult.BbackDo)
		{
			ret = GoBack(ret);
		}
		else 
		{
			ret = Go(ret, idx);
		}
		
		return ret;
	}
	
	private static Point Go(Point point, int idx)
	{
		Point ret = point;
		Point prev = point;
		ret = GoFirst(ret);
		
		for (int i=1;i<idx;i++)
		{
			Point temp = Go(ret, prev);
			prev = ret;
			ret = temp;
		}
		return ret;
	}
	
	private static Point Go(Point point, Point prevPoint)
	{
		if (point == Point.CE1)
			return Point.CE2;
		else if (point == Point.CE2)
			return Point.Center;
		else if (point == Point.Center && prevPoint == Point.CE2)
			return Point.CW1;
		else if (point == Point.Center && prevPoint == Point.CN2)
			return Point.CS1;
		else if (point == Point.CN1)
			return Point.CN2;
		else if (point == Point.CN2)
			return Point.Center;
		else if (point == Point.CS1)
			return Point.CS2;
		else if (point == Point.CS2)
			return Point.South;
		else if (point == Point.CW1)
			return Point.CW2;
		else if (point == Point.CW2)
			return Point.West;
		else if (point == Point.E1)
			return Point.E2;
		else if (point == Point.E2)
			return Point.E3;
		else if (point == Point.E3)
			return Point.E4;
		else if (point == Point.E4)
			return Point.North;
		else if (point == Point.East)
			return Point.E1;
		else if (point == Point.GOAL_IN)
			return Point.GOAL_IN;
		else if (point == Point.N1)
			return Point.N2;
		else if (point == Point.N2)
			return Point.N3;
		else if (point == Point.N3)
			return Point.N4;
		else if (point == Point.N4)
			return Point.West;
		else if (point == Point.North)
			return Point.N1;
		else if (point == Point.NOT_IN_GAME)
			return Point.S1;
		else if (point == Point.S1)
			return Point.S2;
		else if (point == Point.S2)
			return Point.S3;
		else if (point == Point.S3)
			return Point.S4;
		else if (point == Point.S4)
			return Point.East;
		else if (point == Point.South)
			return Point.GOAL_IN;
		else if (point == Point.W1)
			return Point.W2;
		else if (point == Point.W2)
			return Point.W3;
		else if (point == Point.W3)
			return Point.W4;
		else if (point == Point.W4)
			return Point.South;
		else if (point == Point.West)
			return Point.W1;
		return Point.NOT_IN_GAME;
	}
	
	private static Point GoFirst(Point point)
	{
		if (point == Point.CE1)
			return Point.CE2;
		else if (point == Point.CE2)
			return Point.Center;
		else if (point == Point.Center)
			return Point.CS1;
		else if (point == Point.CN1)
			return Point.CN2;
		else if (point == Point.CN2)
			return Point.Center;
		else if (point == Point.CS1)
			return Point.CS2;
		else if (point == Point.CS2)
			return Point.South;
		else if (point == Point.CW1)
			return Point.CW2;
		else if (point == Point.CW2)
			return Point.West;
		else if (point == Point.E1)
			return Point.E2;
		else if (point == Point.E2)
			return Point.E3;
		else if (point == Point.E3)
			return Point.E4;
		else if (point == Point.E4)
			return Point.North;
		else if (point == Point.East)
			return Point.CE1;
		else if (point == Point.GOAL_IN)
			return Point.GOAL_IN;
		else if (point == Point.N1)
			return Point.N2;
		else if (point == Point.N2)
			return Point.N3;
		else if (point == Point.N3)
			return Point.N4;
		else if (point == Point.N4)
			return Point.West;
		else if (point == Point.North)
			return Point.CN1;
		else if (point == Point.NOT_IN_GAME)
			return Point.S1;
		else if (point == Point.S1)
			return Point.S2;
		else if (point == Point.S2)
			return Point.S3;
		else if (point == Point.S3)
			return Point.S4;
		else if (point == Point.S4)
			return Point.East;
		else if (point == Point.South)
			return Point.GOAL_IN;
		else if (point == Point.W1)
			return Point.W2;
		else if (point == Point.W2)
			return Point.W3;
		else if (point == Point.W3)
			return Point.W4;
		else if (point == Point.W4)
			return Point.South;
		else if (point == Point.West)
			return Point.W1;
		return Point.NOT_IN_GAME;
	}
	
	private static Point GoBack(Point point)
	{
		if (point == Point.CE1)
			return Point.East;
		else if (point == Point.CE2)
			return Point.CE1;
		else if (point == Point.Center)
			return Point.CN2;
		else if (point == Point.CN1)
			return Point.North;
		else if (point == Point.CN2)
			return Point.CN1;
		else if (point == Point.CS1)
			return Point.Center;
		else if (point == Point.CS2)
			return Point.CS1;
		else if (point == Point.CW1)
			return Point.Center;
		else if (point == Point.CW2)
			return Point.CW1;
		else if (point == Point.E1)
			return Point.East;
		else if (point == Point.E2)
			return Point.E1;
		else if (point == Point.E3)
			return Point.E2;
		else if (point == Point.E4)
			return Point.E3;
		else if (point == Point.East)
			return Point.S4;
		else if (point == Point.GOAL_IN)
			return Point.GOAL_IN;
		else if (point == Point.N1)
			return Point.North;
		else if (point == Point.N2)
			return Point.N1;
		else if (point == Point.N3)
			return Point.N2;
		else if (point == Point.N4)
			return Point.N3;
		else if (point == Point.North)
			return Point.E4;
		else if (point == Point.NOT_IN_GAME)
			return Point.NOT_IN_GAME;
		else if (point == Point.S1)
			return Point.South;
		else if (point == Point.S2)
			return Point.S1;
		else if (point == Point.S3)
			return Point.S2;
		else if (point == Point.S4)
			return Point.S3;
		else if (point == Point.South)
			return Point.W4;
		else if (point == Point.W1)
			return Point.West;
		else if (point == Point.W2)
			return Point.W1;
		else if (point == Point.W3)
			return Point.W2;
		else if (point == Point.W4)
			return Point.W3;
		else if (point == Point.West)
			return Point.N4;
		return Point.NOT_IN_GAME;
	}
}

//게임 보드판 위의 움직임을 보여주는 클래스입니다.