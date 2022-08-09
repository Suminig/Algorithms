import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static int cnt;
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int N, int sum) {
		if (sum > N)
			return;

		if (sum == N) {
			cnt++;
			return;
		}

		dfs(N, sum + 1);
		dfs(N, sum + 2);
		dfs(N, sum + 3);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			cnt = 0;
			dfs(N, 0);
			sb.append(cnt).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}