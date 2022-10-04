import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;

			if (!(obj instanceof Pair))
				return false;

			Pair other = (Pair) obj;

			return Integer.compare(x, other.x) == 0 && Integer.compare(y, other.y) == 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		int N, M, K;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ArrayList<Pair> cabbages = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				cabbages.add(new Pair(x, y));
			}

			int cnt = 0;
			while (!cabbages.isEmpty()) {
				Queue<Pair> q = new ArrayDeque<>();
				q.offer(cabbages.remove(0));
				cnt++;
				while (!q.isEmpty()) {
					Pair cur = q.poll();
					int x = cur.x;
					int y = cur.y;

					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M || !cabbages.contains(new Pair(nx, ny)))
							continue;

						cabbages.remove(cabbages.indexOf(new Pair(nx, ny)));
						q.offer(new Pair(nx, ny));
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}