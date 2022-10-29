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

		st = new StringTokenizer(in.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[100001];
		int[][] costs = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken());
			int profit = Integer.parseInt(st.nextToken());

			costs[i] = new int[] { cost, profit };
		}

		for (int i = 1; i < 100001; i++) {
			for (int[] cost : costs) {
				if (i % cost[0] == 0)
					arr[i] = Math.max(arr[i], i / cost[0] * cost[1]);
				if (i - cost[0] >= 0)
					arr[i] = Math.max(arr[i], arr[i - cost[0]] + cost[1]);
			}

			if (arr[i] >= C) {
				sb.append(i);
				break;
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}