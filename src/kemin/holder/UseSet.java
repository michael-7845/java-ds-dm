package kemin.holder;

import static kemin.debug.M.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UseSet {
	public static List<Integer> $list() {
		return new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
	}
	
	public static Set<Integer> $set() {
//		return new HashSet<Integer>(Arrays.asList(10, 11, 12, 13, 14));
		return new LinkedHashSet<Integer>(Arrays.asList(10, 11, 12, 13, 14));
	}

	public static void demo() {
		Set<Integer> set = $set();
		p(set.add(100));
		p(set);
		
		p(set.addAll($list()));
		p(set);
		
		p(set.contains(4));
		p(set.contains(5));
		p(set.containsAll($list()));
		
		p(set.isEmpty());
		set.clear();
		p(set.isEmpty());
	}
	
	public static void demo2() {
		Set<Integer> set = $set();
		p(set.equals($set()));
		p(set.hashCode());
		p(set.size());
		
		Object[] a = set.toArray();
		for(Object o: a) {
			p(o);
		}
		
		Integer[] a2 = set.toArray(new Integer[set.size()]);
		for(Integer i: a2) {
			p(i);
		}
		
		p(set.retainAll(Arrays.asList(10, 11, 12, 13)));
		p(set);
		
		p(set.remove(13));
		p(set);
		
		p(set.removeAll(Arrays.asList(11, 12)));
		p(set);
	}
	
	public static void demo3() {
		Set<String> hs = new HashSet<String>();  
		hs.add("B");  
		hs.add("A");  
		hs.add("D");  
		hs.add("E");  
		hs.add("C");  
		hs.add("F");  
		System.out.println("HashSet:\n"+hs);  
		Set<String> lhs = new LinkedHashSet<String>();  
		lhs.add("B");  
		lhs.add("A");  
		lhs.add("D");  
		lhs.add("E");  
		lhs.add("C");  
		lhs.add("F");  
		System.out.println("LinkedHashSet:\n"+lhs);  
		Set<String> ts = new TreeSet<String>();  
		ts.add("B");  
		ts.add("A");  
		ts.add("D");  
		ts.add("E");  
		ts.add("C");  
		ts.add("F");  
		System.out.println("TreeSet:\n"+ts);  
	}
	
	public static void main(String[] args) {
		demo3();
	}

}
