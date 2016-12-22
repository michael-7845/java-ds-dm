package ds.sort;

public class ShellSort extends Sort {

	public void sort(int[] a) {
		int[] arr = Sort.concat(new int[]{0}, a);
		int i, j;
		int increment = a.length;
		
		do {
			increment = increment/3 + 1;
			for(i=increment+1; i<arr.length; i++) {
				if(arr[i]<arr[i-increment]) {
					arr[0] = arr[i]; //arr[0] as sentinel
					for(j=i-increment; j>0 && arr[j]>arr[0]; j-=increment) {
						arr[j+increment] = arr[j];
					}
					arr[j+increment] = arr[0];
				}
			}
			display(arr);
		} while(increment>1);			
		System.arraycopy(arr, 1, a, 0, a.length);
	}
	
	public static void demo() {
		ShellSort s = new ShellSort();
		s.sort(s.test);
		s.display(s.test);
	}
	
	public static void main(String[] args) {
		demo();
	}

}
