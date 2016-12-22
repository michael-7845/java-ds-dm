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
	 * 堆和对应的数组之间的关系
	如果我们用一个数组来表示完全二叉树， 那么：
	array[] = {0,1,2,3,4,5,6,7,8,9}
	bt:
	       0
	    1      2
	  3   4   5 6
	 7 8 9
	可以得到规律：
	如果第一个元素从0开始：
	左子结点的编号=父结点编号 * 2 + 1
	右子结点的编号=父结点编号 * 2 + 2
	 按照数组标的编号，有类似的对应关系：
	左子结点的数组索引号= 父结点索引号 * 2 + 1
	右子结点的数组索引号= 父结点索引号 * 2 + 2

	如果第一个元素从1开始：
	左子结点的编号=父结点编号 * 2 
	右子结点的编号=父结点编号 * 2 + 1
	 按照数组标的编号，有类似的对应关系：
	左子结点的数组索引号= 父结点索引号 * 2
	右子结点的数组索引号=父结点索引号 * 2 + 1

	java中的数组从0开始计算下标, 所以一直节点n，它的左孩子和右孩子的计算公式
	left(n) = 2*n+1; right(n) = 2*n+2
	父亲节点的计算公式
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
	 * 堆调整
	 对于这么一个最大堆来说，它有一个重要的特性就是处于父结点的值必须比它的子结点要大。
	 假设某一棵树上面的父结点不满足这个要求，我们就必须进行调整。
	 笼统的说，调整就是将这个不符合条件的结点和子结点进行比较，通过交换将最大的结点作为父结点。
	交换调整的过程，主要如下：
	1. 比较当前结点和它的子结点，如果当前结点小于它的任何一个子结点，则和最大的那个子结点交换。否则，当前过程结束。
	2. 在交换到新位置的结点重复步骤1，直到叶结点。
	 */
	// 递归版本
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
	
	// 非递归版本
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
	 * 建最大堆
	 虽然有一个堆调整的过程，但是这个过程主要针对的是一个树中的一个结点。
	 如果树中间有多个结点不符合最大堆的条件，我们光调整某一个结点是没有用的。
	 那么，就需要一个办法来将整棵树调整成符合条件的最大堆。
	 一个最简单的办法就是从最低层的结点开始起调整。
	 很明显，如果我们从a[a.length -1]这样的结点来调整的话，有相当一部分结点是没必要的。
	 因为这些结点很显然是叶结点，也就是说他们根本就没有子结点，连找子结点和去比较的必要都没有了。
	 所以，我们可以从最后面往前到过来去找那些有子结点的结点，然后从这些结点开始一个个的进行堆调整。
	 
	 那么，我们该从哪个结点开始起进行调整呢？另外，我们可能还有这么一个疑问，为什么我们要从后面往前去调整？从前面往后调整不行吗？别急，让我们一个个的来分析。
	 首先第一个问题，从哪个结点开始进行调整。我们来看这棵二叉树，很显然，它最后的一个元素也肯定就是最终的一个叶结点。
	 那么取它的父结点应该就是有子结点的最大号的元素了。那么从它开始就是最合适的。取它的父结点可以通过一个简单的i/2来得到，i为当前结点的下标。
	 然后我们再来看第二个问题，为什么要从后往前而不是从前往后。
	 这个相对也比较好理解。我们从下面的层开始调整，保证当上面的父结点来调整的时候，下面的子树已经满足最大堆的条件了。
	 这样出现不符合条件的父结点只需要用前面的maxheapify过程就可以。
	 */
	public static void buildMaxheap(int[] a) {
		for(int i=parent(a.length-1);i>=0;i--) {
			heapify(a, i, a.length);
		}
	}
	
	/*
	 既然我通过建了一个最大堆，能够保证最大的元素就是根结点，那么，我们如果要从小到大排序的话，最大的元素就只要取根结点就可以了。
	 如果我们把根结点拿走了，放到结果集的最末一个元素，接着就应该找第二大的元素。
	 因为要保证这棵树本身是近似完全二叉树的性质，我们不能把中间的结点直接挪到根结点来比较。
	 但是前面的maxHeapify过程提醒我们，如果我们从集合的最低一层叶结点来取，然后放到根结点进行调整的话，肯定也是可以得到剩下元素里面的最大结点的。
	 就这样，我们可以得到这么一个过程：
	 1. 取最大堆的根结点元素。
	 2. 取集合最末尾的元素，放到根结点，调用maxHeapify进行调整。重复步骤1.
	 在具体实现的时候我们可以发现，每次都要取集合中后面的元素，我们原来得到的最大结点正好可以放到集合的末尾，正好达到最大的元素放到最后的效果。
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
