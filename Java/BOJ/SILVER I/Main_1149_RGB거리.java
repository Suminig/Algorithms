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
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
			arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
			arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
		}

		int ans = arr[N - 1][0];
		ans = Math.min(ans, arr[N - 1][1]);
		ans = Math.min(ans, arr[N - 1][2]);
		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}