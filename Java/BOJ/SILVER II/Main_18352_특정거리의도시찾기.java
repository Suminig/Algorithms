import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Node {
		int num;
		Node next;

		public Node(int num, Node next) {
			this.num = num;
			this.next = next;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adjList[A] = new Node(B, adjList[A]);
		}

		ArrayList<Integer> ans = new ArrayList<>();
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(new int[] { 0, X });
		visited[X] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int dist = cur[0];
			int num = cur[1];

			if (dist == K)
				ans.add(num);
			else if (dist > K)
				continue;

			for (Node nextNode = adjList[num]; nextNode != null; nextNode = nextNode.next) {
				if (visited[nextNode.num])
					continue;

				visited[nextNode.num] = true;
				q.add(new int[] { dist + 1, nextNode.num });
			}
		}

		if (ans.isEmpty()) {
			sb.append(-1);
		} else {
			Collections.sort(ans);
			for (int i = 0; i < ans.size(); i++) {
				sb.append(ans.get(i)).append("\n");
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}