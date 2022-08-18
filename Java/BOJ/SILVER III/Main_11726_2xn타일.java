import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int[] dp = new int[1001];
		dp[1] = 1 % 10007;
		dp[2] = 2 % 10007;
		
		for (int i = 3; i <= 1000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		
		sb.append(dp[Integer.parseInt(in.readLine())]);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}