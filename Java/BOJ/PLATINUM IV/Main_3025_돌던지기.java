import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] map;
	private static ArrayDeque<int[]>[] paths;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void fall(int x, int y, int path) {
		paths[path].push(new int[] { x, y });

		if (x == R || map[x + 1][y] == 'X') {
			map[x][y] = 'O';
			return;
		}

		if (map[x + 1][y] == 'O') {
			if (y - 1 > 0 && map[x][y - 1] == '.' && map[x + 1][y - 1] == '.')
				fall(x + 1, y - 1, path);
			else if (y + 1 <= C && map[x][y + 1] == '.' && map[x + 1][y + 1] == '.')
				fall(x + 1, y + 1, path);
			else
				map[x][y] = 'O';
		} else {
			fall(x + 1, y, path);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			String line = in.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
		paths = new ArrayDeque[C + 1];
		for (int i = 1; i <= C; i++)
			paths[i] = new ArrayDeque<>();

		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int y = Integer.parseInt(in.readLine());

			if (paths[y].isEmpty())
				fall(0, y, y);
			else {
				while (map[paths[y].peek()[0]][paths[y].peek()[1]] != '.')
					paths[y].pop();

				fall(paths[y].peek()[0], paths[y].peek()[1], y);
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}