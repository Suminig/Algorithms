import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int ans = 0;
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			boolean[][] arr = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				arr[A][B] = true;
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (arr[i][k] && arr[k][j])
							arr[i][j] = true;
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] || arr[j][i])
						cnt++;
				}
				if (cnt == N - 1)
					ans++;
			}
			sb.append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}