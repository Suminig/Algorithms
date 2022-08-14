import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;
		sb.append("<");
		for (int i = 1; i <= N; i++)
			q.add(i);
		while (!q.isEmpty()) {
			for (int i = 0; i < K; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll());
			if (q.size() == 0)
				sb.append(">");
			else
				sb.append(", ");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}