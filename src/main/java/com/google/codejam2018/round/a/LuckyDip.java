package com.google.codejam2018.round.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class LuckyDip {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("/home/nasingh/workspace/codejam2018/src/main/java/com/google/codejam2018/round/a/luckydip-input.in"));
			
			int t = input.nextInt();
			for(int i = 1; i <= t; i++ )
			{
				int n = input.nextInt();
				int k = input.nextInt();
				TreeSet<Integer> vi = new TreeSet<Integer>();
				for(int j = 0; j< n; j++)
				{
					vi.add(input.nextInt());
				}				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
