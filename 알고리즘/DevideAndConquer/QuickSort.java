package DevideAndConquer;

public class QuickSort {
	static QuickSort qs = new QuickSort();
	public static void main(String[] args)
	{
		int a[] = {20, 12, 84, 91, -7, -26, 5, 64, -8, -77, 86};
		
		System.out.print("[ ");
		for(int i = 0; i < a.length; i++)
			System.out.printf("%d ",  a[i]);
		System.out.print("]\n");
		
		qs.qSort(a, 0, a.length-1);
		
		System.out.print("[ ");
		for(int i = 0; i < a.length; i++)
			System.out.printf("%d ",  a[i]);
		System.out.print("]\n");
	}
	
	void qSort(int[] array, int left, int right)
	{
		if(left >= right)
			return;
		
		int pivot = pratition(array, left, right);
		
		qSort(array, left, pivot-1);
		qSort(array, pivot+1, right);
	}
	
	int pratition(int[] array, int left, int right)
	{
		int pivot = array[(left+right)/2];
		System.out.printf("pivot : %d\n", pivot);
		
		left--;
		right++;
		while(true)
		{
			do {
				left++;
				System.out.printf("left : %d\n", left);
			} while(array[left] < pivot);
			
			do {
				right--;
				System.out.printf("right : %d\n", right);
			} while(array[right] > pivot && left <= right);
			
			if(left >= right)
				return right;
			
			swap(array, left, right);
			
			System.out.print("[ ");
			for(int i = 0; i < array.length; i++)
				System.out.printf("%d ",  array[i]);
			System.out.print("]\n");
		}
	}
	
	void swap(int[] array, int left, int right)
	{
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		
		
	}
}
