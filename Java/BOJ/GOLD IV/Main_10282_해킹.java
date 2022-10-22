import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 123456789;
	private static int N, D, C, cnt, last;
	private static ArrayList<int[]>[] list;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		dist[C] = 0;
		pq.offer(new int[] { C, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			int time = cur[1];

			if (dist[to] < time)
				continue;

			for (int[] next : list[to]) {
				int nextTo = next[0];
				int nextTime = next[1];

				if (time + nextTime < dist[nextTo]) {
					dist[nextTo] = time + nextTime;
					pq.offer(new int[] { nextTo, time + nextTime });
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (dist[i] != INF) {
				cnt++;
				last = Math.max(last, dist[i]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());

				list[B].add(new int[] { A, S });
			}

			cnt = last = 0;
			dijkstra();
			sb.append(cnt).append(" ").append(last).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}