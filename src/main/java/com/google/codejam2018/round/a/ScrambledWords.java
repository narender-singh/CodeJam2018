//package com.google.codejam2018.round.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ScrambledWords {

	public static void main(String... args) {
		try {
			Scanner input = new Scanner(new File(
					"/home/nasingh/workspace/codejam2018/src/main/java/com/google/codejam2018/round/a/scrambledwords-input.in"));
			int t = input.nextInt();
			for (int i = 1; i <= t; i++) {
				Map<String, Boolean> dict = new HashMap<String, Boolean>();
				int dictCount = input.nextInt();
				for (int j = 0; j < dictCount; j++)
					dict.put(input.next(), false);
				char i2 = input.next().charAt(0);
				char i1 = input.next().charAt(0);
				int num = input.nextInt();
				int a = input.nextInt();
				int b = input.nextInt();
				int c = input.nextInt();
				int d = input.nextInt();
				String article = generateString(num, i1, i2, a, b, c, d);
				//System.out.println(article);
				int count = findWordCount(num, article, dict);
				System.out.println("Case #" + i + ": " + count);
			}
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int findWordCount(int n, String article, Map<String, Boolean> dict) {
		int count = 0;
		for (int i = 0; i < n;) {
			int moveBy = 1;
			for (String s : dict.keySet()) {
				if (i + s.length() - 1 < n && ((Character) s.charAt(0)).equals(article.charAt(i))
						&& ((Character) s.charAt(s.length() - 1)).equals(article.charAt(i + s.length() - 1))
						&& !dict.get(s)) {
				/*	 System.out.println("Verifying Word : " + s + " " +
					 article.substring(i, i + s.length()) + " "
					 + article.substring(i + 1, i + s.length() - 1) + " " +
					 s.substring(1, s.length() - 1));*/
					if (verifyWord(article.substring(i + 1, i + s.length() - 1), s.substring(1, s.length() - 1))) {
						//moveBy = s.length();
						dict.put(s, true);				
					}
				}
			}
			i += moveBy;
		}
		for (Entry<String, Boolean> i : dict.entrySet()) {
			if (i.getValue())
				count++;
		}
		return count;
	}

	private static boolean verifyWord(String substring, String actualString) {

		// System.out.println("Verifying Word");
		String findString = substring;
		List<Character> charList = actualString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		for (Character ch : charList) {
			boolean found = false;
			for (int i = 0; i < substring.length(); i++)
				if (ch.equals(substring.charAt(i))) {
					found = true;
					break;
				}
			if (!found)
				return found;
			substring = substring.replaceFirst(ch.toString(), "");
		}
		//System.out.println(findString + "  " + actualString + " " + substring ); 
		return true;
	}

	private static String generateString(int n, char i1, char i2, int a, int b, int c, int d) {
		StringBuilder finalString = new StringBuilder();
		finalString.append(i2).append(i1);
		
		long i1ascii = (int) i1;
		long i2ascii = (int) i2;
		for (int i = 2; i < n; i++) {
			long next = ((a * i1ascii) + (b * i2ascii) + c) % d;			
			char actualNext = (char) (97 + next % 26);
		//	System.out.println(i1ascii + " " + i2ascii + " " + actualNext );
			i2ascii = i1ascii;
			i1ascii = next;
			finalString.append(actualNext);
		}
		System.out.println(finalString.toString());
		return finalString.toString();
	}

}
