package sort;

import common.Timer;
import sort.common.CommonUtil;

public class BubbleSort extends CommonUtil{
	public static void main(String[] args) {
		
		//200000 140814
		Comparable[] array = generateRandomComparableArray(200000);
		//printArray(array);
		sort(array);
		//printArray(array);
	}
	
	public static void sort(Comparable[] array){
		Timer t = new Timer();
		t.start();
		for(int i = 0;i < array.length - 1;i++){
			for(int j = 0; j < array.length - 1- i ;j++){
				if(isLess(array[j + 1], array[j])){
					exchange(array, j, j + 1);
				}
			}
		}  
		t.stop();
	}
}

/*
4321
3421
3241
3214

3214
2314
2134

2134
1234

*/