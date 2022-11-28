import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int N, M;
	private static char[][] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void dfs(int n, int x, int y) {
		if (n == 3) {
			arr[x][y] = '*';
			arr[x + 1][y - 1] = arr[x + 1][y + 1] = '*';
			arr[x + 2][y - 2] = arr[x + 2][y - 1] = arr[x + 2][y] = arr[x + 2][y + 1] = arr[x + 2][y + 2] = '*';

			return;
		}

		dfs(n / 2, x, y);
		dfs(n / 2, x + n / 2, y - n / 2);
		dfs(n / 2, x + n / 2, y + n / 2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		M = 2 * N - 1;
		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = ' ';
			}
		}

		dfs(N, 0, N - 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}