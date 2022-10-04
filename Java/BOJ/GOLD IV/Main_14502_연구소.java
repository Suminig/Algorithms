import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, max;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[][] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int cntArea(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void copyArr(int[][] arr, int[][] newArr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
	}

	private static void bfs(int[][] arr) {
		int[][] newArr = new int[N][M];
		copyArr(arr, newArr);
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newArr[i][j] == 2)
					q.offer(new int[] { i, j });
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || newArr[nx][ny] == 1 || newArr[nx][ny] == 2)
					continue;

				newArr[nx][ny] = 2;
				q.offer(new int[] { nx, ny });
			}
		}

		int area = cntArea(newArr);
		max = max > area ? max : area;
	}

	public static void makeWall(int wall) {
		if (wall == 3) {
			bfs(arr);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					makeWall(wall + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		makeWall(0);
		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}