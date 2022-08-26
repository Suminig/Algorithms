import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, T, ac1, ac2;
	private static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	private static int[][] arr, tempArr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int countDust() {
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0)
					cnt += arr[i][j];
			}
		}
		return cnt;
	}

	public static void spread(int x, int y) {
		int amount = arr[x][y] / 5;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] == -1)
				continue;

			tempArr[nx][ny] += amount;
			tempArr[x][y] -= amount;
		}
	}

	public static void refresh() {
		// 상단 공기 순환
		for (int i = ac1 - 1; i > 0; i--) {
			arr[i][0] = arr[i - 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			arr[0][j] = arr[0][j + 1];
		}
		for (int i = 0; i < ac1; i++) {
			arr[i][C - 1] = arr[i + 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			arr[ac1][j] = arr[ac1][j - 1];
		}
		arr[ac1][1] = 0;

		// 하단 공기 순환
		for (int i = ac2 + 1; i < R - 1; i++) {
			arr[i][0] = arr[i + 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			arr[R - 1][j] = arr[R - 1][j + 1];
		}
		for (int i = R - 1; i > ac2; i--) {
			arr[i][C - 1] = arr[i - 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			arr[ac2][j] = arr[ac2][j - 1];
		}
		arr[ac2][1] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i - 1 > 0 && arr[i][j] == -1 && arr[i - 1][j] == -1) {
					ac1 = i - 1;
					ac2 = i;
				}
			}
		}

		while (T-- > 0) {
			tempArr = new int[R][C];

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] > 0) {
						spread(i, j);
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					arr[i][j] += tempArr[i][j];
				}
			}

			refresh();
		}

		sb.append(countDust());

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}