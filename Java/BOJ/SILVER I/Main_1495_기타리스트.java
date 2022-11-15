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

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[N + 1][M + 1];
		dp[0][S] = true;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (!dp[i - 1][j])
					continue;

				if (j + arr[i - 1] <= M) {
					dp[i][j + arr[i - 1]] = true;
				}
				if (j - arr[i - 1] >= 0) {
					dp[i][j - arr[i - 1]] = true;
				}
			}
		}

		int res = -1;
		for (int i = M; i >= 0; i--) {
			if (dp[N][i]) {
				res = i;
				break;
			}
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}