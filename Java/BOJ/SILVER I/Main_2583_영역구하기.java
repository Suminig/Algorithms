import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int bfs(Node node) {
		int total = 1;
		Deque<Node> q = new ArrayDeque<>();
		q.offer(node);
		visited[node.x][node.y] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (arr[nx][ny] == 0 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
					total++;
				}
			}
		}
		return total;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					if (arr[i][j] == 0)
						arr[i][j] = 1;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0 && visited[i][j] == false) {
					list.add(bfs(new Node(i, j)));
				}
			}
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (Integer x : list) {
			sb.append(x).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}