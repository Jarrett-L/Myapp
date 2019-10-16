package com.web;

import java.util.Scanner;

import com.dao.BTree;
import com.dao.Ran;
import com.dao.Write;

public class Server {
	
	public static String[] create(int e,int r){
		BTree bTree;
		Write write = new Write();
		//�����ظ�����ȥ����֤����һ����
		String[] strarray1 = new String[0];
		String[] strarray2 = new String[0];
		boolean flag ;
		for(int i = 0; i < e; i++){
			bTree = new BTree(Ran.getNumber2(2),r);
			bTree.createBTree();
			String result = bTree.CalAndVal();
			int I=i+1 ;
			strarray1=insert(strarray1,I+". "+bTree.toString()+ "=");
			strarray2=insert(strarray2,I+". "+result);
			
		}
		Write.createExercises(strarray1);
		Write.createAnswers(strarray2);
		for(int m = 0;m<strarray1.length;m++) {
		System.out.println(strarray1[m]);
		}
		return strarray2;
	}
	public static String[] respondence(int e) {
		Scanner sc = new Scanner(System.in);
		String[] strarray3 = new String[0];
		for(int i = 1 ;i<=e;i++) {
			System.out.print(i+". ");
			
			String answer = sc.next();
			System.out.print('\n');
			strarray3=insert(strarray3,i+". "+answer);
		}
		return strarray3;
	}
	public static String[] contrast(int e,String[]ans,String[]strarray3) {
		String[] CW =new String[0];
		int[]t=new int[0];
		int[]f=new int[0] ;
		for(int i=0;i<e;i++) {
			if(ans[i].equals(strarray3[i])) {
				t=insert2(t, i+1);
			}else {
				f=insert2(f, i+1);
			}
		}
		String Correct = "";
		Correct = "Correct:"+t.length+"(";
		for(int i = 0;i<t.length;i++) {
			if(i==0) {
				Correct=Correct+t[0];
			}else {
				Correct = Correct+","+t[i];
			}
		}
		Correct = Correct+")";
		CW=insert(CW, Correct);
		String Wrong = "";
		Wrong = "Wrong:"+f.length+"(";
		for(int i = 0;i<f.length;i++) {
			if(i==0) {
				Wrong=Wrong+f[0];
			}else {
				Wrong = Wrong+","+f[i];
			}
		}
		Wrong = Wrong+")";
		CW=insert(CW, Wrong);
		Write.createGrade(CW);
		return CW;
	}
	public static String[] insert(String[] arr, String str) {
		int size = arr.length;  //��ȡ���鳤��
		String[] tmp = new String[size + 1];  //�½���ʱ�ַ������飬��ԭ�������ϳ��ȼ�һ
		for (int i = 0; i < size; i++){  //�ȱ�����ԭ�����ַ�������������ӵ���ʱ�ַ�������
        tmp[i] = arr[i];
		}
		tmp[size] = str;  //������������Ҫ׷�ӵ�����
		return tmp;  //����ƴ����ɵ��ַ�������
	}
	public static int[] insert2(int[] arr, int value) {
		int size = arr.length;  //��ȡ���鳤��
		int[] tmp = new int[size + 1];  //�½���ʱint���飬��ԭ�������ϳ��ȼ�һ
		for (int i = 0; i < size; i++){  
        tmp[i] = arr[i];
		}
		tmp[size] = value;  //������������Ҫ׷�ӵ�����
		return tmp;  //����ƴ����ɵ��ַ�������
	}
}

