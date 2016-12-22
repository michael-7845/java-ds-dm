package kemin.holder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static kemin.debug.M.*;

public class UseQueue {
	public static void demo1() {
		Queue<Integer> queue = new LinkedList<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
		}};
		p(queue.add(5));
		p(queue);
		
		p("element()");
		p(queue.element());
		p(queue);
		
		p("remove()");
		p(queue.remove());
		p(queue);
	}
	
	public static void demo2() {	
		Queue<Integer> queue = new LinkedList<Integer>() {{
			offer(1);
			offer(2);
			offer(3);
			offer(4);
		}};
		p(queue.offer(5));
		p(queue);
		
		p("peek()");
		p(queue.peek());
		p(queue);
		
		p("poll()");
		p(queue.poll());
		p(queue);
	}
	
	public static void demo3() {
		Queue<Integer> queue = new LinkedList<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};
		
		p(queue.size());
		p(queue.isEmpty());
		p(queue.contains(3));
		
		queue.clear();
		p(queue.isEmpty());
		
		queue.addAll(Arrays.asList(1, 2, 3));
		p(queue);
		
		Object[] a = queue.toArray();
		for(Object o: a) {
			p(o);
		}
		
		Integer[] a2 = queue.toArray(new Integer[queue.size()]);
		for(int i: a2) {
			p(i);
		}
	}

	public static void main(String[] args) {
		demo1();
	}

}
