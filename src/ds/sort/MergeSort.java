package ds.sort;

public class MergeSort extends Sort {
	
	public static void sort(int[] a) {
		msort(a, 0, a.length-1);
	}
	
	public static void msort(int[] a, int i, int j) {
		if(i<j) {
			int middle = (i+j)/2;
			msort(a, i, middle);
			msort(a, middle+1, j);
			merge(a, i, middle, j);
		}
	}
	
	public static void merge(int[] a, int i, int middle, int j) {
		int[] temp = new int[j-i+1];
		int a1 = i;
		int a2 = middle+1;
		int t = 0;
		while(a1<=middle && a2<=j) {
			if(a[a1]<a[a2]) {
				temp[t++] = a[a1++];
			} else {
				temp[t++] = a[a2++];
			}
		}
		while(a1<=middle) {
			temp[t++] = a[a1++];
		}
		while(a2<=j) {
			temp[t++] = a[a2++];
		}
		
		for(a1=i, t=0; a1<=j; a1++, t++) {
			a[a1] = temp[t];
		}
	}
	
	public static void demo() {
		int[] test = {9,1,5,8,3,7,4,6,2};
		MergeSort.sort(test);
		(new MergeSort()).display(test);
	}
	
	public static void main(String[] args) {
		demo();
	}

}
