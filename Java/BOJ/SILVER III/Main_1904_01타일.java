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
		int[] dp = new int[1000001];
		dp[1] = 1 % 15746;
		dp[2] = 2 % 15746;
		for (int i = 3; i < 1000001; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}

		sb.append(dp[N]);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}