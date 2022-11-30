import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		ArrayList<int[]>[] edgeList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			edgeList[from].add(new int[] { to, dist });
		}

		st = new StringTokenizer(in.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a1, int[] a2) {
				return a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1];
			}
		});
		int[] d = new int[N + 1];
		int[] path = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(d, 1000000001);
		d[start] = 0;
		path[start] = 0;

		pq.offer(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			int dist = cur[1];

			if (visited[to])
				continue;
			else
				visited[to] = true;

			for (int[] next : edgeList[to]) {
				int nextTo = next[0];
				int nextDist = next[1];
				if (d[to] + nextDist < d[nextTo]) {
					path[nextTo] = to;
					d[nextTo] = d[to] + nextDist;
					pq.offer(new int[] { nextTo, d[nextTo] });
				}
			}
		}

		sb.append(d[end]).append("\n");
		Stack<Integer> pathEdge = new Stack<>();
		while (end != 0) {
			pathEdge.add(end);
			end = path[end];
		}

		sb.append(pathEdge.size()).append("\n");
		while (!pathEdge.isEmpty()) {
			sb.append(pathEdge.pop()).append(" ");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}