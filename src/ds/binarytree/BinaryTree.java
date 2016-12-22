package ds.binarytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

import ds.queue.Queue;
import ds.stack.Stack;

import static kemin.util.Pr.*;

/**
 * �������Ķ��壺��Ϊ�գ���ֻ�и��ڵ㣬��������������������5�ֻ�����̬��
 * ���������ʣ�
 * 1���ڶ������ĵ�i����������2^(i-1)����㣨i>=1��
 * 2�����Ϊk�Ķ�����������2^(k) - 1����㣨k>=1��
 * 3�������κ�һ�Ŷ�������������ն˽����Ϊn������Ϊ2�Ľ����Ϊm����n = m + 1
 * 4������n��������ȫ�����������Ϊk = floor(log2(n)) + 1
 * 5���ں���n�����Ķ�����������n+1��������
 */

public class BinaryTree<T> {
	
	/**�������ĸ��ڵ�*/
	public Node<T> root;
	
	public BinaryTree(){}
	public BinaryTree(Node<T> root){
		this.root = root;
	}
  
	/**�����������������*/
	/**input.txt: - + a # # * # # / e # # f # #
	 * # ����ս��
	 */
	public void createBiTree(){
		Scanner scn = null;
    
		try {
			scn = new Scanner(new File("files/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    
		this.root = createBiTree(root, scn);
	}
	
	private Node<T> createBiTree(Node<T> node, Scanner scn) {
		String temp = scn.next();
		if(temp.trim().equals("#")){
			return null;
		}
		else{
			node = new Node<T>((T)temp);
			node.setLeft(createBiTree(node.getLeft(), scn));
			node.setRight(createBiTree(node.getRight(), scn));
			return node;
		}
	}
  
	/**����ݹ����������*/
	public void preOrderTraverse(){
		preOrderTraverse(root);
	}
  
	private void preOrderTraverse(Node<T> node) {
		if(node != null){
			System.out.println(node.getValue());
			preOrderTraverse(node.getLeft());
			preOrderTraverse(node.getRight());
		}
	}
  
  
	/**����ǵݹ����������*/
	public void nrPreOrderTraverse(){
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				System.out.println(node.getValue());
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.pop();
			node = node.getRight();
		}
	}
  
	/**����ݹ����������*/
	public void inOrderTraverse(){
		inOrderTraverse(root);
	}
	
	private void inOrderTraverse(Node<T> node) {
		if(node != null){
			inOrderTraverse(node.getLeft());
			System.out.println(node.getValue());
			inOrderTraverse(node.getRight());
		}
	}
  
	/**����ǵݹ����������*/
	public void nrInOrderTraverse(){
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.pop();
			System.out.println(node.getValue());
			node = node.getRight();
		}
	}
  
	/**����ݹ����������*/
	public void postOrderTraverse(){
		postOrderTraverse(root);
	}
	private void postOrderTraverse(Node<T> node) {
		if(node != null){
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			System.out.println(node.getValue());
		}
 	}
  
	/**����ǵݹ����������*/
	public void nrPostOrderTraverse(){
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		Node<T> preNode = null;	//��¼֮ǰ�������ҽ��
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.getTop();
      
			/**����ҽ��Ϊ�գ������ҽ��֮ǰ����������ӡ�����*/
			if(node.getRight() == null || node.getRight() == preNode){
				System.out.println(node.getValue());
				node = stack.pop();
				preNode = node;
				node = null;
			}else{
				node = node.getRight();
			}
		}
	}
  
  
  /**��α���������*/
  public void levelTraverse(){
    levelTraverse(root);
  }
  
  private void levelTraverse(Node<T> node) {
    Queue<Node<T>> queue = new Queue<Node<T>>();
    queue.push(node);
    while(!queue.isEmpty()){
      node = queue.pop();
      if(node != null){
        System.out.println(node.getValue());
        queue.push(node.getLeft());
        queue.push(node.getRight());
      }
    }
  }
  
  /*
   ***************************************
   */
  public void myPreorder() {
	  myPreorder(this.root);
  }
  public void myPreorder(Node<T> node) {
	  if(node != null) {
		  print(node.getValue());
		  myPreorder(node.getLeft());
		  myPreorder(node.getRight());
	  }
  }
  
  public void myInorder() {
	  myInorder(this.root);
  }
  public void myInorder(Node<T> node) {
	  if(node != null) {
		  myInorder(node.getLeft());
		  print(node.getValue());
		  myInorder(node.getRight());
	  }
  }
  
  public void myPostorder() {
	  myPostorder(this.root);
  }
  public void myPostorder(Node<T> node) {
	  if(node != null) {
		  myPostorder(node.getLeft());
		  myPostorder(node.getRight());
		  print(node.getValue());
	  }
  }
  
  public void myLevel() {
	  myLevel(this.root);
  }
  public void myLevel(Node<T> node) {
	  ArrayDeque<Node<T>> queue = new ArrayDeque<Node<T>>();
	  queue.add(node);
	  while(!queue.isEmpty()) {
		  node = queue.poll();
		  if(node != null) {
			  println(node.getValue());
			  Node<T> left = node.getLeft();
			  Node<T> right = node.getRight();
			  if(left != null) {
				  queue.add(left);
			  }
			  if(right != null) {
				  queue.add(right);
			  }
		  }
		  
	  }
  }
  
  public static void main(String[] args){
    BinaryTree<String> bt = new BinaryTree<String>();
    bt.createBiTree();
//    bt.preOrderTraverse();
//    bt.inOrderTraverse();
//    bt.postOrderTraverse();
//    bt.nrPreOrderTraverse();
//    bt.nrInOrderTraverse();
//    bt.nrPostOrderTraverse();
//    bt.levelTraverse();
//    bt.myPreorder();
    bt.myInorder();
//    bt.myPostorder();
//    bt.myLevel();
  }
}
