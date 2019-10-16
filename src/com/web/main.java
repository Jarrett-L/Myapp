package com.web;

import java.util.Scanner;

import com.dao.Write;

public class main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入生成题目的个数：");
		int e = sc.nextInt();
		System.out.println("请输入生成题目的数值范围：");
		int a = sc.nextInt();
		Server sv = new Server();
		
		String[] ans =sv.create(e, a);
		
		System.out.println("-------------------");
		System.out.println("题目生成完成，请输入(0/1)");
		System.out.println("0.退出程序");
		System.out.println("1.开始答题");
		System.out.println("-------------------");

		int c = sc.nextInt();
		switch(c) {
			case 0 :
				System.out.println("欢迎再次使用！");
				break;
			case 1 :
				String[] strarray3 = sv.respondence(e);
				System.out.println("-------------------");
				System.out.println("作答结束，请输入(0/1)");
				System.out.println("0.退出程序");
				System.out.println("1.对照答案");
				System.out.println("-------------------");
				int d = sc.nextInt();
				if(d==1) {
					String[] CW =sv.contrast(e, ans, strarray3);
					for(int i = 0;i<CW.length;i++) {
						System.out.println(CW[i]);
					}
				}else {
					System.out.println("欢迎再次使用本程序！");
				}
				break;
			default:
				System.out.println("输入错误，程序退出");
				break;
		}
		
	}
}
