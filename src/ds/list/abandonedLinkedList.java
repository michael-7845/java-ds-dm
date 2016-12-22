package ds.list;

import static kemin.util.Pr.*;

public class abandonedLinkedList implements iList<Node> {
	
	public static void debugPool() {
		println("========== init. ==========");
		Pool p = new Pool();
		p.show();
		
		println("========== retrieve ==========");
		Node n1 = p.retrieve();
		n1.value = 100;
		n1.next = 1;
		Node n2 = p.retrieve();
		n2.value = 101;
		n2.next = 2;
		p.show();
		
		println("========== release ==========");
		p.release(n1);
		p.show();
		p.release(n2);
	}
	
	public static void main(String[] args) {
		debugPool();
	}

	Node header;
	Pool pool;
	int size;
	
	@Override
	public Status init() {
		this.header = new Node();
		this.size = 0;
		this.pool = new Pool();
		return Status.OK;
	}

	@Override
	public Node getElem(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status insert(int n, Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status delete(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status clear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int locateElem(int value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}

class Node {
	public int value;
	public int next;
	public Node() {
		this.value = 0;
		this.next = -1;
	}
	public Node(int value, int next) {
		this.value = value;
		this.next = next;
	}
	public String toString() {
		return String.format("value: %d, next: %d", this.value, this.next);
	}
}

class Pool {
	private int SIZE = 20;
	public Node[] nodes = new Node[SIZE];
	public Pool() {
		for(int i=0; i<SIZE; i++) {
			nodes[i] = new Node();
		}
	}
	public Node retrieve() {
		for(int i=0; i<SIZE; i++) {
			if(nodes[i].next == -1) {
				return nodes[i];
			}
		}
		return null;
	}
	public void release(Node n) {
		n.next = -1;
	}
	public void show() {
		for(int i=0; i<SIZE; i++) {
			System.out.println(i+", "+nodes[i]);
		}
	}
}
