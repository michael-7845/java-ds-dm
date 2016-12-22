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
 * ���������� (Binary Sort Tree)
 * ��������� (Binary Search Tree)
 * ����������
 * 
 * ����������������һ�ÿ����������Ǿ����������ʵĶ�������
 * ��1�������������գ��������������н���ֵ��С�����ĸ�����ֵ��
 * ��2�������������գ��������������н���ֵ���������ĸ�����ֵ��
 * ��3����������Ҳ�ֱ�Ϊ������������
 * ��4��û�м�ֵ��ȵĽ�㡣
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
