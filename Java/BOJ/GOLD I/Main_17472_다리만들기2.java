import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, cnt;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[] parents;
	private static int[][] arr, map;
	private static List<Edge> edgeList;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Edge implements Comparable<Edge> {
		int from, to, dist;

		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge e) {
			return this.dist == e.dist ? this.from - e.from : this.dist - e.dist;
		}
	}

	public static void make() {
		parents = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;

		return true;
	}

	public static void findIsland(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		map[x][y] = cnt;
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] > 0)
					continue;

				if (arr[nx][ny] == 1) {
					map[nx][ny] = cnt;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static void findDist() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;

				int island = map[i][j];
				for (int d = 0; d < 4; d++) {
					int nx = i;
					int ny = j;
					int dist = 0;

					while (true) {
						nx = nx + dx[d];
						ny = ny + dy[d];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							break;

						if (map[nx][ny] == 0) {
							dist++;
							continue;
						}

						if (map[nx][ny] > 0) {
							if (map[nx][ny] == island) {
								dist = 0;
								continue;
							} else {
								if (dist < 2)
									break;

								edgeList.add(new Edge(island, map[nx][ny], dist));
								break;
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && arr[i][j] == 1) {
					++cnt;
					findIsland(i, j);
				}
			}
		}

		edgeList = new ArrayList<>();
		findDist();
		make();
		Collections.sort(edgeList);
		int sum = -1;
		int connected = 0;

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				sum += edge.dist;
				if (++connected == cnt - 1)
					break;
			}
		}

		sb.append(connected == cnt - 1 && sum != -1 ? sum + 1 : -1);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}