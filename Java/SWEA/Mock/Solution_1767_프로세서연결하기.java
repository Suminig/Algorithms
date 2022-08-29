import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_전원연결 {
	private static int N, coreNum, maxNumCore, minLength;
	private static boolean[] isVisited;
	private static ArrayList<boolean[]> subsets;
	private static Pair[] cores;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[][] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void subset(int cnt) {
		if (cnt == coreNum) {
			subsets.add(isVisited.clone());
			return;
		}

		isVisited[cnt] = true;
		subset(cnt + 1);
		isVisited[cnt] = false;
		subset(cnt + 1);
	}

	public static boolean[][] copyVisited(boolean[][] oldVisited) {
		boolean[][] temp = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = oldVisited[i][j];
			}
		}
		return temp;
	}

	public static void dfs(int cnt, int sum, int cntTrue, boolean[] subset, boolean[][] visited) {
		if (cnt == coreNum) {
			if (cntTrue >= maxNumCore && sum < minLength) {
				maxNumCore = cntTrue;
				minLength = sum;
			}
			return;
		}

		if (subset[cnt]) {
			Pair cur = cores[cnt];
			int x = cur.x;
			int y = cur.y;

			for (int i = 0; i < 4; i++) {
				int nx = x;
				int ny = y;

				boolean[][] tempVisited = copyVisited(visited);
				boolean flag = true;
				int length = 0;

				while (true) {
					nx += dx[i];
					ny += dy[i];

					length++;
					tempVisited[nx][ny] = true;

					if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == 1 || visited[nx][ny]) {
						flag = false;
						break;
					}

					if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
						break;
					}

				}

				if (flag) {
					dfs(cnt + 1, sum + length, cntTrue, subset, tempVisited);
				}
			}
		} else {
			dfs(cnt + 1, sum, cntTrue, subset, visited);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			coreNum = 0;
			cores = new Pair[12];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && i != N - 1 && j != 0 && j != N - 1 && arr[i][j] == 1) {
						cores[coreNum++] = new Pair(i, j);
					}
				}
			}

			subsets = new ArrayList<>();
			isVisited = new boolean[coreNum];
			subset(0);

			minLength = Integer.MAX_VALUE;
			maxNumCore = 0;
			for (boolean[] subset : subsets) {
				int cntTrue = 0;
				for (boolean x : subset) {
					if (x)
						cntTrue++;
				}
				dfs(0, 0, cntTrue, subset, new boolean[N][N]);
			}
			sb.append("#").append(tc).append(" ").append(minLength).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}