import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = 0;

		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;

			sb.append("Problem ").append(++tc).append(": ");
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] dx = { -1, 0, 0, 1 }, dy = { 0, 1, -1, 0 };
			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] arr1, int[] arr2) {
					return arr1[2] - arr2[2];
				}
			});
			pq.offer(new int[] { 0, 0, arr[0][0] });
			dist[0][0] = arr[0][0];

			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int x = cur[0];
				int y = cur[1];
				int weight = cur[2];

				if (x == N - 1 && y == N - 1)
					break;

				if (dist[x][y] < weight)
					continue;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;

					if (arr[nx][ny] + weight < dist[nx][ny]) {
						dist[nx][ny] = arr[nx][ny] + weight;
						pq.offer(new int[] { nx, ny, arr[nx][ny] + weight });
					}
				}
			}
			sb.append(dist[N - 1][N - 1]).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}