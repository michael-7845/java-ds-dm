package ds.bst;

class Node {
	public int value;
	public Node lchild;
	public Node rchild;
	
	public Node() {
		this.lchild = null;
		this.rchild = null;
		this.value = 0;
	}
	public Node(int value) {
		this();
		this.value = value;
	}
	public String toString() {
		return String.format("value:%d,lchild:%s,rchild:%s", this.value, this.lchild, this.rchild);
	}
}

/*
 * 二叉排序树 (Binary Sort Tree)
 * 二叉查找树 (Binary Search Tree)
 * 二叉搜索树
 * 
 * 二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
 * （1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * （2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * （3）左、右子树也分别为二叉排序树；
 * （4）没有键值相等的结点。
 */
public class BinarySortTree {
	
	public static Node search(Node node, int key, Node last) {
		if(node == null) {
			return last;
		} else if(node.value == key) {
			return node;
		} else if(key<node.value) {
			return search(node.lchild, key, node);
		} else {
			return search(node.rchild, key, node);
		}
	}
	
	public static Node insert(Node node, int key) {
		Node result = search(node, key, null);
		if(result.value != key) {
			Node nd = new Node(key);
			if(key<result.value) {
				result.lchild = nd;
			} else {
				result.rchild = nd;
			}
			return nd;
		} else {
			return null;
		}
	}
	
	public static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.lchild);
		System.out.println(root.value);
		inOrder(root.rchild);
	}

	public static void demo() {
		Node n = new Node(25);
		insert(n, 12);
		insert(n, 8);
		insert(n, 36);
		inOrder(n);
		
		System.out.println(search(n, 10, null));
	}
	
	public static void demo2() {
		Node n = new Node(3);
		int[] array = {3,2,1,4,5,6,7,8,10,9};
		for(int i=0;i<array.length;i++) {
			insert(n, array[i]);
		}
		inOrder(n);
	}
	
	public static void main(String[] args) {
		demo2();
	}

}
