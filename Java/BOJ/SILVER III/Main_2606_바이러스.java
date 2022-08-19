import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Com {
		int num;
		ArrayList<Integer> connected = new ArrayList<>();

		public Com(int num, ArrayList<Integer> connected) {
			super();
			this.num = num;
			this.connected = connected;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		Com[] coms = new Com[N + 1];
		for (int i = 1; i <= N; i++) {
			coms[i] = new Com(i, new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			coms[A].connected.add(B);
			coms[B].connected.add(A);
		}

		int cnt = 0;
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Integer idx : coms[cur].connected) {
				if (!visited[idx]) {
					cnt++;
					visited[idx] = true;
					q.offer(idx);
				}
			}
		}

		sb.append(cnt);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}