import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, D, ans;
	private static int[] castle;
	private static int[][] arr;
	private static ArrayList<int[]> combs;
	private static ArrayList<Enemy> enemies;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		castle = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			castle[i] = i;
		}

		combs = new ArrayList<>();
		comb(0, 0, new int[3]);

		for (int cmb = 0, size = combs.size(); cmb < size; cmb++) {
			int[] archers = combs.get(cmb);
			int cnt = 0;
			enemies = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						enemies.add(new Enemy(i, j, 0));
					}
				}
			}

			while (!enemies.isEmpty()) {
				HashSet<Enemy> delete = new HashSet<>();
				for (int k = 0; k < 3; k++) {
					for (Enemy e : enemies) {
						e.d = dist(e.x, e.y, N, archers[k]);
					}
					Collections.sort(enemies);
					if (enemies.get(0).d <= D) {
						delete.add(enemies.get(0));
					} else {
						continue;
					}
				}

				for (Enemy enemy : delete) {
					cnt++;
					enemies.remove(enemy);
				}
				
				for (int i = enemies.size() - 1; i >= 0; i--) {
					if (enemies.get(i).x + 1 >= N) {
						enemies.remove(i);
					} else {
						enemies.get(i).x++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static class Enemy implements Comparable<Enemy> {
		int x, y, d;

		public Enemy(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Enemy o) {
			return this.d == o.d ? this.y - o.y : this.d - o.d;
		}
	}

	private static void comb(int cnt, int start, int[] cur) {
		if (cnt == 3) {
			combs.add(cur.clone());
			return;
		}

		for (int i = start; i < M; i++) {
			cur[cnt] = castle[i];
			comb(cnt + 1, i + 1, cur);
		}
	}

	private static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}