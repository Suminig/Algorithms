import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, minus, zero, plus;
	private static int[][] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void dfs(int x, int y, int n) {
		int cur = arr[x][y];

		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (arr[i][j] != cur) {
					dfs(x, y, n / 3);
					dfs(x, y + n / 3, n / 3);
					dfs(x, y + n / 3 * 2, n / 3);
					dfs(x + n / 3, y, n / 3);
					dfs(x + n / 3, y + n / 3, n / 3);
					dfs(x + n / 3, y + n / 3 * 2, n / 3);
					dfs(x + n / 3 * 2, y, n / 3);
					dfs(x + n / 3 * 2, y + n / 3, n / 3);
					dfs(x + n / 3 * 2, y + n / 3 * 2, n / 3);

					return;
				}
			}
		}

		if (cur == -1)
			minus += 1;
		else if (cur == 0)
			zero += 1;
		else
			plus += 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minus = zero = plus = 0;
		dfs(0, 0, N);

		sb.append(minus).append("\n").append(zero).append("\n").append(plus);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}