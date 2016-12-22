package ds.sort;

public class Sort {
	
	public int[] test = {9,1,5,8,3,7,4,6,2};
//	public int[] test = {1,2,3,4,5,6,8,7,9};

	public void display(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print("["+i+"]:" + array[i] + " ");
		}
		System.out.println("");
	}
	
	public static int[] concat(int[] a, int[] b) {
		int[] dest = new int[a.length+b.length];
		System.arraycopy(a, 0, dest, 0, a.length);
		System.arraycopy(b, 0, dest, a.length, b.length);
		return dest;
	}
	
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void demo() {	
		Sort s = new Sort();
		s.swap(s.test, 1, 2);
		s.display(s.test);
	}
	
	public static void demo2() {
		int[] dest = concat(new int[]{1, 2, 3}, new int[]{4, 5, 6});
		Sort s = new Sort();
		s.display(dest);
	}
	
	public static void main(String[] args) {
		demo2();
	}

}
