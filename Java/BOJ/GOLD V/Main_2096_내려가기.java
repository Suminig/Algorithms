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

		int N = Integer.parseInt(in.readLine());
		int[][] dpMin = new int[N][3];
		int[][] dpMax = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				dpMin[i][j] = Integer.parseInt(st.nextToken());
				dpMax[i][j] = dpMin[i][j];
			}
		}

		int min = 1000000;
		int max = -1;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dpMin[i][j] += Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]);
					dpMax[i][j] += Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]);
				} else if (j == 1) {
					dpMin[i][j] += Math.min(dpMin[i - 1][j - 1], Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]));
					dpMax[i][j] += Math.max(dpMax[i - 1][j - 1], Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]));
				} else {
					dpMin[i][j] += Math.min(dpMin[i - 1][j - 1], dpMin[i - 1][j]);
					dpMax[i][j] += Math.max(dpMax[i - 1][j - 1], dpMax[i - 1][j]);
				}

			}
		}

		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dpMin[N - 1][i]);
			max = Math.max(max, dpMax[N - 1][i]);
		}

		sb.append(max).append(" ").append(min);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}