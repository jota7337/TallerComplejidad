package co.edu.unbosque.model;

import java.util.Arrays;

public class Nutricionista {
	
	public String dp(int calories [], int calorie){
		if(sum(calories) < calorie) return "No se puede realizar el calculo.";
		Arrays.toString(calories);
		int nums [][] = new int [calories.length +1][calorie +1];
		StringBuilder chars [][] = new StringBuilder [nums.length][nums[0].length];
		for(int i = 1; i < nums[0].length; i++)
			nums[0][i] = Integer.MAX_VALUE;
		for(int i = 1, compare; i < nums.length; i++) {
			for(int j = 1; j < nums[i].length; j++) {
				StringBuilder builder = new StringBuilder();
				if(calories[i - 1] <= j) {
					compare = nums[i - 1][j - calories[i - 1]];
					builder.append(compare != 0? chars[i -1][j - calories[i -1]] : "");
					if(compare < Integer.MAX_VALUE) {
						builder.append(calories[i - 1]);
						compare += calories[i - 1];
					}
				}else {
					compare = calories[i - 1];
					builder.append(compare);
				}
				if(compare >= j) {
					if(nums[i -1][j] < compare) {
						builder.setLength(0);
						builder.append(chars[i - 1][j]);
					}
				}
				nums[i][j] = compare >= j? Math.min(nums[i - 1][j], compare) : Integer.MAX_VALUE;
				chars[i][j] = builder.compareTo(new StringBuilder(String.valueOf("2147483647"))) == 0? null : builder;
			}
		}
		String fin = chars[calories.length][calorie].toString();
		String caloriasOptimas = "Las calorias optimas son: " + nums[calories.length][calorie] + "\n";
		for(int i = 0; i < fin.length(); i++) 
			caloriasOptimas += "Plato " + ((char) (65 + i)) + " proteinas = " + (fin.charAt(i)) + "\n"; 
		return caloriasOptimas;
	}
	
	private int sum(int calorias []) {
		int sum = 0;
		for(int i = 0; i < calorias.length; i++)
			sum += calorias[i];
		return sum;
	}
}
