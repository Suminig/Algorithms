import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		Queue<Integer> q = new ArrayDeque<>();

		int N = Integer.parseInt(in.readLine());
		while (true) {
			int num = Integer.parseInt(in.readLine());

			if (num == -1)
				break;

			if (num == 0) {
				q.poll();
				continue;
			}

			if (q.size() < N)
				q.offer(num);
		}

		if (q.isEmpty()) {
			sb.append("empty");
		} else {
			while (!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}