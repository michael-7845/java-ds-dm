package ds.stack;

import java.lang.reflect.Array;

public class ArrayStack<T> implements IStack<T> {

	public T[] data;
	public Class<T> type;
	public int maxsize;
	public int top;
	public int length;
	
	public ArrayStack(Class<T> type, int size) {
		this.maxsize = size;
		this.type = type;
		this.data = (T[]) Array.newInstance(type, size);
		this.top = -1; // no data
		this.length = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		this.data = (T[]) Array.newInstance(this.type, this.maxsize);
		this.top = -1; // no data
		this.length = 0;
	}

	@Override
	public void clear() {
		this.top = -1;
		this.length = 0;
	}

	@Override
	public boolean isEmpty() {
		if(this.top == -1)
			return true;
		return false;
	}

	@Override
	public T getTop() throws StackException {
		if(isEmpty()) {
			throw new StackException("stack empty");
		}
		return data[this.top];
	}

	@Override
	public OpStatus push(T e) throws StackException {
		if(this.top == (this.maxsize-1)) { // stack is full
			throw new StackException("stack full");
		}
		this.top++;
		this.data[top] = e;
		this.length++;
		return OpStatus.OK;
	}

	@Override
	public T pop() {
		if(this.top >=0) {
			T e = this.data[this.top];
			this.top--;
			this.length--;
			return e;
		}
		return null;
	}

	@Override
	public int length() {
		return this.length;
	}

}
