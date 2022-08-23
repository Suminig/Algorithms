import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, cnt;
	private static boolean[] visited;
	private static Node[] friends;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Node {
		int num;
		ArrayList<Integer> list;

		public Node(int num, ArrayList<Integer> list) {
			this.num = num;
			this.list = list;
		}
	}

	private static void dfs(int num, int depth) {
		if (depth == 4) {
			cnt++;
			return;
		}

		ArrayList<Integer> fList = friends[num].list;
		for (Integer x : fList) {
			if (visited[x])
				continue;

			visited[x] = true;
			dfs(x, depth + 1);
			visited[x] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		friends = new Node[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			friends[i] = new Node(i, new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			friends[A].list.add(B);
			friends[B].list.add(A);
		}

		for (int i = 0; i < N; i++) {
			if (cnt > 0)
				break;
				
			visited[i] = true;
			dfs(i, 0);
			visited[i] = false;
		}

		sb.append(cnt >= 1 ? 1 : 0);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}