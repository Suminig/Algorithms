import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] parents;
	private static List<Integer> list;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int find(int x) {
		if (parents[x] == x)
			return x;

		return find(parents[x]);
	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (list.contains(rootY)) {
			int temp = rootX;
			rootX = rootY;
			rootY = temp;
		}

		parents[rootY] = rootX;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(in.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		if (num == 0) {
			sb.append(M);
		} else {
			for (int i = 0; i < num; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			List<Integer>[] parties = new ArrayList[M];
			for (int i = 0; i < M; i++) {
				parties[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int partyNum = Integer.parseInt(st.nextToken());

				int x = Integer.parseInt(st.nextToken());
				parties[i].add(x);
				for (int j = 1; j < partyNum; j++) {
					int y = Integer.parseInt(st.nextToken());
					union(x, y);
					parties[i].add(y);
				}
			}

			int cnt = 0;
			for (int i = 0; i < M; i++) {
				boolean flag = true;
				for (int x : parties[i]) {
					if (list.contains(find(parents[x]))) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;
			}

			sb.append(cnt);
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}