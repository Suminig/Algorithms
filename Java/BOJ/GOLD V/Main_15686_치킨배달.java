import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int minDist = Integer.MAX_VALUE;
	private static List<Axis> cities, chickens;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Axis {
		int x;
		int y;

		public Axis(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void comb(int cnt, int start, List<Axis> selected) {
		if (cnt == M) {
			int total = 0;
			for (Axis city : cities) {
				int temp = Integer.MAX_VALUE;
				for (Axis chicken : selected) {
					temp = Math.min(temp, Math.abs(city.x - chicken.x) + Math.abs(city.y - chicken.y));
				}
				total += temp;
			}
			minDist = Math.min(minDist, total);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			selected.add(chickens.get(i));
			comb(cnt + 1, i + 1, selected);
			selected.remove(selected.size()-1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cities = new ArrayList<>();
		chickens = new ArrayList<>();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cities.add(new Axis(i, j));
				else if (map[i][j] == 2)
					chickens.add(new Axis(i, j));
			}
		}

		comb(0, 0, new ArrayList<Axis>());

		sb.append(minDist);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}