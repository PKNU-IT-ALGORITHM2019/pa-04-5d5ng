package pa4_1;


public class HeapSort {
	
	public static void Max_Heapify(int A[],int i,int size){ //index 0-n-1

		while(i*2+1<=size) {
			int k=i*2+1;
			if(k+1<=size && A[k]<A[k+1] )
				k++;
			if(A[i]>=A[k])  {return;} //부모가 자식보다 크거나 같을경우 리턴
			
			int tmp=A[i];
			A[i]=A[k];
			A[k]=tmp;
			
			i=k;
		}
		
		
		
		
		
	}
	
	public static void Build_Max_Heap(int A[]) {
		
		int i,size=A.length-1; 
		if(size%2==0)  i=size/2-1;
		else i=size/2;
		
		for(;i>=0;i--) {
			
			Max_Heapify(A, i,size);
			
		}
	
		
	}
	
	public static void HeapSort(int A[]) {

		Build_Max_Heap(A);
		for(int i=A.length-1;i>=1;) {
			int tmp=A[0];	
			A[0]=A[i];
			A[i]=tmp;	
			i--;
			
		  Max_Heapify(A,0, i);	
		}
		
		
	}


}
