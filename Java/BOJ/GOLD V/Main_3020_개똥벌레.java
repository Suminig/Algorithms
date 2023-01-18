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

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int min = N;
		int cnt = 0;

		int[] down = new int[H + 2];
		int[] up = new int[H + 2];
		for (int i = 1; i <= N / 2; i++) {
			int a = Integer.parseInt(in.readLine());
			int b = H - Integer.parseInt(in.readLine()) + 1;

			down[a]++;
			up[b]++;
		}

		for (int i = 1; i <= H; i++) {
			down[i] += down[i - 1];
		}

		for (int i = H; i >= 1; i--) {
			up[i] += up[i + 1];
		}

		for (int i = 1; i <= H; i++) {
			int meet = (down[H] - down[i - 1]) + (up[1] - up[i + 1]);

			if (meet < min) {
				min = meet;
				cnt = 1;
			} else if (meet == min) {
				cnt++;
			}
		}

		sb.append(min).append(" ").append(cnt);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}