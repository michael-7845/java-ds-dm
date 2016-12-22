package ds.list;

public class LinkedListGeneric2<T> {
	
	public int MAXSIZE;
	public T[] data;
	public int length;
	
	public LinkedListGeneric2(T[] data) {
		this.data = data;
		this.MAXSIZE = this.data.length;
		this.length = 0;
		
	}
	
	public Status init(T[] first) {
		if(first.length>this.MAXSIZE)
			return Status.Error;
		for(int i=0; i<first.length; i++) {
			this.data[i] = first[i];
		}
		this.length = first.length;
		return Status.OK;
	}
	
	public boolean isEmpty() {
		if(this.length==0)
			return true;
		else
			return false;
	}
	
	public Status clear() {
		this.length = 0;
		return Status.OK;
	}
	
	public T getElem(int i) {
		if((this.length==0) || (i<1) || (i>this.length))
			return null;
		return this.data[i-1];
	}
	
	public int locateElem(T e) {
		for(int i=0; i<this.length; i++) {
			if(this.data[i]==e)
				return i+1;
		}
		return -1;
	}
	
	public Status insert(int location, T e) {
		if(this.length==this.MAXSIZE)
			return Status.Full;
		if((location<1) || (location>this.length+1)) {
			return Status.Error;
		}
		if(location<=this.length) {
			for(int k=this.length-1; k>=location-1; k--) {
				this.data[k+1] = this.data[k];
			}
		}
		this.data[location-1] = e;
		this.length++;
		return Status.OK;
	}
	
	public Status delete(int location) {
		if(this.length==0)
			return Status.Empty;
		if((location<1) || (location>this.length))
			return Status.Error;
		if(location<this.length) {
			for(int k=location; k<this.length; k++) {
				this.data[k-1] = this.data[k];
			}
		}
		this.length--;
		return Status.OK;
	}
	
	public int length() {
		return this.length;
	}
	
	public void show() {
		for(int i=0; i<this.length; i++)
			System.out.print(this.data[i]+", ");
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListGeneric2<Integer> adt = new LinkedListGeneric2<Integer>(new Integer[20]);
		adt.init(new Integer[]{1, 2, 3, 4, 5, 6});
		adt.show();
		System.out.println(adt.isEmpty());
		System.out.println(adt.length());
		System.out.println(adt.getElem(3));
		adt.insert(3, 23);
		adt.show();
		System.out.println(adt.getElem(3));
		System.out.println(adt.locateElem(3));
		System.out.println(adt.locateElem(10));
		adt.delete(5);
		adt.show();
		adt.clear();
		adt.show();
		System.out.println(adt.isEmpty());
	}

}
