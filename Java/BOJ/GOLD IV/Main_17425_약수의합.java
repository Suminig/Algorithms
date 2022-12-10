import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static final int SIZE = 1_000_001;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] dp = new long[SIZE];
		Arrays.fill(dp, 1);

		for (int i = 2; i < SIZE; i++) {
			for (int j = 0; j * i < SIZE; j++) {
				dp[i * j] += i;
			}
			dp[i] = dp[i - 1] + dp[i];
		}

		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());

			sb.append(dp[num]).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}