package com.web;

import java.util.Scanner;

import com.dao.BTree;
import com.dao.Ran;
import com.dao.Write;

public class Server {
	
	public static String[] create(int e,int r){
		BTree bTree;
		Write write = new Write();
		//若答案重复则舍去，保证了无一致性
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
		int size = arr.length;  //获取数组长度
		String[] tmp = new String[size + 1];  //新建临时字符串数组，在原来基础上长度加一
		for (int i = 0; i < size; i++){  //先遍历将原来的字符串数组数据添加到临时字符串数组
        tmp[i] = arr[i];
		}
		tmp[size] = str;  //在最后添加上需要追加的数据
		return tmp;  //返回拼接完成的字符串数组
	}
	public static int[] insert2(int[] arr, int value) {
		int size = arr.length;  //获取数组长度
		int[] tmp = new int[size + 1];  //新建临时int数组，在原来基础上长度加一
		for (int i = 0; i < size; i++){  
        tmp[i] = arr[i];
		}
		tmp[size] = value;  //在最后添加上需要追加的数据
		return tmp;  //返回拼接完成的字符串数组
	}
}

