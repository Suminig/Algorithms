import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int S = Integer.parseInt(in.readLine());

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 1, 0 });
		boolean[][] visited = new boolean[2001][2001];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int time = cur[0];
			int emoticon = cur[1];
			int clipboard = cur[2];

			if (emoticon == S) {
				sb.append(time);
				break;
			}

			if (emoticon > 0 && emoticon < 2000) {
				if (!visited[emoticon][emoticon]) {
					visited[emoticon][emoticon] = true;
					q.offer(new int[] { time + 1, emoticon, emoticon });
				}

				if (!visited[emoticon - 1][clipboard]) {
					visited[emoticon - 1][clipboard] = true;
					q.offer(new int[] { time + 1, emoticon - 1, clipboard });
				}
			}

			if (clipboard > 0 && emoticon + clipboard < 2000) {
				if (!visited[emoticon + clipboard][clipboard]) {
					visited[emoticon + clipboard][clipboard] = true;
					q.offer(new int[] { time + 1, emoticon + clipboard, clipboard });
				}
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}