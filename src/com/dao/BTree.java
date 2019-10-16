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
	 * 获取最终的表达式，必须在CalAndVal()方法后调用
	 * 
	 * @return str
	 */
	public String toString(){
		String str = root.toString();
		str = str.substring(1, str.length()-1);
		return str;
	}
	
	/**
	 * 计算并验证表达式
	 * 
	 * @return result
	 */
	public String CalAndVal(){
		return root.getResult();
	}
	
	/**
	 * 计算二叉树的深度(层数) 
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
	 * 生成二叉树
	 * 
	 */
	public void createBTree(){
		TreeNode lchild, rchild, lnode, rnode;
		//先判断运算符个数，若为1，则只有一个根节点，两个子节点
		if(num == 1){
			lchild = new TreeNode(String.valueOf(Ran.getNumber(max)), null, null);
			rchild = new TreeNode(String.valueOf(Ran.getNumber(max)), null, null);
			root = new TreeNode(String.valueOf(Ran.getOperator()), lchild, rchild);
		}
		//否则进入多层树结构的创建
		else{
			//先添加最顶上的根节点
			int num1 = 0; 
			int n = getDeep() - 3;//除去root所在层以及最后两层
			boolean[] place = Ran.getChildPlace(num);
			root = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
			opeList.add(root);
			//遍历生成除了根节点，以及最后两层以外的其他层节点
			for(int i = 0; i < n; i++){
				for(int j = 0; j < (int)Math.pow(2, i); j++, num1++){
					lchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
					rchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
					opeList.get(j + num1).setChild(lchild, rchild);
					opeList.add(lchild);
					opeList.add(rchild);
				}
			}
			//对于倒数第二层节点的处理，若其标记为true，则该节点还有对应的叶子节点，若为False，则该节点为叶子节点
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


