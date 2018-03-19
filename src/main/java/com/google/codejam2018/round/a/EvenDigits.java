package com.google.codejam2018.round.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EvenDigits {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("/home/nasingh/workspace/codejam2018/src/main/java/com/google/codejam2018/round/a/evendigits-input.in"));
			int t = input.nextInt();
			for(int i = 1; i <= t; i++ )
			{
				long num = input.nextLong();
				long lower = num - CalculateLower(num);
				long upper = CalculateUpper(num) - num;
				System.out.println("Case #" + i + ": " + (lower > upper ? upper : lower));
			}
			
			
			
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} 
	}

	private static long CalculateUpper(long n) {		
		while(isAnyOdd(n))
		{			
			n++;
		}
		return n;
	}	
	
	private static boolean isAnyOdd(long n) {
		boolean anyOdd = false;
		while (n > 0) {
		    long currDigit =  n % 10;
		    if(currDigit % 2 != 0)
		    {
		    	anyOdd = true;
		    	break;
		    }
		    n = n / 10;
		}
		return anyOdd;
	}

	private static long CalculateLower(long n) {
		while(isAnyOdd(n))
		{			
			n--;
		}
		return n;		
	}
}
