package sort;

import common.Timer;
import sort.common.CommonUtil;

public class HeapSort extends CommonUtil{
	
	public static void main(String args[]){
		//2000000 1549ms
		Comparable[] array = generateRandomComparableArray(2000000);
		//printArray(array);
		Timer t = new Timer();
		t.start();
		sort(array);
		t.stop();
		//printArray(array);
	}
	
	public static void sort(Comparable[] array){
		int N = array.length - 1;
		for(int k = (N-1)/2;k>= 0;k--){
			sink(array, k ,N);
		}
		
		while(N > 0){
			exchange(array, 0, N--);
			sink(array,0,N);
		}
	}

	

	
	public static void sink(Comparable[] array, int k, int N){
		while((2*k + 1) <= N){
			int j = 2*k + 1;
			if(j < N && less(array, j, j+1)){
				j ++ ;
			}
			if(less(array, k, j)){
				exchange(array, k,j);
			}else{
				break;
			}
			k = j;
		}
	}
	
	
	
	public static void exchange(Comparable[] array, int i, int j){
		Comparable k = array[j];
		array[j] = array[i];
		array[i] = k;
	}
	
	public static boolean less(Comparable[] array, int i, int j){
		return array[i].compareTo(array[j]) < 0;
	}
}


