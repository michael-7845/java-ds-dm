package ds.stack;

class Node<T> {
	T value;
	Node<T> next;
	
	public Node() {
		this.value = null;
		this.next = null;
	}
	
	public Node(T value) {
		this.value = value;
		this.next = null;
	}
}

public class LinkedStack<T> implements IStack<T> {
	
	public Node<T> top;
	public int length;
	
	public LinkedStack() {
		this.top = null;
		this.length = 0;
	}

	@Override
	public void init() {
		this.top = null;
		this.length = 0;
	}

	@Override
	public void clear() {
		this.top = null;
		this.length = 0;
	}

	@Override
	public boolean isEmpty() {
		if(this.top == null)
			return true;
		return false;
	}

	@Override
	public T getTop() {
		if(isEmpty()) {
			throw new StackException("stack empty");
		}
		return this.top.value;
	}

	@Override
	public OpStatus push(T e) throws StackException {
		Node<T> node = new Node<T>(e);
		node.next = this.top;
		this.top = node;
		this.length++;
		return OpStatus.OK;
	}

	@Override
	public T pop() throws StackException {
		if(isEmpty()) {
			throw new StackException("stack empty");
		}
		T value = this.top.value;
		this.top = this.top.next;
		this.length--;
		return value;
	}

	@Override
	public int length() {
		return this.length;
	}

}
