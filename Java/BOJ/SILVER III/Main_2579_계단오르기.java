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
		int[] arr = new int[N + 2];
		int[] dp = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2]);
		}

		sb.append(dp[N]);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}