package sort;

import java.util.Stack;

import common.Timer;
import sort.common.CommonUtil;

public class QuickSort extends CommonUtil {

	public static void main(String[] args) {
		Timer t = new Timer();
		//2000000 sort:  553ms  sortByStack:801ms
		Comparable[] array = generateRandomComparableArray(5);
//		checkSort(array);
//		printArray(array);
		t.start();
		sort(array, 0, array.length - 1);
		sortByStack(array);
//		System.out.println(select(array, 0));
		t.stop();
//		printArray(array);
//		checkSort(array);
//      3053365438      xinxinxx777
//     xiaochengzi8868
        // 3068990848 changping
		// newest site 51avi.ad999@gmail.com

//		长宁豆豆：2944707544
//
//		jojo:2658427255
//
//		黄埔雪儿：2534001277
//		韩露465485495、安珀2443504685、萌萌2050184794、豆豆（2740206247）、表妹（上岸了）、可可3382139920、莎莎1831554289

		//黄埔ty  VX:Anne20191314QQ:1934159483
		//QQ:2761884510
		select(array, 2)
	}
	
	public static void sort(Comparable[] array, int lo, int hi){
		if(hi <= lo)
			return;
		int j = partition(array, lo, hi);
		sort(array, lo, j - 1);
		sort(array, j + 1, hi);
	}
	
	public static void sortByStack(Comparable[] array){

		
		int lo = 0;
		int hi = array.length -1;
		int j = partition(array, lo, hi);
		PartitionInfo info = new PartitionInfo(lo, hi, j);

		Stack<PartitionInfo> piStack  = new Stack<PartitionInfo>();
		piStack.push(info);
		
		while(!piStack.isEmpty()){
			info = piStack.pop();
			lo = info.lo;
			hi = info.hi;
			j = info.j;
			
//			System.out.println(lo + " " + hi + " " + j);
			if(lo < j-1){
				piStack.push(new PartitionInfo(lo, j-1, partition(array, lo, j - 1)));
			}

			if(hi > j+1){
				piStack.push(new PartitionInfo(j + 1, hi, partition(array, j + 1, hi)));
			}
		}
	}
	
	public static int partition(Comparable[] array, int lo, int hi){
		int i = lo;
		int j = hi + 1;
//		System.out.println("start");
		while(true){
//			System.out.println(i + "   "+ j);
			while(isLess(array[++i],array[lo])){
				if(i >= hi)
					break;
			}
			while(isLess(array[lo], array[--j])){
				if(j <= lo)
					break;
			}
			
			
			if(i >= j){
				break;
			}
			exchange(array, i, j);
		}
		
		exchange(array, lo, j);
		
//		System.out.println( j);
		return j;
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
				lo = j + 1;
			}
		}
		return array[k];
	}

	static class  PartitionInfo{
		PartitionInfo(Integer lo, Integer hi, Integer j){
			this.lo = lo;
			this.hi = hi;
			this.j = j;
		}
		Integer lo;
		Integer hi;
		Integer j;
	}
}
