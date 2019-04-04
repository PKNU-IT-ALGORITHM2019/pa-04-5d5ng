package pa4_1;

import java.util.Arrays;

public class ChkTime {
	static	int [] data1=new int[1000];
	static	int [] data2=new int[10000];
	static	int [] data3=new int[100000];
	static int []tmp1=new int[1000];
	static int []tmp2=new int[10000];
	static int []tmp3=new int[100000];

	static double [][]Time=new double[9][6];






	static public void main(String arg[]) {

		

		makedata(data1, 1000); //1000개의 랜덤데이터 생성
		System.arraycopy(data1, 0, tmp1, 0, data1.length);//tmp1에 data1의 배열 복사

		timeofData1(tmp1,0); //1000개 랜덤일때 시간측정 ,각 배열의 0열에 저장
	
		reverseArray(data1); //reverse생성

		System.arraycopy(data1, 0, tmp1, 0, data1.length);

		timeofData1(tmp1,1); //1000개 리버스일때 시간측정 ,각 배열의 1열에 저장




		makedata(data2,10000);

		System.arraycopy(data2, 0, tmp2, 0, data2.length);

		timeofData1(tmp2,2); 

		reverseArray(data2);

		System.arraycopy(data2, 0, tmp2, 0, data2.length);


		timeofData1(tmp2,3); 


		makedata(data3,100000);

		System.arraycopy(data3, 0, tmp3, 0, data3.length);

		timeofData1(tmp3,4); 

		reverseArray(data3);

		System.arraycopy(data3, 0, tmp3, 0, data3.length);


		timeofData1(tmp3,5); //퀵솔트1에서 스택오버플로우 발생!





		System.out.println("       Random1000     Reverse1000     Random10000     Reverse10000     Random100000     Reverse100000     ");



		for(int i=0;i<=8;i++) {
			if(i==0)System.out.print("Bubble      ");

			else if(i==1)System.out.print("Selection   ");
			else if(i==2)System.out.print("Insertion   ");
			else if(i==3)System.out.print("Merge       ");
			else if(i==4)System.out.print("Quick1      ");
			else if(i==5)System.out.print("Quick2      ");
			else if(i==6)System.out.print("Quick3      ");
			else if(i==7)System.out.print("Heap        ");
			else if(i==8)System.out.print("Java        ");
			for(int j=0;j<6;j++){

				         System.out.printf("%.6f       ",Time[i][j]);

			}

			System.out.println();


		}





	}

	private static void timeofData1(int Ar[],int index) {


		timeofBubble(Ar, index );


		timeofSelection(Ar,index);	


		timeofInsertion(Ar, index);

		timeofMerge(Ar, index);

		if(index!=5)
		timeofQ1(Ar, index);	
		if(index!=5)
		timeofQ2(Ar,index);
		if(index!=5)
		timeofQ3(Ar,index);
		
		timeofHeap(Ar, index);
		
		timeofJava(Ar, index);

	}


	private static double timeofBubble(int data[],int index) { 
		double start,end;

		Sort app=new Sort();
		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			app.bubble_Sort(data);

			end=System.currentTimeMillis();


			Time[0][index]+=(end-start)/(1000.0);


			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[0][index]/=10.0;

		return Time[0][index];


	}
	private static double timeofSelection(int data[],int index) {
		double start,end;

		Sort app=new Sort();
		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			app.selection_Sort(data);
			end=System.currentTimeMillis();
			Time[1][index]+=(end-start)/(1000.0);

			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);


		}

		Time[1][index]/=10.0;


		return Time[1][index];


	}

	private static double timeofInsertion(int data[],int index) {
		double start,end;

		Sort app=new Sort();
		for(int i=0;i<10;i++) {

			start=System.currentTimeMillis();
			app.insertion_Sort(data);
			end=System.currentTimeMillis();

			Time[2][index]+=(end-start)/(1000.0);

			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[2][index]/=10.0;

		return Time[2][index];


	}

	private static double timeofMerge(int data[],int index) {

		double start,end;

		Sort app=new Sort();
		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			app.merge_Sort(data, 0, data.length-1);
			end=System.currentTimeMillis();

			Time[3][index]+=(end-start)/(1000.0);


			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[3][index]/=10.0;

		return Time[3][index];


	}

	private static double timeofQ1(int data[],int index) {

		double start,end;

		Sort app=new Sort();
		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			app.quickSort1(data, 0, data.length-1);
			end=System.currentTimeMillis();

			Time[4][index]+=(end-start)/(1000.0);


			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[4][index]/=10.0;

		return Time[4][index];


	}


	private static double timeofQ2(int[] data, int index) {
		double start,end;

		Sort app=new Sort();


		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			app.quickSort2(data, 0, data.length-1);
			end=System.currentTimeMillis();

			Time[5][index]+=(end-start)/(1000.0);

			if(data.length==1000) {System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			//	System.out.println("we");
			}
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[5][index]/=10.0;

		return Time[5][index];

	}


	private static double timeofQ3(int[] data, int index) {
		double start,end;

		Sort app=new Sort();
		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			app.quickSort3(data, 0, data.length-1);
			end=System.currentTimeMillis();

			Time[6][index]+=(end-start)/(1000.0);

			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[6][index]/=10.0;

		return Time[6][index];

	}

	private static double timeofHeap(int[] data, int index) {
		double start,end;
		HeapSort heap=new HeapSort();
		
		//Sort app=new Sort();
		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			HeapSort.HeapSort(data);
			end=System.currentTimeMillis();

			Time[7][index]+=(end-start)/(1000.0);

			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[7][index]/=10.0;

		return Time[7][index];

	}
	private static double timeofJava(int[] data, int index) {
		double start,end;

		
		
		for(int i=0;i<10;i++) {
			start=System.currentTimeMillis();
			Arrays.sort(data);
			end=System.currentTimeMillis();

			Time[8][index]+=(end-start)/(1000.0);

			if(data.length==1000)System.arraycopy(data1, 0, data, 0, data1.length); //정렬된걸 다시 랜덤데이터로 바꿔줌
			else if(data.length==10000)System.arraycopy(data2, 0, data, 0, data2.length);
			else System.arraycopy(data3, 0, data, 0, data3.length);
		}

		Time[8][index]/=10.0;

		return Time[8][index];

	}
	




	private static void makedata(int data[],int buffer) {

		for(int i=0;i<buffer;i++) 
			data[i]=randomRange(1,buffer );



	}
	public static int randomRange(int n1, int n2) {
		return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	}
	public static void reverseArray (int data[]) {

		for(int i=0;i<data.length;i++) 
			data[i]=data.length-i;



	}



}
