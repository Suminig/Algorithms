import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static StringTokenizer st;
	private static int maxWeight;
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int cnt, int idx, int weight, int[] arr, int N, int M) {
		if (weight > M)
			return;

		if (cnt == 2) {
			maxWeight = Math.max(maxWeight, weight);
			return;
		}

		if (idx == N)
			return;

		dfs(cnt + 1, idx + 1, weight + arr[idx], arr, N, M);
		dfs(cnt, idx + 1, weight, arr, N, M);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			maxWeight = -1;
			dfs(0, 0, 0, arr, N, M);
			sb.append("#").append(tc).append(" ").append(maxWeight).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}