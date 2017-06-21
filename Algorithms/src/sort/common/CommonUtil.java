package sort.common;

public class CommonUtil {
	public static void exchange(Comparable[] array, int i, int j){
		Comparable tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static Comparable[] generateRandomComparableArray(int length){
		Comparable[] array = new Comparable[length];
		for(int i=0; i < array.length ; i++){
			array[i] = ((Double)(Math.random()*10000000)).intValue();
		}
		
		return array;
	}
	
	public static void printArray(Comparable[] array){
		for(Comparable c:array){
			System.out.print( c==null? "null":c.toString() + "  ");
		}
		System.out.println();
	}
	
	public static void printArrayLimit(Comparable[] array, int limit){
		for(int i = 0;i< limit; i++){
			System.out.print( array[i].toString()+ "  ");
		}
		System.out.println();
	}
	
	public static boolean isLess(Comparable a, Comparable b){
		return (a.compareTo(b) < 0);
	}
	
	public static boolean isEqualOrLess(Comparable a, Comparable b){
		return (a.compareTo(b) <= 0);
	}
	
	public static boolean isMore(Comparable a, Comparable b){
		return (a.compareTo(b) > 0);
	}
	
	public static boolean isEqualOrMore(Comparable a, Comparable b){
		return (a.compareTo(b) > 0);
	}
	
	public static boolean checkSort(Comparable[] array){
		boolean result1 = true;
		boolean result2 = true;
		for(int i = 0; i < array.length - 1;i++){
			if(isMore(array[i], array[i+1])){
				result1 = false;
				break;
			}
		}
		
		for(int i = 0; i < array.length - 1;i++){
			if(isLess(array[i], array[i+1])){
				result2 = false;
				break;
			}
		}
		
		System.out.println(result1 || result2);
		
		return (result1 || result2);
	}
}
