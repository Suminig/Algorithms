import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			if (i % 6 == 0) {
				dp[i] = Math.min(Math.min(dp[i - 1] + 1, dp[i / 2] + 1), Math.min(dp[i - 1] + 1, dp[i / 3] + 1));
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		sb.append(dp[N]);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}