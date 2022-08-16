import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, r, c, ans;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void zVisit(int N, int r, int c) {
		if (N == 0)
			return;
		
		int half = ((int) Math.pow(2, N)) / 2;
		int square = half * half;
		N -= 1;

		if (r < half && c < half) {
			ans += square * 0;
			zVisit(N, r, c);
		} else if (r < half && c >= half) {
			ans += square * 1;
			zVisit(N, r, c - half);
		} else if (r >= half && c < half) {
			ans += square * 2;
			zVisit(N, r - half, c);
		} else {
			ans += square * 3;
			zVisit(N, r - half, c - half);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ans = 0;

		zVisit(N, r, c);

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}