package ds.linearlist;



public class LinkedLinearList<T> implements ILinearList<T> {
	class Node<T> {
		T value;
		Node<T> next;
		public Node(T value) {
			this.value = value;
			this.next = null;
		}
		public Node() {
			this.value = null;
			this.next = null;
		}
	}
	
	public Node<T> head;
	public int length;
	
	public LinkedLinearList() {
		this.head = new Node<T>();
		this.length = 0;
	}

	@Override
	public boolean isEmpty() {
		if(this.head.next == null)
			return true;
		return false;
	}

	@Override
	public void clean() {
		this.head.next = null;
		this.length = 0;
	}

	@Override
	public T getElem(int index) {
		if((index<0) || (index>=this.length)) {
			System.out.println("index error");
			return null;
		}
		
		Node<T> cur = this.head;
		for(int i=0; i<index; i++) {
			cur = cur.next;
		}
		return cur.value;
	}

	@Override
	public int locateElem(T e) {
		Node<T> cur = this.head;
		for(int i=0; i<this.length; i++) {
			cur = cur.next;
			if(cur.value == e) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public void insert(int index, T e) {
		if((index<0) || (index>this.length)) {
			System.out.println("index error");
			return;
		}
		
		Node<T> cur = this.head;
		for(int i=0; i<index; i++) {
			cur = cur.next;
		}
		Node<T> element = new Node<T>(e);
		element.next = cur.next;
		cur.next = element;
		this.length++;
	}

	@Override
	public T delete(int index) {
		if((index<0) || (index>=this.length)) {
			System.out.println("index error");
			return null;
		}
		
		Node<T> cur = this.head;
		for(int i=0; i<index; i++) {
			cur = cur.next;
		}
		Node<T> post = cur.next;
		if(post == null) {
			cur.next = null;
		} else {
			cur.next = post.next;
		}
		this.length--;
		
		return cur.value;
	}

	@Override
	public int length() {
		return this.length;
	}
	
	public void print() {
		Node<T> cur = this.head;
		for(int i=0; i<this.length; i++) {
			cur = cur.next;
			System.out.println(cur.value);
		}
	}
	
	public static void main(String[] args) {
		LinkedLinearList<Integer> all = new LinkedLinearList<Integer>();
		all.print();
		
		all.insert(0, 1); // 1
		all.insert(1, 2); // 1, 2
		all.insert(1, 3); // 1, 3, 2
		all.insert(0, 4); // 4, 1, 3, 2
		all.insert(2, 5); // 4, 1, 5, 3, 2
		all.print();
		System.out.println("length: " + all.length);
		
		all.delete(2); // 4, 1, 3, 2
		all.print();
		System.out.println("length: " + all.length);
		all.delete(1); // 4, 3, 2
		all.delete(2); // 4, 3
		all.print();
	}

}
