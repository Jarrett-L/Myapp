package com.dao;

import java.util.ArrayList;

public class BTree {
	private TreeNode root;
	private int num;
	private int max;
	private ArrayList<TreeNode> opeList = new ArrayList<TreeNode>();
	
	public BTree(int num,int max){
		this.num = num;
		this.max = max;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public void setTreeNode(TreeNode root){
		this.root = root;
	}
	
	
	/**
	 * ��ȡ���յı��ʽ��������CalAndVal()���������
	 * 
	 * @return str
	 */
	public String toString(){
		String str = root.toString();
		str = str.substring(1, str.length()-1);
		return str;
	}
	
	/**
	 * ���㲢��֤���ʽ
	 * 
	 * @return result
	 */
	public String CalAndVal(){
		return root.getResult();
	}
	
	/**
	 * ��������������(����) 
	 * 
	 * @return deep
	 */
	public int getDeep(){
		int i = this.num;
		int deep = 2;
		while(i/2 > 0){
			deep++;
			i /= 2;
		}
		return deep;
	}
	
	/**
	 * ���ɶ�����
	 * 
	 */
	public void createBTree(){
		TreeNode lchild, rchild, lnode, rnode;
		//���ж��������������Ϊ1����ֻ��һ�����ڵ㣬�����ӽڵ�
		if(num == 1){
			lchild = new TreeNode(String.valueOf(Ran.getNumber(max)), null, null);
			rchild = new TreeNode(String.valueOf(Ran.getNumber(max)), null, null);
			root = new TreeNode(String.valueOf(Ran.getOperator()), lchild, rchild);
		}
		//������������ṹ�Ĵ���
		else{
			//�������ϵĸ��ڵ�
			int num1 = 0; 
			int n = getDeep() - 3;//��ȥroot���ڲ��Լ��������
			boolean[] place = Ran.getChildPlace(num);
			root = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
			opeList.add(root);
			//�������ɳ��˸��ڵ㣬�Լ�������������������ڵ�
			for(int i = 0; i < n; i++){
				for(int j = 0; j < (int)Math.pow(2, i); j++, num1++){
					lchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
					rchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
					opeList.get(j + num1).setChild(lchild, rchild);
					opeList.add(lchild);
					opeList.add(rchild);
				}
			}
			//���ڵ����ڶ���ڵ�Ĵ���������Ϊtrue����ýڵ㻹�ж�Ӧ��Ҷ�ӽڵ㣬��ΪFalse����ýڵ�ΪҶ�ӽڵ�
			for(int i = 0; i < place.length; i++){
				if(place[i]){
					lnode  = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
					rnode  = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
					if(i%2 == 0){
						lchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);
						opeList.add(lchild);
						opeList.get(num1).setLchild(lchild);
					}
					else{
						rchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);
						opeList.add(rchild);
						opeList.get(num1).setRchild(rchild);
					}
				}
				else{
					if(i%2 == 0){
						lchild = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
						opeList.get(num1).setLchild(lchild);
					}
					else{
						
						rchild = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
						opeList.get(num1).setRchild(rchild);
					}
				}
				num1 = num1 + i%2;
			}
		}
	}
}


