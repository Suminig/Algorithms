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

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[2][N];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (N > 1) {
				arr[0][1] += arr[1][0];
				arr[1][1] += arr[0][0];

				for (int i = 2; i < N; i++) {
					arr[0][i] += Math.max(arr[1][i - 2], arr[1][i - 1]);
					arr[1][i] += Math.max(arr[0][i - 2], arr[0][i - 1]);
				}
			}

			sb.append(arr[0][N - 1] < arr[1][N - 1] ? arr[1][N - 1] : arr[0][N - 1]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}