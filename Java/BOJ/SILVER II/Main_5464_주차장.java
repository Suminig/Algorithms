import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] parking = new int[N];
		int[] used = new int[N];
		for (int i = 0; i < N; i++) {
			parking[i] = Integer.parseInt(in.readLine());
		}
		int[] cars = new int[M];
		for (int i = 0; i < M; i++) {
			cars[i] = Integer.parseInt(in.readLine());
		}
		Queue<Integer> q = new ArrayDeque<>();
		int sum = 0;

		for (int i = 0; i < 2 * M; i++) {
			int cur = Integer.parseInt(in.readLine());
			if (cur > 0) {
				int index = 0;
				while (used[index] != 0) {
					index++;
					if (index == N) {
						q.add(cur);
						break;
					}
				}
				if (index < N)
					used[index] = cur;
			} else if (cur < 0) {
				cur *= -1;
				for (int j = 0; j < N; j++) {
					if (used[j] == cur) {
						sum += cars[cur - 1] * parking[j];
						if (!q.isEmpty()) {
							used[j] = q.poll();
						} else {
							used[j] = 0;
						}
					}
				}
			}
		}
		sb.append(sum);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}