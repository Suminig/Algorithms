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
			int[] arr = new int[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				arr[A] = B;
			}

			int cnt = 1;
			int min = arr[1];
			for (int i = 2; i <= N; i++) {
				if (arr[i] <= min) {
					cnt++;
					min = arr[i];
				}
			}

			sb.append(cnt).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}