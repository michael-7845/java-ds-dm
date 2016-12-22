package ds.sort;

public class QuickSort extends Sort {
	public static void sort(int[] a) {
		qsort(a, 0, a.length-1);
	}
	
	public static void qsort(int[] a, int low, int high) {
		int pivot;
		if(low<high) {
			pivot = partition(a, low, high);
			qsort(a, low, pivot-1);
			qsort(a, pivot+1, high);
		}
	}
	
	public static int partition(int[] a, int low, int high) {
		int pivotkey = a[low];
		while(low<high) {
			while(low<high && a[high]>=pivotkey) {
				high--;
			}
			a[low] = a[high];
			while(low<high && a[low]<=pivotkey) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = pivotkey;
		return low;
	}
	
	public static void demo() {
		int[] test = {9,1,5,8,3,7,4,6,2};
		QuickSort.sort(test);
		(new QuickSort()).display(test);
	}
	
	public static void main(String[] args) {
		demo();
	}
}
