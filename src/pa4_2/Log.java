package pa4_2;

import java.util.Comparator;

public class Log {


	String ip;
	String time;
	String URL;
	String Status;
	String comparetime; //�ð������͸� ����Ͻð������� �����Ͽ�����
	

	public static Comparator<Log> ipComparator = new Comparator<Log>() {
		@Override
		public int compare(Log L1, Log L2) {
			return L1.ip.compareTo(L2.ip);
		}
	};
	
	public static Comparator<Log> timeComparator = new Comparator<Log>() {
		@Override
		public int compare(Log L1, Log L2) {
			return L1.comparetime.compareTo(L2.comparetime);
		}
	};

}
