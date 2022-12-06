package co.edu.unbosque.model;

import java.util.Arrays;

public class Nutricionista {
	
	public String dp(int calories [], int calorie){
		Arrays.toString(calories);
		int nums [][] = new int [calories.length +1][calorie +1];
		StringBuilder chars [][] = new StringBuilder [nums.length][nums[0].length];
		String values [] = values(calories.length);
		System.out.println(Arrays.toString(values));
		for(int i = 1; i < nums[0].length; i++)
			nums[0][i] = Integer.MAX_VALUE;
		for(int i = 1, compare; i < nums.length; i++) {
			for(int j = 1; j < nums[i].length; j++) {
				StringBuilder builder = new StringBuilder();
				if(calories[i - 1] <= j) {
					compare = nums[i - 1][j - calories[i - 1]];
					if(i == nums.length -1 && j == nums[i].length -1)
						System.out.println("i = " + i + ", j = " + j + ", compare = " + compare);
					
					builder.append(compare != 0? nose(values, calories, compare) : "");
					if(compare < Integer.MAX_VALUE) {
						builder.append(nose(values, calories, calories[i -1]));
						compare += calories[i - 1];
					}
				}else {
					compare = calories[i - 1];
					builder.append(nose(values, calories, compare));
				}
				if(compare >= j) {
					if(nums[i -1][j] < compare) {
						builder.setLength(0);
						String value = nose(values, calories, nums[i - 1][j]);
						builder.append(value == ""? chars[i - 1][j] : value);
					}
				}
				nums[i][j] = compare >= j? Math.min(nums[i - 1][j], compare) : Integer.MAX_VALUE;
				chars[i][j] = builder.compareTo(new StringBuilder(String.valueOf("2147483647"))) == 0? null : builder;
			}
		}
		
		for(int i = 0; i < chars.length; i++)
			System.out.println(Arrays.toString(chars[i]));
		
		
		System.out.println(nums[calories.length][calorie]);
		return chars[calories.length][calorie].toString();
	}

	public String nose(String letter [], int calories [], int value) {
		for(int i = 0; i < calories.length; i++)
			if(calories[i] == value) 
				return letter[i];
		return "";
	}
	
	private String [] values(int length) {
		String chars [] = new String [length];
		for(int i = 0; i < chars.length; i++)
			chars[i] = String.valueOf((char)(65 + i));
		return chars;
	}
	
	public static void main(String[] args) {
		Nutricionista nutrionista =new Nutricionista();
		System.out.println(nutrionista.dp(new int[] {2,3,5,7,9}, 20));
	}
	
	
}
