import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N = 9;
	private static int[][] arr = new int[10][10];
	private static boolean[][] row = new boolean[10][10], col = new boolean[10][10], sqr = new boolean[10][10];
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int square(int x, int y) {
		return (x / 3) * 3 + (y / 3);
	}

	public static boolean solve(int z) {
		if (z == N * N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			return true;
		}

		int x = z / N;
		int y = z % N;
		if (arr[x][y] != 0) {
			return solve(z + 1);
		} else {
			for (int i = 1; i <= N; i++) {
				if (!row[x][i] && !col[y][i] && !sqr[square(x, y)][i]) {
					row[x][i] = true;
					col[y][i] = true;
					sqr[square(x, y)][i] = true;
					arr[x][y] = i;

					if (solve(z + 1))
						return true;

					arr[x][y] = 0;
					row[x][i] = false;
					col[y][i] = false;
					sqr[square(x, y)][i] = false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					row[i][arr[i][j]] = true;
					col[j][arr[i][j]] = true;
					sqr[square(i, j)][arr[i][j]] = true;
				}
			}
		}

		solve(0);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}