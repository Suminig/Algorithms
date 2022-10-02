import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Solution {
	private static int N;
	private static int[][] arr, dp;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
					dp[i][j] = Integer.MAX_VALUE;
				}
			}

			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { 0, 0 });
			dp[0][0] = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;

					if (dp[nx][ny] > dp[x][y] + arr[nx][ny]) {
						dp[nx][ny] = dp[x][y] + arr[nx][ny];
						q.offer(new int[] { nx, ny });
					}
				}
			}
			sb.append(dp[N - 1][N - 1]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}