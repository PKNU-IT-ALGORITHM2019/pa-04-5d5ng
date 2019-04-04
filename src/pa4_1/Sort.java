package pa4_1;



public class Sort {
	
	
	void bubble_Sort(int data[]) {
		int tmp;
		for (int i = data.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				if (data[j] > data[j + 1])
				{
					tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;

				}
			}

		}
//		for (int i = 0; i < data.length; i++)
//			System.out.printf("%d ",data[i]);
//		System.out.println();
	}
	void  selection_Sort(int data[]) {
		int tmp,maxIndex;
		for(int last=data.length-1;last>0;last--) {

			maxIndex=last;
			for(int i=last;i>=0;i--) { //find maximum index 0~last
				if(data[i]>data[maxIndex]) {

					maxIndex=i;
				}
			}

			tmp=data[last];
			data[last]=data[maxIndex];
			data[maxIndex]=tmp;


		}
//		for (int i = 0; i < data.length; i++)
//			System.out.printf("%d ",data[i]);
//		System.out.println();

	}

	void insertion_Sort(int data[]) {//삽입정렬
		int tmp;
		for(int i=1;i<data.length;i++) {
			int j=i-1; 
			tmp=data[i];
			while(j>=0 && data[j]>tmp ) {

				data[j+1]=data[j];
				j--;
			}
			j++;

			data[j]=tmp;

		}
//		for (int i = 0; i < data.length; i++)
//			System.out.printf("%d ",data[i]);
//		System.out.println();

	}
	void merge_Sort(int data[],int p,int r) {
		if(p<r) {
			int q=(p+r)/2;
			merge_Sort(data, p, q);
			merge_Sort(data,q+1,r);
			merge(data,p,q,r);
		}

	}

	private void merge(int a[], int p, int q, int r) {
		int i=p,j=q+1,k=p;
		int []tmp=new int[a.length];
		while(i<=q&& j<=r) {
			if(a[i]<=a[j]){
				tmp[k++]=a[i++];
			}
			else
				tmp[k++]=a[j++];

		}
		while(i<=q)
			tmp[k++]=a[i++];
		while(j<=r)
			tmp[k++]=a[j++];
		for(i =p;i<=r;i++)
			a[i]=tmp[i];

	}

	void quickSort1(int data[],int p,int r) {//pivot을 정하기 위한 매개변수x 추가

		if(p<r) {
			int q=Partiton1(data,p,r);//분할
			quickSort1(data,p,q-1);
			quickSort1(data,q+1,r);

		}

	}
	private int  Partiton1(int data[], int p, int r) {
		int x=data[r];
		int i=p-1,tmp=0;
		for(int j=p;j<r;j++) {
			if(data[j]<=x) { //pivot 보다 작거나 같다면
				i++;
				tmp=data[i];//i,j스왑
				data[i]=data[j];
				data[j]=tmp;
			}

		}
		tmp=data[i+1];
		data[i+1]=data[r];
		data[r]=tmp;

		return i+1;
	}

	void quickSort2(int data[],int p,int r) {//pivot을 정하기 위한 매개변수x 추가

		if(p<r) {
			int q=Partiton2(data,p,r);//분할
			quickSort2(data,p,q-1);
			quickSort2(data,q+1,r);

		}

	}
	private int  Partiton2(int data[], int p, int r) {

		int index=findMedian(data,p,(p+r)/2,r); //find median
		int x=0;
		int i=p-1,tmp=0;
		tmp=data[r];
		data[r]=data[index];
		data[index]=tmp;
		x=data[r];


		for(int j=p;j<r;j++) {
			if(data[j]<=x) { //pivot 보다 작거나 같다면
				i++;
				tmp=data[i];//i,j스왑
				data[i]=data[j];
				data[j]=tmp;
			}

		}
		tmp=data[i+1];
		data[i+1]=data[r];
		data[r]=tmp;

		return i+1;
	}

	int findMedian(int data[],int a,int b,int c){ //중간값의 인덱스를 리턴
		int n1=data[a],n2=data[b],n3=data[c];

		if((n1-n2)*(n1-n3)<=0) return a; //첫번째 인덱스가 중간값
		else if((n2-n1)*(n2-n3)<=0) return b; // 가운데 인덱스가 중간값
		else return c;

	}
	
	
	void quickSort3(int data[],int p,int r) {//pivot을 정하기 위한 매개변수x 추가

		if(p<r) {
			int q=Partiton3(data,p,r);//분할
			quickSort3(data,p,q-1);
			quickSort3(data,q+1,r);

		}

	}
	private int  Partiton3(int data[], int p, int r) {
	
		
		int randnum=(int)(Math.random()*(r-p))+p;
		int x;
		int i=p-1,tmp=0;
		
		tmp=data[r];
		data[r]=data[randnum];
		data[randnum]=tmp;
		
		x=data[r];
		for(int j=p;j<r;j++) {
			if(data[j]<=x) { //pivot 보다 작거나 같다면
				i++;
				tmp=data[i];//i,j스왑
				data[i]=data[j];
				data[j]=tmp;
			}

		}
		tmp=data[i+1];
		data[i+1]=data[r];
		data[r]=tmp;

		return i+1;
	}
	
	






}
