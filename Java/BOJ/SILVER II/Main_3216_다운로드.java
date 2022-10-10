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
		int[] length = new int[N + 1];
		int[] time = new int[N + 1];
		int res = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			length[i + 1] = d;
			time[i] = v;
		}

		for (int i = N - 1; i >= 0; i--) {
			res += time[i] - length[i];
			res = res < 0 ? 0 : res;
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}