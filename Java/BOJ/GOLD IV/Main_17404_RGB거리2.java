import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 1000 * 1000 + 1;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		int min = INF;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)
					dp[1][j] = arr[1][j];
				else
					dp[1][j] = INF;
			}

			for (int j = 2; j <= N; j++) {
				dp[j][0] = arr[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
				dp[j][1] = arr[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
				dp[j][2] = arr[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
			}

			for (int j = 0; j < 3; j++) {
				if (i != j && min > dp[N][j])
					min = dp[N][j];
			}
		}

		sb.append(min);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}