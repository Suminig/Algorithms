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
		int[][] dp = new int[30][30];
		for (int i = 1; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				if (i == 1)
					dp[i][j] = j;
				else {
					if (i == j)
						dp[i][j] = 1;
					else if (i < j)
						dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				}
			}
		}

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(dp[N][M]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}