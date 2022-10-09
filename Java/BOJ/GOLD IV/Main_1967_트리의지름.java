import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
	private static int N, max, end;
	private static boolean[] visited;
	private static List<Node>[] nodes;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Node {
		int num, weight;

		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

	public static void dfs(int cur, int sum) {
		if (max < sum) {
			max = sum;
			end = cur;
		}

		visited[cur] = true;

		for (Node next : nodes[cur]) {
			if (visited[next.num])
				continue;
			dfs(next.num, sum + next.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		nodes = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodes[parent].add(new Node(child, weight));
			nodes[child].add(new Node(parent, weight));
		}

		// root 기준 제일 거리가 먼 end 노드를 구하기
		visited = new boolean[N + 1];
		dfs(1, 0);

		// end 노드 기준에서 다시 제일 거리가 먼 노드와 그 거리 구하기
		visited = new boolean[N + 1];
		dfs(end, 0);

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}