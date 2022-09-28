import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	private static PriorityQueue<Integer> pq;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(in.readLine());

			if (cur == 0) {
				if (pq.isEmpty())
					sb.append(cur).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			} else {
				pq.add(cur);
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}