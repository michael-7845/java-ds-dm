package ds.linearlist;

import java.lang.reflect.Array;

public class ArrayLinearList<T> implements ILinearList<T> {
	
	private Class<T> type;
	public T[] data;
	public int length;
	public int maxsize;
	
	public ArrayLinearList(Class<T> type, int maxsize) {
		this.length = 0;
		this.maxsize = maxsize;
		this.type = type;
		data = (T[]) Array.newInstance(type, maxsize); 
		
		for(int i=0; i<this.maxsize; i++) {
			data[i] = null;
		}
	}

//	@Override
//	public void init() {
//	}

	@Override
	public boolean isEmpty() {
		if (this.length == 0)
			return true;
		return false;
	}

	@Override
	public void clean() {
		this.length = 0;
		for(int i=0; i<this.maxsize; i++) {
			this.data[i] = null;
		}
	}

	@Override
	public T getElem(int index) {
		if(index < this.maxsize)
			return this.data[index];
		return null;
	}

	@Override
	public int locateElem(T e) {
		for(int i=0; i<this.length; i++) {
			if(this.data[i] == e)
				return i;
		}
		return -1;
	}

	@Override
	public void insert(int index, T e) {
		if ((index < 0) || (index > this.length) || (this.length == this.maxsize)) {
			System.out.println("index error");
			return;
		} else if (index == this.length) {
			this.data[index] = e;
			this.length++;
		} else {
			for(int i=(this.length-1); i>=index; i--) {
				this.data[i+1] = this.data[i];
			}
			this.data[index] = e;
			this.length++;
		}
	}

	@Override
	public T delete(int index) {
		if((index<0) || (index > this.length)) {
			System.out.println("index error");
			return null;
		}
		T e = this.data[index];
		for(int i=index+1; i<this.length; i++) {
			this.data[i-1] = this.data[i];
		}
		this.length--;
		return e;
	}

	@Override
	public int length() {
		return this.length;
	}
	
	public void print() {
		for(int i=0; i<this.length; i++)
			System.out.println(this.data[i]);
	}
	
	public static void main(String[] args) {
		ArrayLinearList<Integer> all = new ArrayLinearList<Integer>(Integer.class, 7);
		all.print();
		
		all.insert(0, 1); // 1
		all.insert(1, 2); // 1, 2
		all.insert(1, 3); // 1, 3, 2
		all.insert(0, 4); // 4, 1, 3, 2
		all.insert(2, 5); // 4, 1, 5, 3, 2
		all.print();
		System.out.println(all.length);
		
		all.delete(2); // 4, 1, 3, 2
		System.out.println(all.length);
		all.delete(1); // 4, 3, 2
		all.print();
	}

}
