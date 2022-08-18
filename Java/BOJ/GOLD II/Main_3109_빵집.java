import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, ans;
	private static boolean flag;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, 0, 1 }, dy = { 1, 1, 1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int x, int y) {
		if (visited[x][y])
			return;
		else
			visited[x][y] = true;

		if (map[x][y] == 'x')
			return;

		if (y == C - 1) {
			ans++;
			flag = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R)
				continue;

			if (!visited[nx][ny]) {
				dfs(nx, ny);
				if (flag)
					return;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		ans = 0;
		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}