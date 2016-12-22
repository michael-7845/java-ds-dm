package kemin.holder;

import java.util.Stack;

import static kemin.debug.M.*;

public class UseStack {
	public static void demo1() {
		Stack<Integer> s = new Stack<Integer>();
		p(s.isEmpty());
		
		s.push(1);
		s.push(2);
		s.push(3);
		p(s.toString());
		p(s.pop());
		s.push(4);
		p(s);
		
		p("peek()");
		p(s.peek());
		p(s);
		
		p("search()");
		p(s.search(4)); // [1,2,4]: pos 1
		p(s.search(2)); // [1,2,4]: pos 2
		p(s.search(1)); // [1,2,4]: pos 3
		p(s.search(5));
		
		p("clear()");
		s.clear();
		p(s.isEmpty());
		p(s);
	}

	public static void main(String[] args) {
		demo1();
	}

}
