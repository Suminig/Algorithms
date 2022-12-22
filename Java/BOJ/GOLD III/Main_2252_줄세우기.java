import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] degree = new int[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			list[A].add(B);
			degree[B]++;
		}

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			sb.append(cur).append(" ");

			for (Integer next : list[cur]) {
				degree[next]--;

				if (degree[next] == 0)
					q.offer(next);
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}