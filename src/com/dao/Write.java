package com.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class Write {
	
	public static void createExercises(String[] s) {
			try {
				File file = new File("E:\\JavaProject\\Myapp\\Exercises.txt");
				OutputStream out = new FileOutputStream(file,true);
				for(int i = 0; i<s.length;i++) {
					out.write(s[i].getBytes());
					out.write('\r');
					out.write('\n');
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	public static void createAnswers(String[] s) {
		try {
			File file = new File("E:\\JavaProject\\Myapp\\Answers.txt");
			OutputStream out = new FileOutputStream(file,true);
			for(int i = 0; i<s.length;i++) {
				out.write(s[i].getBytes());
				out.write('\r');
				out.write('\n');
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void createGrade(String[] s) {
		try {
			File file = new File("E:\\JavaProject\\Myapp\\Grade.txt");
			OutputStream out = new FileOutputStream(file,true);
			for(int i = 0; i<s.length;i++) {
				out.write(s[i].getBytes());
				out.write('\r');
				out.write('\n');
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
