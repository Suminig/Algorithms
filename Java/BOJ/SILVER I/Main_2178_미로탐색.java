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
		int x, y, move;

		public Node(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line.charAt(j) + "");
			}
		}

		int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 1));
		visited[0][0] = true;
		int moved = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int x = cur.x, y = cur.y, move = cur.move;
			if (x == N - 1 && y == M - 1) {
				moved = move;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (arr[nx][ny] == 1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, move + 1));
				}
			}
		}

		sb.append(moved);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}