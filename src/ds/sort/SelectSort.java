package ds.sort;

public class SelectSort extends Sort {

	public void sort(int[] a) {
		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i; j<a.length; j++) {
				if(a[j]<a[min])
					min = j;
			}
			if(min!=i)
				swap(a, i, min);
			display(a);
		}
	}
	
	public static void demo() {
		SelectSort s = new SelectSort();
		s.sort(s.test);
		s.display(s.test);
	}
	
	public static void main(String[] args) {
		demo();
	}

}
