import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int[][] arr;
	private static StringBuilder sb = new StringBuilder();

	private static void quadTree(int x, int y, int N) {
		int cur = arr[x][y];
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (arr[i][j] != cur) {
					sb.append("(");
					quadTree(x, y, N / 2);
					quadTree(x, y + N / 2, N / 2);
					quadTree(x + N / 2, y, N / 2);
					quadTree(x + N / 2, y + N / 2, N / 2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(cur);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(line.charAt(j) + "");
			}
		}

		quadTree(0, 0, N);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}