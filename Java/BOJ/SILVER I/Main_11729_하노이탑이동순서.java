import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int cnt;
	private static StringBuilder sb = new StringBuilder();
	
	public static void move(int start, int end) {
		cnt++;
		sb.append(start).append(" ").append(end).append("\n");
	}
	
	public static void hanoi(int n, int start, int end, int temp) {
		if(n == 1) {
			move(start, end);
			return;
		} else {
			hanoi(n-1, start, temp, end);
			move(start, end);
			hanoi(n-1, temp, end, start);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		cnt = 0;
		hanoi(N, 1, 3, 2);
		
		out.write(cnt + "\n" + sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}