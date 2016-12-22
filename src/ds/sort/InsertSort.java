package ds.sort;

public class InsertSort extends Sort {

	public void sort(int[] a) {
		int i, j, sentinel;
		
		for(i=1; i<a.length; i++) {
			if(a[i] < a[i-1]) {
				sentinel = a[i];
//				for(j=i-1; j>=0; j--) {
//					if(a[j] > sentinel)
//						a[j+1] = a[j];
//					else
//						break;
//				}
				for(j=i-1; j>=0 && a[j]>sentinel; j--) {
					a[j+1] = a[j];
				}
				a[j+1] = sentinel;
			}
			display(a);
		}
	}
	
	//a[0] as sentinel
	public void sort2(int[] a) {
		int i, j, sentinel;
		
		int[] _a = Sort.concat(new int[]{0}, a);
		display(_a);
		
		for(i=2; i<_a.length; i++) {
			if(_a[i] < _a[i-1]) {
				_a[0] = _a[i];
				for(j=i-1; _a[j]>_a[0]; j--) {
					_a[j+1] = _a[j];
				}
				_a[j+1] = _a[0];
			}
			display(_a);
		}
		System.arraycopy(_a, 1, a, 0, a.length);
	}
	
	public static void demo() {
		InsertSort s = new InsertSort();
		s.sort(s.test);
		s.display(s.test);
	}
	
	public static void demo2() {
		boolean flag = true;
		for(int i=0; i<3 & flag; i++) {
			System.out.println(i);
			flag = false;
		}
	}
	
	public static void main(String[] args) {
		demo();
	}

}
