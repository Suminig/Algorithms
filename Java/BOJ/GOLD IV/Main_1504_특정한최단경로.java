import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 123456789;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			arr[from][to] = weight;
			arr[to][from] = weight;
		}

		st = new StringTokenizer(in.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
				}
			}
		}

		int result = INF;
		if (arr[1][v1] < INF && arr[v1][v2] < INF && arr[v2][N] < INF)
			result = Math.min(result, arr[1][v1] + arr[v1][v2] + arr[v2][N]);

		if (arr[1][v2] < INF && arr[v2][v1] < INF && arr[v1][N] < INF)
			result = Math.min(result, arr[1][v2] + arr[v2][v1] + arr[v1][N]);

		sb.append(result == INF ? -1 : result);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}