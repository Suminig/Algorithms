import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 987654321;
	private static int max;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] items = new int[N + 1];
		int[][] arr = new int[N + 1][N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());

			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			arr[A][B] = L;
			arr[B][A] = L;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		max = 0;
		for (int i = 1; i <= N; i++) {
			int sum = items[i];
			for (int j = 1; j <= N; j++) {
				if(arr[i][j] == 0 || arr[i][j] == INF || arr[i][j] > M)
					continue;

				sum += items[j];
			}
			max = Math.max(max, sum);
		}
		
		sb.append(max);
		
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}