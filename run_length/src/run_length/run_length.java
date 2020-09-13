package run_length;

public class run_length {
	public static void print_current_code(char code, int count)
	{
		//swich¹®
		
		if(count == 0) {
			System.out.println("Encoding Error!");
			System.exit(0);
		}
		
		
		switch(code)
		{
			case 'W':
				if(count == 1)
					System.out.printf("W");
				else
					System.out.printf("%dW",count);
				break;
			case 'B':
				if(count == 1)
					System.out.printf("B");
				else
					System.out.printf("%dB",count);
				break;
			
		}
	
	}
	
	public static void run_length_encoding(String screen)
	{
		//for¹®
		int count = 0;
		int len = screen.length()-1;
		for(int i = 0; i < len ; i++ )
		{
			char currentCode = screen.charAt(i);
			char nextCode = screen.charAt(i+1);
			
			if(currentCode != nextCode)
			{
				if(i+1 == len)
				{
					count++;
					print_current_code(currentCode,count);
					print_current_code(nextCode,1);
				}
				
				else
				{
					count++;
					print_current_code(currentCode, count);
					count = 0;
				}
	
			}
			
			else
			{
				if(i+1 == len)
				{
					count += 2;
					print_current_code(currentCode, count);
					count = 0;
				}
				
				else
				{
					count++;
				}
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args)
	{
		String screen = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
		System.out.println("Run-length encoding(RLE) Test");
		System.out.println("input data: " + screen);
		
		System.out.println("Encoding result: ");
		run_length_encoding(screen);
	}
}
