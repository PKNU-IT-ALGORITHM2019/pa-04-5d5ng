package pa4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	Scanner kb=new Scanner(System.in);
	int Buf=10000;
	Log [] logs=new Log[Buf];
	int n=0;
	int size;

	public static void main(String[] args) {
		Main app=new Main();
		app.process_command();

	}

	private  void process_command() {


		while(true) {
			System.out.print("$ ");
			String command=kb.next();

			if(command.equals("read")) {

				read();

			}

			else if(command.equals("print")) {
				print();

			}
			else if(command.equals("sort")) {
				sort();

			}
			else if(command.equals("exit")) {
				break;

			}

		}


		kb.close();
	}

	private void print() {

		for(int i=0;i<size;i++) {

			System.out.println(logs[i].time);
			System.out.println("  IP:"+logs[i].ip);
			System.out.println("  URL:"+logs[i].URL);
			System.out.println("  Status:"+logs[i].Status+"\n");

		}

	}

	private void sort() {
		String opt=kb.next();
		if(opt.equals("-t")) {

			process_time();

			Arrays.sort(logs, 0, size, Log.timeComparator);


		}
		else if(opt.equals("-ip")) {

			Arrays.sort(logs, 0, size, Log.ipComparator);


		}


	}

	private void process_time() {
		for(int i=0;i<size;i++) {
			String[]arr=logs[i].time.split("/"); 
			
				String timeofDay=arr[2].substring(arr[2].indexOf(":"));//년도와 시간을 분리
				String year=arr[2].substring(0,arr[2].indexOf(":"));
				logs[i].comparetime=year+MtoInt(arr[1])+arr[0]+timeofDay;//  달을 정수로 변환하는 MtoInt
				//년도 월 일 시간 순으로 정렬
				
				
				


		}
		
	}

	private String MtoInt(String str) {
		if (str.equalsIgnoreCase("Jan") )
			str="1";

		else if (str.equalsIgnoreCase("Feb") )
			str="2";

		else if (str.equalsIgnoreCase("Mar") )
			str="3";


		else if (str.equalsIgnoreCase("Apr") )

			str="4";

		else if (str.equalsIgnoreCase("May") )
			str="5";


		else if (str.equalsIgnoreCase("Jun") )
			str="6";


		else if (str.equalsIgnoreCase("Jul") )
			str="7";
		else if (str.equalsIgnoreCase("Aug") )
			str="8";
		else if (str.equalsIgnoreCase("Sep") )
			str="9";
		else if (str.equalsIgnoreCase("Oct") )
			str="10";
		else if (str.equalsIgnoreCase("Nov") )
			str="11";
		else if (str.equalsIgnoreCase("Dec") )
			str="12";

		return str;
		
	}

	private void read() {
		String myFile=kb.next();
		try {
			Scanner Fin=new Scanner(new File(myFile));
			String allStr=Fin.nextLine(); //한줄 띄우고받기

			while(Fin.hasNext()) {
				 allStr=Fin.nextLine();
				String[] arr=allStr.split(",");




				logs[n]=new Log();

				logs[n].ip=arr[0];
				logs[n].time=arr[1].substring(1);
				logs[n].URL=arr[2];
				logs[n].Status=arr[3];

				
				
				n++;
				if(n>=logs.length)
					reallocate();

			}
			size=n;
			Fin.close();
		} 
		catch (FileNotFoundException e) {

			System.out.println("No data file");
			e.printStackTrace();
		}


	}

	private void reallocate() {
		Buf*=2;
		Log [] temp=new Log[Buf];
		for(int i=0;i<n;i++)
			temp[i]=logs[i];
		
		logs=temp;
		
		
	}

}
