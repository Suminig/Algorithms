import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> sums = new ArrayList<>();
		sums.add(0);
		for (int i = 0; i < N; i++) {
			sums.add(sums.get(sums.size() - 1) + arr[i]);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(sums.get(y) - sums.get(x - 1)).append("\n");
		}
		System.out.println(sb);
	}
}