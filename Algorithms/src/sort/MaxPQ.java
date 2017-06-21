package sort;

import sort.common.CommonUtil;

public class MaxPQ<Key extends Comparable<Key>> extends CommonUtil{
	
	public static void main(String args[]){
		Comparable[] array = generateRandomComparableArray(20);
		printArray(array);
		
		MaxPQ maxPQ = new MaxPQ(20);
		
		for(Comparable c:array){
			maxPQ.insert(c);
		}
		
		printArray(maxPQ.getPq());
		
		for(int i = 0;i < 20;i++){
			System.out.println(maxPQ.delMax());
		}
		
		printArray(maxPQ.getPq());
		
	}
	
	private Key[] pq;
	private int N = 0;
	
	public Key[] getPq(){
		return pq;
	}
	
	@SuppressWarnings("unchecked")
	MaxPQ(int maxN){
		pq = (Key[])new Comparable[maxN+1];
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(Key k){
		pq[++N] = k;
		swim(N);
	}
	
	public Key delMax(){
		Key max = pq[1];
		exchange(1, N);
		N--;
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	public void swim(int k){
		while(k > 1){
			int j = k/2;
			if(less(j, k)){
				exchange(j,k);
			}else{
				break;
			}
			k = j;
		}
	}
	
	public void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j < N && less(j, j+1)){
				j ++ ;
			}
			if(less(k, j)){
				exchange(k,j);
			}else{
				break;
			}
			k = j;
		}
	}
	
	
	
	public void exchange(int i, int j){
		Key k = pq[j];
		pq[j] = pq[i];
		pq[i] = k;
	}
	
	public boolean less(int i, int j){
		return pq[i].compareTo(pq[j]) < 0;
	}
}


