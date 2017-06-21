package sort;

import common.Timer;
import sort.common.CommonUtil;

public class SelectionSort extends CommonUtil {

	public static void main(String[] args) {
		
		//200000 68452ms
		Comparable[] array = generateRandomComparableArray(200000);
		//printArray(array);
		sort(array);
		//printArray(array);
	}
	public static void sort(Comparable[] array){
		Timer t = new Timer();
		t.start();
		for(int i = 0;i < array.length - 1;i++){
			int minIndex = i;
			for(int j = i + 1; j < array.length ;j++){
				if(isLess(array[j], array[minIndex])){
					minIndex = j;
				}
			}
			if(i != minIndex){
				exchange(array, i, minIndex);
			}
		}
		t.stop();
	}

}
