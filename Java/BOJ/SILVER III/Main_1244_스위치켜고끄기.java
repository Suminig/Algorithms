import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] switches = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(in.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % pos == 0) {
						switches[j - 1] = (switches[j - 1] == 0) ? 1 : 0;
					}
				}
			} else if (gender == 2) {
				int cur = pos - 1;
				for (int j = 0; j < N; j++) {
					if (cur - j < 0 || cur + j >= N) {
						break;
					}

					if (switches[cur - j] == switches[cur + j]) {
						switches[cur - j] = (switches[cur - j] == 0) ? 1 : 0;
						switches[cur + j] = (switches[cur + j] == 0) ? 1 : 0;
						continue;
					}

					break;
				}
				switches[cur] = (switches[cur] == 0) ? 1 : 0;
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(switches[i]).append(" ");
			if ((i+1) % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}