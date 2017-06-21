package sort;

import common.Timer;
import sort.common.CommonUtil;

public class InsertionSort extends CommonUtil {
	
	

	public static void main(String[] args) {
		
		//200000 55452ms
		Comparable[] array = generateRandomComparableArray(20000);
		//printArray(array);
		sort(array);
		//printArray(array);
	}
	
	public static void sort(Comparable[] array){
		Timer t = new Timer();
		t.start();
		for(int i = 1; i < array.length ; i++){
			for(int j = i; j > 0 && isLess(array[j], array[j-1]); j--){
				exchange(array, j, j-1);
			}
		}
		t.stop();
	}

}
