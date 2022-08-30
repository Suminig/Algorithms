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
		String[] log = new String[N + 1];
		dp[0] = 0;
		log[0] = "";
		dp[1] = 0;
		log[1] = "1";

		for (int i = 2; i <= N; i++) {
			int cnt = Integer.MAX_VALUE;
			int idx = 0;

			if (i % 3 == 0) {
				cnt = dp[i / 3];
				idx = i / 3;
			}

			if (i % 2 == 0) {
				if (cnt > dp[i / 2]) {
					cnt = dp[i / 2];
					idx = i / 2;
				}
			}

			if (cnt > dp[i - 1]) {
				cnt = dp[i - 1];
				idx = i - 1;
			}

			dp[i] = dp[idx] + 1;
			log[i] = i + " " + log[idx];
		}

		sb.append(dp[N]).append("\n").append(log[N]).append("\n");

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}