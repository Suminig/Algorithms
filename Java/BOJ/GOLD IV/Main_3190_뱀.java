import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int N, dir, time;
	private static int[][] arr;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 }; // 상, 우, 하, 좌
	private static ArrayDeque<int[]> dirs, snake;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		arr = new int[N + 1][N + 1]; // 현재 보드 상태 - 1 : 뱀, 2 : 사과
		arr[1][1] = 1;
		snake = new ArrayDeque<>();
		snake.offer(new int[] { 1, 1 });

		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr[r][c] = 2;
		}

		int L = Integer.parseInt(in.readLine());
		dirs = new ArrayDeque<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int C;

			if (dir.equals("L"))
				C = -1;
			else
				C = 1;

			dirs.offer(new int[] { X, C });
		}

		time = 0;
		dir = 1; // 처음엔 오른쪽을 바라보고 있음

		while (true) {
			if (!dirs.isEmpty() && dirs.peek()[0] == time)
				dir = ((dir + dirs.poll()[1]) % 4 + 4) % 4; // Java에서는 -1 % 4가 -1을 반환하기에 3을 반환하도록 처리

			int nx = snake.peekLast()[0] + dx[dir];
			int ny = snake.peekLast()[1] + dy[dir];

			if (nx < 1 || nx > N || ny < 1 || ny > N || arr[nx][ny] == 1)
				break;

			if (arr[nx][ny] == 0) {
				arr[snake.peek()[0]][snake.peek()[1]] = 0;
				snake.poll();
			}

			arr[nx][ny] = 1;
			snake.offer(new int[] { nx, ny });
			time++;
		}

		sb.append(time + 1);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}