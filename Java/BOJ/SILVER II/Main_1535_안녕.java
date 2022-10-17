import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int HP = 99;
		int N = Integer.parseInt(in.readLine());
		int[] lost = new int[N + 1];
		int[] gain = new int[N + 1];
		int[][] dp = new int[N + 1][HP + 1];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++)
			lost[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++)
			gain[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= HP; j++) {
				if (j < lost[i])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - lost[i]] + gain[i]);
			}
		}

		sb.append(dp[N][HP]);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}