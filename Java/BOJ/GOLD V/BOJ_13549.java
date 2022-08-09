import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Node {
		int num;
		int time;

		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Node> q = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		q.offer(new Node(N, 0));
		int minTime = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node n = q.poll();
			visited[n.num] = true;

			if (n.num == K)
				minTime = Math.min(minTime, n.time);

			if (n.num * 2 <= 100000 && visited[n.num * 2] == false)
				q.offer(new Node((n.num * 2), n.time));
			if (n.num - 1 >= 0 && visited[n.num - 1] == false)
				q.offer(new Node((n.num - 1), n.time+1));
			if (n.num + 1 <= 100000 && visited[n.num + 1] == false)
				q.offer(new Node((n.num + 1), n.time+1));
		}
		sb.append(minTime);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}