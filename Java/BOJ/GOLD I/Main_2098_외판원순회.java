import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 16_000_000;
	private static int N;
	private static int[][] arr, dp;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int dfs(int city, int flag) {
		if (flag == ((1 << N) - 1)) {
			if (arr[city][0] == 0)
				return INF;

			return arr[city][0];
		}

		if (dp[city][flag] != 0) {
			return dp[city][flag];
		}

		dp[city][flag] = INF;

		for (int i = 0; i < N; i++) {
			if (arr[city][i] != 0 && (flag & (1 << i)) == 0) {
				int next = dfs(i, flag | (1 << i));

				if (next > 0)
					dp[city][flag] = Math.min(dp[city][flag], next + arr[city][i]);
			}
		}

		return dp[city][flag];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		dp = new int[N][(1 << N) - 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sb.append(dfs(0, 1));

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}