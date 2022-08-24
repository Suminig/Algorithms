import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		int sharkX = 0, sharkY = 0, sharkSize = 2, sharkEat = 0, sharkMove = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					arr[i][j] = 0;
				}
			}
		}

		int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
		while (true) {
			ArrayList<int[]> fish = new ArrayList<>();
			Deque<int[]> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][N];
			q.offer(new int[] { sharkX, sharkY, 0 });
			visited[sharkX][sharkY] = true;
			int closeFish = Integer.MAX_VALUE;

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int cnt = cur[2];

				if (cnt > closeFish)
					break;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
						continue;

					if (arr[nx][ny] > sharkSize)
						continue;

					if (arr[nx][ny] != 0 && arr[nx][ny] < sharkSize) {
						fish.add(new int[] { nx, ny, cnt + 1 });
						closeFish = cnt;
					}
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny, cnt + 1 });
				}
			}

			if (fish.isEmpty()) {
				break;
			} else {
				Collections.sort(fish, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[2] == o2[2] ? o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0] : o1[2] - o2[2];
					}
				});
				int[] smallFish = fish.get(0);
				int fishX = smallFish[0];
				int fishY = smallFish[1];
				int move = smallFish[2];

				sharkMove += move;
				sharkEat++;
				if (sharkEat == sharkSize) {
					sharkEat = 0;
					sharkSize++;
				}
				arr[fishX][fishY] = 0;
				sharkX = fishX;
				sharkY = fishY;
			}
		}

		System.out.println(sharkMove);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}