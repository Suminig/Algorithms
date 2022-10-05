import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Minsik {
		int x, y, moved, keyCnt;
		boolean[] keys;

		public Minsik(int x, int y, int moved, boolean[] keys, int keyCnt) {
			this.x = x;
			this.y = y;
			this.moved = moved;
			this.keys = keys;
			this.keyCnt = keyCnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = 0, y = 0;
		int min = Integer.MAX_VALUE;
		char[][] arr = new char[N][M];
		boolean[][][] visited = new boolean[N][M][64];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j);
				if (arr[i][j] == '0') {
					x = i;
					y = j;
					arr[i][j] = '.';
				}
			}
		}

		Queue<Minsik> q = new ArrayDeque<>();
		q.offer(new Minsik(x, y, 0, new boolean[6], 0));
		visited[x][y][0] = true;
		while (!q.isEmpty()) {
			Minsik cur = q.poll();

			if (arr[cur.x][cur.y] == '1') {
				min = min < cur.moved ? min : cur.moved;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][cur.keyCnt] || arr[nx][ny] == '#')
					continue;

				char item = arr[nx][ny];
				Minsik next = new Minsik(nx, ny, cur.moved + 1, cur.keys.clone(), cur.keyCnt);
				if (item == 'a' || item == 'b' || item == 'c' || item == 'd' || item == 'e' || item == 'f') {
					if (!next.keys[item - 'a']) {
						next.keys[item - 'a'] = true;
						next.keyCnt = next.keyCnt | 1 << (item - 'a');
					}
				} else if (item == 'A' || item == 'B' || item == 'C' || item == 'D' || item == 'E' || item == 'F') {
					if (!next.keys[Character.toLowerCase(item) - 'a'])
						continue;
				}
				if (!visited[nx][ny][next.keyCnt]) {
					visited[nx][ny][next.keyCnt] = true;
					q.offer(next);
				}
			}
		}

		sb.append(min == Integer.MAX_VALUE ? -1 : min);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}