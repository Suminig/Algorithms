import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static String res;
	private static char[] word1, word2, word3;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void bfs() {
		int size1 = word1.length;
		int size2 = word2.length;
		int size3 = word3.length;

		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[size1 + 1][size2 + 1];
		visited[0][0] = true;
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			if (x + y == size3) {
				res = "yes";
				break;
			}

			if (x < size1 && word3[x + y] == word1[x] && !visited[x + 1][y]) {
				visited[x + 1][y] = true;
				q.offer(new int[] { x + 1, y });
			}
			if (y < size2 && word3[x + y] == word2[y] && !visited[x][y + 1]) {
				visited[x][y + 1] = true;
				q.offer(new int[] { x, y + 1 });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			word1 = st.nextToken().toCharArray();
			word2 = st.nextToken().toCharArray();
			word3 = st.nextToken().toCharArray();

			res = "no";
			bfs();

			sb.append("Data set ").append(i).append(": ").append(res).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}