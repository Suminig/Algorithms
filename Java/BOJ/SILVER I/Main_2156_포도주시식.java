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
		int[] arr = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		dp[0] = arr[0];
		for (int i = 1; i < N; i++) {
			if (i == 1) {
				dp[i] = arr[0] + arr[1];
			} else if (i == 2) {
				dp[i] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
			} else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
			}
		}

		sb.append(dp[N - 1]);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}