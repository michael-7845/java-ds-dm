package ds.sort;

import static kemin.debug.M.*;

public class HeapSort {
	public static int[] a = {0,3,1,9,5,2,7,4,8,6};

	public static void swap(int[] array, int i, int j) {
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
	}
	
	/*
	 * �ѺͶ�Ӧ������֮��Ĺ�ϵ
	���������һ����������ʾ��ȫ�������� ��ô��
	array[] = {0,1,2,3,4,5,6,7,8,9}
	bt:
	       0
	    1      2
	  3   4   5 6
	 7 8 9
	���Եõ����ɣ�
	�����һ��Ԫ�ش�0��ʼ��
	���ӽ��ı��=������� * 2 + 1
	���ӽ��ı��=������� * 2 + 2
	 ���������ı�ţ������ƵĶ�Ӧ��ϵ��
	���ӽ�������������= ����������� * 2 + 1
	���ӽ�������������= ����������� * 2 + 2

	�����һ��Ԫ�ش�1��ʼ��
	���ӽ��ı��=������� * 2 
	���ӽ��ı��=������� * 2 + 1
	 ���������ı�ţ������ƵĶ�Ӧ��ϵ��
	���ӽ�������������= ����������� * 2
	���ӽ�������������=����������� * 2 + 1

	java�е������0��ʼ�����±�, ����һֱ�ڵ�n���������Ӻ��Һ��ӵļ��㹫ʽ
	left(n) = 2*n+1; right(n) = 2*n+2
	���׽ڵ�ļ��㹫ʽ
	parent(n) = n/2
	 */
	public static int left(int n) {
		return 2*n+1;
	}
	public static int right(int n) {
		return 2*(n+1);
	}
	public static int parent(int n) {
		return n/2;
	}
	
	/*
	 * �ѵ���
	 ������ôһ��������˵������һ����Ҫ�����Ծ��Ǵ��ڸ�����ֵ����������ӽ��Ҫ��
	 ����ĳһ��������ĸ���㲻�������Ҫ�����Ǿͱ�����е�����
	 ��ͳ��˵���������ǽ���������������Ľ����ӽ����бȽϣ�ͨ�����������Ľ����Ϊ����㡣
	���������Ĺ��̣���Ҫ���£�
	1. �Ƚϵ�ǰ���������ӽ�㣬�����ǰ���С�������κ�һ���ӽ�㣬��������Ǹ��ӽ�㽻�������򣬵�ǰ���̽�����
	2. �ڽ�������λ�õĽ���ظ�����1��ֱ��Ҷ��㡣
	 */
	// �ݹ�汾
	public static void heapify(int[] array, int index, int length) {
		int max = index;
		int left = left(index);
		int right = right(index);
		
		if((left<length) && (array[left]>array[index])) {
			max = left;
		}
		if((right<length) && (array[right]>array[max])) {
			max = right;
		}
		if(index!=max) {
			swap(array, index, max);
			heapify(array, max, length);
		}
	}
	
	// �ǵݹ�汾
	public static void heapify2(int[] array, int index, int length) {
		int max = index;
		
		while(true) {
			int left = left(index);
			int right = right(index);
			if((left<length) && (array[left]>array[index])) {
				max = left;
			}
			if((right<length) && (array[right]>array[max])) {
				max = right;
			}
			if(index!=max) {
				swap(array, index, max);
				index = max;
			} else
				break;
		}
	}
	
	/*
	 * ������
	 ��Ȼ��һ���ѵ����Ĺ��̣��������������Ҫ��Ե���һ�����е�һ����㡣
	 ������м��ж����㲻�������ѵ����������ǹ����ĳһ�������û���õġ�
	 ��ô������Ҫһ���취���������������ɷ������������ѡ�
	 һ����򵥵İ취���Ǵ���Ͳ�Ľ�㿪ʼ�������
	 �����ԣ�������Ǵ�a[a.length -1]�����Ľ���������Ļ������൱һ���ֽ����û��Ҫ�ġ�
	 ��Ϊ��Щ������Ȼ��Ҷ��㣬Ҳ����˵���Ǹ�����û���ӽ�㣬�����ӽ���ȥ�Ƚϵı�Ҫ��û���ˡ�
	 ���ԣ����ǿ��Դ��������ǰ������ȥ����Щ���ӽ��Ľ�㣬Ȼ�����Щ��㿪ʼһ�����Ľ��жѵ�����
	 
	 ��ô�����Ǹô��ĸ���㿪ʼ����е����أ����⣬���ǿ��ܻ�����ôһ�����ʣ�Ϊʲô����Ҫ�Ӻ�����ǰȥ��������ǰ��������������𣿱𼱣�������һ��������������
	 ���ȵ�һ�����⣬���ĸ���㿪ʼ���е���������������ö�����������Ȼ��������һ��Ԫ��Ҳ�϶��������յ�һ��Ҷ��㡣
	 ��ôȡ���ĸ����Ӧ�þ������ӽ������ŵ�Ԫ���ˡ���ô������ʼ��������ʵġ�ȡ���ĸ�������ͨ��һ���򵥵�i/2���õ���iΪ��ǰ�����±ꡣ
	 Ȼ�������������ڶ������⣬ΪʲôҪ�Ӻ���ǰ�����Ǵ�ǰ����
	 ������Ҳ�ȽϺ����⡣���Ǵ�����Ĳ㿪ʼ��������֤������ĸ������������ʱ������������Ѿ��������ѵ������ˡ�
	 �������ֲ����������ĸ����ֻ��Ҫ��ǰ���maxheapify���̾Ϳ��ԡ�
	 */
	public static void buildMaxheap(int[] a) {
		for(int i=parent(a.length-1);i>=0;i--) {
			heapify(a, i, a.length);
		}
	}
	
	/*
	 ��Ȼ��ͨ������һ�����ѣ��ܹ���֤����Ԫ�ؾ��Ǹ���㣬��ô���������Ҫ��С��������Ļ�������Ԫ�ؾ�ֻҪȡ�����Ϳ����ˡ�
	 ������ǰѸ���������ˣ��ŵ����������ĩһ��Ԫ�أ����ž�Ӧ���ҵڶ����Ԫ�ء�
	 ��ΪҪ��֤����������ǽ�����ȫ�����������ʣ����ǲ��ܰ��м�Ľ��ֱ��Ų����������Ƚϡ�
	 ����ǰ���maxHeapify�����������ǣ�������ǴӼ��ϵ����һ��Ҷ�����ȡ��Ȼ��ŵ��������е����Ļ����϶�Ҳ�ǿ��Եõ�ʣ��Ԫ������������ġ�
	 �����������ǿ��Եõ���ôһ�����̣�
	 1. ȡ���ѵĸ����Ԫ�ء�
	 2. ȡ������ĩβ��Ԫ�أ��ŵ�����㣬����maxHeapify���е������ظ�����1.
	 �ھ���ʵ�ֵ�ʱ�����ǿ��Է��֣�ÿ�ζ�Ҫȡ�����к����Ԫ�أ�����ԭ���õ�����������ÿ��Էŵ����ϵ�ĩβ�����ôﵽ����Ԫ�طŵ�����Ч����
	 */
	public static void heapsort(int[] a) {
		if(a==null || a.length<=1) {
			return;
		}
		
		buildMaxheap(a);
		int length = a.length;
		for(int index=a.length-1; index>=0; index--) {
			swap(a, index, 0);
			length--;
			heapify(a, 0, length);
		}
	}
	
	public static void demo() {
//		heapify2(a, 0, a.length);
//		buildMaxheap(a);
		heapsort(a);
		for(int i: a) {
			p(i);
		}
		
		
	}
	
	public static void main(String[] args) {
		demo();
	}

}