package com.dao;
//���������ķ�����
import java.util.Random;

public class Ran {
	/**
	 * ��ȡ����ķ���
	 * 
	 * @return operator
	 */
	
	public static char getOperator(){
		char operator = 0;
		Random ran = new Random();
		int i = ran.nextInt(4);
		switch(i){
			case 0:
				operator = '+';
				break;
			case 1:
				operator = '-';
				break;
			case 2:
				operator = '*';
				break;
			case 3:
				operator = '��';
				break;
		}
		return operator;
	}
	
	
	/**
	 * ��������ķ�Χ��ȡ�����
	 * 
	 * @param max
	 * @return number
	 */
	
	public static int getNumber(int max){
		int number = 0;
		Random ran = new Random();
		number = ran.nextInt(max+1);
		return number;
	}
	//��÷�0�������
	public static int getNumber2(int max){
		int number = 0;
		Random ran = new Random();
		number = ran.nextInt(max+1)+1;
		return number;
	}
	/**
	 * ����������ĸ�����������ӽڵ��λ��
	 * 
	 * @param num
	 * @return childPlace
	 */
	
	public static boolean[] getChildPlace(int num){
		int d = 0;
		int size = 0, j=1;
		while(num >= (int)Math.pow(2, j)){
			j++;
		}
		d = (int)Math.pow(2, j) - 1 - num;//û���ֵܽڵ��Ҷ�ӽڵ����
		size = (int)Math.pow(2, j-1);//�����ڶ�������нڵ���
		boolean[] k = new boolean[size];
		for(int i = 0; i < size; i++){
			k[i] = true;
		}
		//�����ӽڵ���Ŀ����d��û���ֵܽڵ��Ҷ�ӽڵ������λ�ñ��ΪFalse
		for(int i = 0; i < d; i++){
			Random ran = new Random();
			int f = ran.nextInt(size);
			while(k[f] == false)
			{
				f = ran.nextInt(size);
			}
			k[f] = false;
		}
		return k;
	}
}




