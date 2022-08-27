import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static int N, minTime, nums;
	private static boolean[][] visited;
	private static Pair hunter;
	private static Pair[] monsters, customers;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int dist(Pair p1, Pair p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static void dfs(Pair cur, int cntMonster, int cntCustomer, int sum) {
		if (cntMonster == nums && cntCustomer == nums) {
			minTime = Math.min(minTime, sum);
			return;
		}

		for (int i = 1; i <= nums; i++) {
			if (!visited[i][0]) {
				visited[i][0] = true;
				dfs(monsters[i], cntMonster + 1, cntCustomer, sum + dist(cur, monsters[i]));
				visited[i][0] = false;
			}

			if (!visited[i][1] && visited[i][0]) {
				visited[i][1] = true;
				dfs(customers[i], cntMonster, cntCustomer + 1, sum + dist(cur, customers[i]));
				visited[i][1] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			hunter = new Pair(1, 1);
			minTime = Integer.MAX_VALUE;
			nums = 0;
			monsters = new Pair[5];
			customers = new Pair[5];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					int cur = Integer.parseInt(st.nextToken());
					if (cur > 0) {
						monsters[cur] = new Pair(i, j);
						nums++;
					} else if (cur < 0)
						customers[cur * -1] = new Pair(i, j);
				}
			}

			for (int i = 1; i <= nums; i++) {
				visited = new boolean[nums + 1][2];
				visited[i][0] = true;
				dfs(monsters[i], 1, 0, dist(hunter, monsters[i]));
			}
			sb.append("#").append(tc).append(" ").append(minTime).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}