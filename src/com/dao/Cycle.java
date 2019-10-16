package com.dao;

import java.math.BigDecimal;

public class Cycle {
	private static final int LENGTH = 4;//保留小数位数
	/**
	 * 无限循环小数的循环体
	 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { int d = 1; int limit = 1000;
	 * BigDecimal demical = new BigDecimal("1"); int maxCycle = 0;
	 * 
	 * 
	 * for(int i=500; i <= limit; i++){
	 * 
	 * int cycle = getCycle(demical, i); if(cycle > maxCycle){ d = i; maxCycle =
	 * cycle; }else if (cycle < 0){
	 * System.out.println("循环体长度的两倍超出保留的小数位数，请扩展保留的小数位数。d = " + (0 - cycle)); }
	 * 
	 * } System.out.println("maxCycle =" + maxCycle + "; " + "d= " + d); //
	 * System.out.println("d = 499"); getCycle(demical, d); //
	 * System.out.println("d = 743"); // getCycle(demical, 743); }
	 */
 
	private static int[] getCycle(BigDecimal demical, int divisor) {
		int cycle = 0;
		int cycletmp = 0;
		int start = 0;
		int[] value = new int[2];
		String cyclePart = "";
		String cyclePartTmp = "";
		BigDecimal small = demical.divide(BigDecimal.valueOf(divisor), LENGTH, BigDecimal.ROUND_DOWN);
		String digits = small.toString().substring(2);//取小数部分
//		System.out.println(digits);
		for(int i=0; i<digits.length(); i++){
			for(int j=i, k = 1; k<(digits.length()-i) / 2; k++){
				if(digits.substring(j, j + k).equals(digits.substring(j + k , j + 2 * k ))){
					cycletmp = k;
					cyclePartTmp = digits.substring(j, j + k);
					break; 
				}
			}
			if(cycletmp > cycle){
				cycle = cycletmp ;
				cyclePart = cyclePartTmp;
				start = i;
			}
			cyclePartTmp = "";
			cycletmp = 0;
			
		}
		///System.out.println(small.toString() );
		//System.out.println(small.toString().substring(0, start+2) + "(" + cyclePart + ")");
		//System.out.println("cyclePartLength: " + cycle + "; start: " + start);
		if(cycle == 0){
			value[0]=(0 - divisor);//循环体长度的两倍超出保留的小数位数。
		}else {
			value[0]=cycle;
		}
		value[1]= start;
		return value;
	}
}
