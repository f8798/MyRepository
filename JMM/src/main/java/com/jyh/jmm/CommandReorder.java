package com.jyh.jmm;

public class CommandReorder {
	public static void main(String[] args){
		Comparable[] array = {"5","3","2","1","4"};
		select(array, 2);
	}

	public static Comparable select(Comparable[] array, int k){
		int lo = 0;
		int hi = array.length - 1;

		while(true){
			int j = partition(array, lo, hi);
			if(j == k){
				break;
			}else if(j > k){
				hi = j -1;
			}else if(j < k){
				lo = j+1;
			}
		}

		return array[k];


	}

	public static int partition(Comparable[] array, int lo, int hi){
		int i = lo;
		int j = hi + 1;
		while(true){
			while((array[++i]).compareTo(array[lo]) < 0){
				if(i > hi){
					break;
				}
			}

			while(array[lo].compareTo(array[--j]) < 0){
				if(j <= lo){
					break;
				}
			}

			if(i >= j){
				break;
			}
			exchange(array, i, j);

		}
		exchange(array, lo, j);

		return j;
	}
	public static void exchange(Comparable[] array, int i, int j){
		Comparable tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
