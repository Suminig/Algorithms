import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		LinkedList<Integer> students = new LinkedList<>();
		students.addFirst(1);
		st.nextToken();

		for (int i = 2; i <= N; i++) {
			students.add(Integer.parseInt(st.nextToken()), i);
		}

		for (int i = N - 1; i >= 0; i--) {
			sb.append(students.get(i)).append(" ");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}