package kemin.holder;

import static kemin.debug.M.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class UseList {

	public static List<Integer> $list() {
		return new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
	}
	
	public static Set<Integer> $set() {
		return new HashSet<Integer>(Arrays.asList(10, 11, 12, 13, 14));
	}
	
	public static Map<Integer, String> $map() {
		return new HashMap<Integer, String>(){
			private static final long serialVersionUID = -385419618033432007L;
		{
			put(1, "x");
			put(2, "y");
			put(3, "z");
			put(4, "u");
			put(5, "v");
		}};
	}
	
	public static void demo() {
//		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4); // add, remove: java.lang.UnsupportedOperationException
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		list.add(5);
		list.add(1, 6);
		list.remove(2); // remove(index)
		list.remove(new Integer(2)); // remove(o)
		p(list);
	}
	
	public static void demo2() {
		List<Integer> list = $list();
		list.addAll(Arrays.asList(5, 6));
		p(list);
		list.addAll($set());
		p(list);
//		list.addAll($map()); //The method addAll(Collection<? extends Integer>) in the type List<Integer> is not applicable for the arguments (Map<Integer,String>)
		list.addAll(7, $map().keySet());
		p(list);
		p(list.subList(1, 10)); // 1..9
	}

	public static void demo3() {
		List<Integer> list = $list();
		list.set(1, 7);
		p(list);
		p(list.get(2)); 
		p(list.indexOf(7));
		p(list.lastIndexOf(7));
	}
	
	public static void demo4() {
		List<Integer> list = $list();
		list.addAll(Arrays.asList(5, 6, 7, 8, 9));
		
		Iterator<Integer> i = list.iterator();
		while(i.hasNext()) {
			p(i.next());
		}
		
		for(i=list.iterator(); i.hasNext(); ) {
			p(i.next());
		}
	}
	
	public static void demo5() {
		List<Integer> list = $list();
		list.addAll(Arrays.asList(5, 6, 7, 8, 9));
		
		ListIterator<Integer> i = list.listIterator();
		
		p(i.nextIndex()); // [> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		p(i.nextIndex()); // [> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		p(i.next()); // [0, > 1, 2, 3, 4, 5, 6, 7, 8, 9]
		i.add(10); // [0, 10, > 1, 2, 3, 4, 5, 6, 7, 8, 9]
		p(list);
		
		p(i.hasNext());
		p(i.hasPrevious());
		p(i.previous()); // [0, > 10, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		p(i.nextIndex());
		p(i.previousIndex());
		
		p(i.next());
		p(i.next());
		i.set(11);
		p(list);
	}
	
	public static void demo6() {
		List<Integer> list = $list();
		list.addAll(Arrays.asList(5, 6, 7, 8, 9));
		
		ListIterator<Integer> i = list.listIterator(list.size());
		while(i.hasPrevious()) {
			p(i.previous());
		}
	}
	
	public static void main(String[] args) {
		demo6();
	}

}
