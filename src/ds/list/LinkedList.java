package ds.list;

import static kemin.util.Pr.*;

public class LinkedList implements iList<myNode> {

	public static void debugList() {
		LinkedList ll = new LinkedList();
		ll.init();
		
		println("======== 1 ========");
		ll.insert(0, new myNode(100));
		ll.show();
		println("======== 2 ========");
		ll.insert(1, new myNode(103));
		ll.show();
		println("======== 3 ========");
		ll.insert(2, new myNode(106));
		ll.show();
		println("======== 4 ========");
		println(ll.header.toString());
		println(ll.getElem(0).toString());
		println(ll.getElem(1).toString());
		println(ll.getElem(2).toString());
		println(ll.getElem(3).toString());
//		println(ll.getElem(4).toString());
		println("======== 5 ========");
//		ll.clear();
		ll.delete(0);
		ll.show();
		println("======== 6 ========");
		ll.delete(2);
		ll.show();
		println(ll.isEmpty());
		println(ll.length());
		println("======== 7 ========");
		ll.delete(1);
		ll.show();
		println(ll.isEmpty());
		println(ll.length());
		println("======== 8 ========");
		ll.delete(1);
		ll.show();
		println(ll.isEmpty());
		println(ll.length());
		println("======== 9 ========");
		ll.insert(0, new myNode(100));
		ll.insert(0, new myNode(101));
		ll.insert(0, new myNode(102));
		ll.insert(0, new myNode(103));
		ll.insert(0, new myNode(104));
		ll.show();
		println(ll.locateElem(106));
		println(ll.locateElem(103));
		println(ll.getElem(ll.locateElem(103)));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		debugList();
	}
	
	public myNode header;
	public int size;

	@Override
	public Status init() {
		this.header = new myNode();
		this.size = 0;
		return Status.OK;
	}

	@Override
	public myNode getElem(int n) {
		if(n>this.size)
			return null;
		myNode cur = this.header;
		int i = 0;
		while((cur.next != null) && (i<n)) {
			cur = cur.next;
			i++;
		}
		return cur;
	}

	@Override
	public Status insert(int n, myNode node) {
		if(n>this.size) return Status.Error;
		
		myNode cur = this.header;
		int i = 0;
		while((cur.next != null) && (i<n)) {
			cur = cur.next;
			i++;
		}
		
		node.next = cur.next;
		cur.next = node;
		this.size++;
		
		return Status.OK;
	}

	@Override
	public Status delete(int n) {
		if((n>this.size) || (n<1))
			return Status.Error;
		
		myNode cur = this.header;
		myNode pre = null;
		int i = 0;
		while((cur.next != null) && (i<n)) {
			pre = cur;
			cur = cur.next;
			i++;
		}
		pre.next = cur.next;
		this.size--;
		
		return Status.OK;
	}

	@Override
	public Status clear() {
		this.header.next = null;
		return Status.OK;
	}

	@Override
	public boolean isEmpty() {
		if(this.size == 0)
			return true;
		return false;
	}

	@Override
	public int length() {
		return this.size;
	}

	@Override
	public int locateElem(int value) {
		myNode cur = this.header;
		int i = 0;
		while(cur.next != null) {
			cur = cur.next;
			i++;
			if(cur.value == value) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void show() {
		myNode cur = this.header;
		while(cur.next != null) {
			cur = cur.next;
			println(cur.toString());
		}
	}

}

class myNode {
	public int value;
	public myNode next;
	public myNode() {
		this.value = 0;
		this.next = null;
	}
	public myNode(int value) {
		this.value = value;
		this.next = null;
	}
	public String toString() {
		if(this.next != null)
			return String.format("value: %d, next: %d", this.value, this.next.hashCode());
		else
			return String.format("value: %d, next: null", this.value);
	}
}