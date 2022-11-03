import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static final long mod = 1_000_000_000;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());

		long[][] dp = new long[101][10];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					dp[i][j] = dp[i - 1][j + 1] % mod;
				else if (j == 9)
					dp[i][j] = dp[i - 1][j - 1] % mod;
				else
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}
		
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i] % mod;
		}
		
		sb.append(sum % mod);
		
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}