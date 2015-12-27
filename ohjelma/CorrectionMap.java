public class CorrectionMap {

//	private int [][] map =
//	{ 
//			{-400,-400,-400,-400,-200,-100, -64, -36, -16,  -4,   0},	
//			{-400,-400,-400,-200,-100, -64, -36, -16,  -4,   0,   4},
//			{-400,-400,-200,-100, -64, -36, -16,  -4,   0,   4,  16},
//			{-400,-200,-100, -64, -36, -16,  -4,   0,   4,  16,  36},
//			{-200,-100, -64, -36, -16,  -4,   0,   4,  16,  36,  64},
//			{-100, -64, -36, -16,  -4,   0,   4,  16,  36,  64, 100},
//			{ -64, -36, -16,  -4,   0,   4,  16,  36,  64, 100, 200},
//			{ -36, -16,  -4,   0,   4,  16,  36,  64, 100, 200, 400},
//			{ -16,  -4,   0,   4,  16,  36,  64, 100, 200, 400, 400},
//			{  -4,   0,   4,  16,  36,  64, 100, 200, 400, 400, 400},
//			{   0,   4,  16,  36,  64, 100, 200, 400, 400, 400, 400}
//	};
	
	private int[][] map;
	private int size;
	//private HashTable speedMap;
	private int[] angleMap;
	private int[] speedMap;
	
	public CorrectionMap()
	{
		size = 21;
		double scaleC = 0.0022;
		double scaleX = 3.0;
		map = makeMap(scaleC, scaleX, size);
		angleMap = makeAngleMap();
		speedMap = makeSpeedMap();
		
		
	}
	public int[] makeAngleMap()
	{
		int[] returnValue = new int[201];
		
		for	(int i = 0; i < 201; i++)
		{
			returnValue[i] = getAngleIndex(i-100);
		}
		
		return returnValue;
	}
	
	public int[] makeSpeedMap()
	{
		int[] returnValue = new int[201];
		
		for (int i = 0; i< 201; i++)
		{
			returnValue[i] = getSpeedIndex(i-100);
		}
		
		return returnValue;
		
	}
	
	
	public int[][] makeMap(double scaleC, double scaleX, int size)
	{
		int[][] returnValue = new int[size][size];
		
		int center = size / 2;
		
		for (int i=0; i < size; i++)
		{
			for(int j=0; j<size; j++)
			{
				int x = ((j-center)*5)+i*5-center*5;
				returnValue[i][j] = (int)(scaleC*x*x*x+scaleX*x);
			}
		}
		
		
		return returnValue;
		
	}
	
	public void printf()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public void printAngleMap()
	{
		System.out.println("angle map:");
		for(int i = 0; i<201; i++)
		{
			System.out.println(i+" : "+angleMap[i]);
		}
	}
	public void printSpeedMap()
	{
		System.out.println("speed map:");
		for(int i = 0; i<201; i++)
		{
			System.out.println(i+" : "+speedMap[i]);
		}
	}
	
	
	public int getAngleIndex(int angle)
	{
		int angle_index = 0;
		
		if (angle > -90 && angle < -81) 		angle_index = 20;
		else if (angle >= -81 && angle < -64) 	angle_index = 19;
		else if (angle >= -64 && angle < -49) 	angle_index = 18;
		else if (angle >= -49 && angle < -36) 	angle_index = 17;
		else if (angle >= -36 && angle < -25) 	angle_index = 16;
		else if (angle >= -25 && angle < -16) 	angle_index = 15;
		else if (angle >= -16 && angle < -9) 	angle_index = 14;
		else if (angle >= -9 && angle < -4) 	angle_index = 13;
		else if (angle >= -4 && angle < -1) 	angle_index = 12;
		else if (angle >= -1 && angle < 0) 		angle_index = 11;
		else if (angle == 0) 					angle_index = 10;
		else if (angle <= 1 && angle > 0) 		angle_index = 9;
		else if (angle <= 4 && angle > 1) 		angle_index = 8;
		else if (angle <= 9 && angle > 4) 		angle_index = 7;
		else if (angle <= 16 && angle > 9) 		angle_index = 6;
		else if (angle <= 25 && angle > 16) 	angle_index = 5;
		else if (angle <= 36 && angle > 25) 	angle_index = 4;
		else if (angle <= 49 && angle > 36) 	angle_index = 3;
		else if (angle <= 64 && angle > 49) 	angle_index = 2;
		else if (angle <= 81 && angle > 64) 	angle_index = 1;
		else if (angle <= 90 && angle > 81) 	angle_index = 0;
		else angle_index = 10;
		
		return angle_index;
	}
	
	public int getSpeedIndex(int speed)
	{
		int speed_index = 0;
		
		if (speed < 90 && speed > 81)		speed_index = 0;
		else if (speed <= 81 && speed > 64)     speed_index = 1;
		else if (speed <= 64 && speed > 49)     speed_index = 2;
		else if (speed <= 49 && speed > 36)     speed_index = 3;
		else if (speed <= 36 && speed > 25) 	speed_index = 4;
		else if (speed <= 25 && speed > 16) 	speed_index = 5;
		else if (speed <= 16 && speed > 9 )		speed_index = 6;
		else if (speed <= 9 && speed > 4)    	speed_index = 7;
		else if (speed <= 4 && speed > 1)   	speed_index = 8;
		else if (speed <= 1 && speed > 0)   	speed_index = 9;
		else if (speed == 0 )					speed_index = 10;
		else if (speed >= -1 && speed < 0)     	speed_index = 11;
		else if (speed >= -4 && speed < -1)     speed_index = 12;
		else if (speed >= -9 && speed < -4)     speed_index = 13;
		else if (speed >= -16 && speed < -9) 	speed_index = 14;
		else if (speed >= -25 && speed < -16)	speed_index = 15;
		else if (speed >= -36 && speed < -25)	speed_index = 16;
		else if (speed >= -49 && speed < -36)   speed_index = 17;
		else if (speed >= -64 && speed < -49)   speed_index = 18;
		else if (speed >= -81 && speed < -64)   speed_index = 19;
		else if (speed >= -90 && speed < -81 )	speed_index = 20;
		else speed_index = 10;
		
		return speed_index;
	}
	
	public int getMotorSpeed(int angle, int speed)
	{
		if (speed > -99 && speed < 99 && angle > -99 && angle < 99)
		{
			
		
		
			int speed_index = speedMap[speed+100];
			int angle_index = angleMap[angle+100];
		
			return map[speed_index][angle_index];
		}
		else return 0;
	}
	
	
	
}
