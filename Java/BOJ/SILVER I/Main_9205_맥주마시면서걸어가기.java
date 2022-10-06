import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(in.readLine());
			List<int[]> stores = new ArrayList<>();

			st = new StringTokenizer(in.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				stores.add(new int[] { x, y });
			}

			st = new StringTokenizer(in.readLine(), " ");
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());

			boolean isArrived = false;
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { startX, startY });
			while (!q.isEmpty()) {
				int[] cur = q.poll();

				if (dist(cur[0], cur[1], targetX, targetY) <= 1000) {
					isArrived = true;
					break;
				}

				for (int i = stores.size() - 1; i >= 0; i--) {
					if (dist(cur[0], cur[1], stores.get(i)[0], stores.get(i)[1]) <= 1000) {
						q.offer(new int[] { stores.get(i)[0], stores.get(i)[1] });
						stores.remove(i);
					}
				}
			}
			sb.append(isArrived ? "happy" : "sad").append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}