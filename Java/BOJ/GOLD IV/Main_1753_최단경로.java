import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());

		ArrayList<int[]>[] edgeList = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList[from].add(new int[] { weight, to });
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[K] = 0;
		pq.offer(new int[] { 0, K });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int weight = cur[0];
			int to = cur[1];

			if (dist[to] < weight)
				continue;

			for (int[] next : edgeList[to]) {
				int nextWeight = next[0];
				int nextTo = next[1];
				if (weight + nextWeight < dist[nextTo]) {
					dist[nextTo] = weight + nextWeight;
					pq.offer(new int[] { weight + nextWeight, nextTo });
				}
			}
		}

		for (int i = 1; i < V + 1; i++) 
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}