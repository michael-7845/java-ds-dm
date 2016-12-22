package ds.completebinarytree;

import static kemin.debug.M.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

//��ȫ������
//����ʹ����������ʾ�� ϸ�ڿ��Բο�ds.sort.HeapSort
//׼��������ҪΪ�˽��һЩ��������Ȥζ�⣬���㴴��������
public class CompleteBinaryTree {
	
	private static int left(int n) {
		return 2*n+1;
	}
	private static int right(int n) {
		return 2*(n+1);
	}
	private static int parent(int n) {
		return n/2;
	}
	
	public BTNode root;
	
	public CompleteBinaryTree() {
		this.root = null;
	}
	
	//ʹ�������ʾ����ʼ����ȫ������
	public CompleteBinaryTree(int[] array) {
		this();
		if(array.length<1) return;
		
		this.root = new BTNode(array[0]);
		List<BTNode> list = new ArrayList<BTNode>() {{
			add(0, root);
		}};
		for(int i=0; i<array.length; i++) {
			BTNode n = list.get(i), l = null, r = null;
			int left = CompleteBinaryTree.left(i), right = CompleteBinaryTree.right(i);
			
			if(left<array.length) {
				l = new BTNode(array[left]);
				n.lchild = l;
				list.add(left, l);
			}
			if(right<array.length) {
				r = new BTNode(array[right]);
				n.rchild = r;
				list.add(right, r);
			}
		}
	}
	
	public void preOrderVisit(BTNode n) {
		if(n == null) return;
		
		d(n.data + " ");
		preOrderVisit(n.lchild);
		preOrderVisit(n.rchild);
	}
	
	public void inOrderVisit(BTNode n)  {
		if(n != null) {
			inOrderVisit(n.lchild);
			d(n.data + " ");
			inOrderVisit(n.rchild);
		}
	}
	
	public void postOrderVisit(BTNode n)  {
		if(n != null) {
			postOrderVisit(n.lchild);
			postOrderVisit(n.rchild);
			d(n.data + " ");
		}
	}
	
	public void levelOrderVisit(BTNode n) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(n);
		while(queue.element() != null) {
			BTNode node = queue.remove();
			d(node.data + " ");
			queue.add(node.lchild);
			queue.add(node.rchild);
		}
	}
	
	public void nr_preOrderVisit(BTNode n) {
		Stack<BTNode> stack = new Stack<BTNode>();
		while((n!=null) || (!stack.isEmpty())) {
			while(n!=null) {
				d(n.data + " ");
				stack.push(n);
				n = n.lchild;
			}
			n = stack.pop().rchild;
		}
	}
	
	public void nr_inOrderVisit(BTNode n) {
		Stack<BTNode> stack = new Stack<BTNode>();
		while((n!=null) || (!stack.isEmpty())) {
			while(n!=null) {
				stack.push(n);
				n = n.lchild;
			}
			n = stack.pop();
			d(n.data + " ");
			n = n.rchild;
		}
	}
	
	public void nr_postOrderVisit(BTNode n) {
		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode preVisited = null;
		while((n!=null) || (!stack.isEmpty())) {
			while(n!=null) {
				stack.push(n);
				n = n.lchild;
			}
			n = stack.peek(); //�˴���û�н�ջ��Ԫ�ص�����ֻ��ȡ��Ϊ�ж��Ƿ���Է��ʴ˽ڵ���׼��
			
			//���ж��Ǻ����ǵݹ��㷨�Ĺؼ�����
			//���ʸ��ڵ�������ǣ� Ҫô�Һ���Ϊ�գ� Ҫô�Һ����Ѿ����ʹ�
			//������Һ��ӣ���ô���ʸ��ڵ�֮ǰ����һ���ڵ�Ӧ�����������ĸ��ڵ㣬 ��ͨ��ЩӦ�ò���������´���
			if((n.rchild==null) || (n.rchild==preVisited)) {
				n = stack.pop();
				d(n.data + " ");
				preVisited = n;
				n = null;
			} else {
				n = n.rchild;
			}
		}
	}

	public static void demo() {
		CompleteBinaryTree t = new CompleteBinaryTree(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
		p("preOrder");
		t.preOrderVisit(t.root);
		p("");
		p("inOrder");
		t.inOrderVisit(t.root);
		p("");
		p("postOrder");
		t.postOrderVisit(t.root);
		p("");
	}
	
	public static void demo2() {
		CompleteBinaryTree t = new CompleteBinaryTree(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
		p("levelOrder");
		t.levelOrderVisit(t.root);
		p("");
	}
	
	public static void demo3() {
		CompleteBinaryTree t = new CompleteBinaryTree(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
		p("preOrder");
		t.nr_preOrderVisit(t.root);
		p("");
		p("inOrder");
		t.nr_inOrderVisit(t.root);
		p("");
		p("postOrder");
		t.nr_postOrderVisit(t.root);
		p("");
	}
	
	public static void main(String... args) {
		demo();
		demo3();
	}
}
