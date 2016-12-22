package ds.sort;

public class BubbleSort extends Sort{

	public void sort(int[] a) {
		for(int i=0; i<a.length; i++)
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j])
					swap(a, i, j);
			}
	}
	
	public void sort2(int[] a) {
		for(int i=1; i<a.length; i++)
			for(int j=a.length-1; j>=i; j--) {
				if(a[j-1]>a[j])
					swap(a, j-1, j);
			}
	}
	
	public void sort3(int[] a) {
		boolean isSwitch = true;
		
		for(int i=1; i<a.length & isSwitch; i++) {
			isSwitch = false;
			for(int j=a.length-1; j>=i; j--) {
				if(a[j-1]>a[j]) {
					swap(a, j-1, j);
					isSwitch = true;
				}	
			}
			display(a);
		}

	}
	
	public static void demo() {
		BubbleSort s = new BubbleSort();
		s.sort3(s.test);
		s.display(s.test);
	}
	
	public static void main(String[] args) {
		demo();
	}

}
