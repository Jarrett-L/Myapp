package com.web;

import java.util.Scanner;

import com.dao.Write;

public class main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������������Ŀ�ĸ�����");
		int e = sc.nextInt();
		System.out.println("������������Ŀ����ֵ��Χ��");
		int a = sc.nextInt();
		Server sv = new Server();
		
		String[] ans =sv.create(e, a);
		
		System.out.println("-------------------");
		System.out.println("��Ŀ������ɣ�������(0/1)");
		System.out.println("0.�˳�����");
		System.out.println("1.��ʼ����");
		System.out.println("-------------------");

		int c = sc.nextInt();
		switch(c) {
			case 0 :
				System.out.println("��ӭ�ٴ�ʹ�ã�");
				break;
			case 1 :
				String[] strarray3 = sv.respondence(e);
				System.out.println("-------------------");
				System.out.println("���������������(0/1)");
				System.out.println("0.�˳�����");
				System.out.println("1.���մ�");
				System.out.println("-------------------");
				int d = sc.nextInt();
				if(d==1) {
					String[] CW =sv.contrast(e, ans, strarray3);
					for(int i = 0;i<CW.length;i++) {
						System.out.println(CW[i]);
					}
				}else {
					System.out.println("��ӭ�ٴ�ʹ�ñ�����");
				}
				break;
			default:
				System.out.println("������󣬳����˳�");
				break;
		}
		
	}
}
