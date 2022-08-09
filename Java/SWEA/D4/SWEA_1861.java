import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static StringTokenizer st;
	private static int length;
	private static int maxLength;
	private static int max;
	private static StringBuilder sb = new StringBuilder();

	public static void dfs(int[][] arr, int x, int y) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr.length) {
				if (arr[nx][ny] - arr[x][y] == 1) {
					length++;
					dfs(arr, nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			maxLength = max = 0;
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					length = 1;
					dfs(arr, i, j);
					if (length > maxLength) {
						maxLength = length;
						max = arr[i][j];
					} else if (length == maxLength) {
						max = Math.min(max, arr[i][j]);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append(" ").append(maxLength).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}