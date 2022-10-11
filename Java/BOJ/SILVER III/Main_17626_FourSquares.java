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
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int root = (int) Math.sqrt(i);

			if (root * root == i)
				dp[i] = 1;
			else {
				dp[i] = Integer.MAX_VALUE;
				for (int j = 1; j <= root; j++) {
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}

		sb.append(dp[N]);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}