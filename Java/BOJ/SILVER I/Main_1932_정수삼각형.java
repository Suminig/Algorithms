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
		int[][] arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			int idx = 0;
			st = new StringTokenizer(in.readLine(), " ");
			while (st.hasMoreElements()) {
				arr[i][idx++] = Integer.parseInt(st.nextToken());
			}
			continue;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == 0)
					arr[i][j] = arr[i][j] + arr[i - 1][j];
				else
					arr[i][j] = Math.max(arr[i][j] + arr[i - 1][j - 1], arr[i][j] + arr[i - 1][j]);
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[N - 1][i]);
		}

		sb.append(max);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}