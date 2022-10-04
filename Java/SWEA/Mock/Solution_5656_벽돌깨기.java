import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	private static int N, W, H, min;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static boolean go(int[][] arr, int cnt) {
		int result = getRemain(arr);

		if (result == 0) {
			min = result;
			return true;
		}

		if (cnt == N) {
			min = min < result ? min : result;
			return false;
		}

		int[][] newArr = new int[H][W];
		for (int y = 0; y < W; y++) {
			int x = 0;
			while (x < H && arr[x][y] == 0)
				++x;
			if (x == H) {
				continue;
			} else {
				copy(arr, newArr);
				boom(newArr, x, y);
				down(newArr);
				if (go(newArr, cnt + 1))
					return true;
			}
		}
		return false;
	}

	private static int getRemain(int[][] arr) {
		int cnt = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				cnt = arr[i][j] > 0 ? cnt + 1 : cnt;
			}
		}
		return cnt;
	}

	private static void down(int[][] arr) {
		Stack<Integer> stack = new Stack<>();
		for (int y = 0; y < W; y++) {
			for (int x = 0; x < H; x++) {
				if (arr[x][y] > 0) {
					stack.push(arr[x][y]);
					arr[x][y] = 0;
				}
			}

			int nx = H - 1;
			while (!stack.isEmpty()) {
				arr[nx--][y] = stack.pop();
			}
		}
	}

	private static void boom(int[][] arr, int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		if (arr[x][y] > 1) {
			q.offer(new Point(x, y, arr[x][y]));
		}
		arr[x][y] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x;
				int ny = cur.y;
				for (int j = 1; j < cur.cnt; j++) {
					nx += dx[i];
					ny += dy[i];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && arr[nx][ny] > 0) {
						if (arr[nx][ny] > 1) {
							q.offer(new Point(nx, ny, arr[nx][ny]));
						}
						arr[nx][ny] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] arr, int[][] newArr) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
	}

	public static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			go(arr, 0);

			sb.append(min).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}