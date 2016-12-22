package ds.search;

public class Search {
	
	public static int binarySearch(int[] array, int key) {
		int n = array.length - 1;
		
		int low = 1;
		int high = n;
		
		while(low<=high) {
			int mid = (low+high)/2; //= low/2+high/2 =low-low/2+high/2 = low+(high-low)/2
			System.out.println(String.format("low:%d, high:%d, mid:%d", low, high, mid));
			if(array[mid] > key) {
				high = mid - 1;
			} else if (array[mid] < key) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return 0; // not found
	}
	
	public static int interpolationSearch(int[] array, int key) {
		int n = array.length - 1;
		
		int low = 1;
		int high = n;
		
		while(low<=high) {
			int mid = low + (high-low)*(key-array[low])/(array[high]-array[low]); 
			System.out.println(String.format("low:%d, high:%d, mid:%d", low, high, mid));
			if(key<array[mid]) {
				high = mid - 1;
			} else if (key>array[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return 0; // not found
	}
	
	public static void demo() {
		int[] array = {0, //sential item
			1, 3, 7, 12, 15, 
			29, 57, 86, 103, 294};
		
		for(int i=1; i<=10; i++) {
			System.out.println("==========");
			System.out.println(String.format("search(%d)", array[i]));
			System.out.println(interpolationSearch(array, array[i]));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		demo();
	}

}
