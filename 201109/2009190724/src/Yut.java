
public class Yut {
	public static YutResult Throw()
	{
		int[] y = new int[4];
		int count = 0;
		
		for (int i=0;i<4;i++)
		{
			if (Math.random() > 0.35)
			{
				y[i] = 1;
				count++;
			}
			else
			{
				y[i] = 0;
			}
		}
		
		if (count == 1)
		{
			if (y[1] == 1)
			return YutResult.BbackDo;
		}
		
		switch(count)
		{
		case 0:
			return YutResult.Mo;
			
		case 1:
			return YutResult.Do;
			
		case 2:
			return YutResult.Gae;
			
		case 3:
			return YutResult.Girl;
			
		case 4:
			return YutResult.Yut;
		}
		
		return YutResult.Do;
	}
}  

// 결과값이 나오는 경우를 정의함.
