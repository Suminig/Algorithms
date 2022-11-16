import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, min;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { 0, -1, 0, 1, 0 }, dy = { 0, 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static boolean check(int i, int j) {
		for (int d = 0; d < 5; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (visited[nx][ny])
				return false;
		}
		return true;
	}

	public static int visit(int i, int j) {
		int sum = 0;
		for (int d = 0; d < 5; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			sum += arr[nx][ny];
			visited[nx][ny] = !visited[nx][ny];
		}

		return sum;
	}

	public static void dfs(int cnt, int sum) {
		if (sum > min)
			return;

		if (cnt == 3) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (check(i, j)) {
					dfs(cnt + 1, sum + visit(i, j));
					visit(i, j);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		visited = new boolean[N][N];
		dfs(0, 0);

		sb.append(min);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}