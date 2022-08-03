import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static StringBuilder sb = new StringBuilder();
	public static int[][] arr;

	public static void move(int[][] arr, int x, int y, int N, int cnt) {
		arr[x][y] = cnt++;
		while (cnt <= N * N) {
			if (y + 1 < N && arr[x][y + 1] == 0) {
				while (y + 1 < N && arr[x][y + 1] == 0) {
					arr[x][++y] = cnt;
					cnt++;
				}
			} else if (x + 1 < N && arr[x + 1][y] == 0) {
				while (x + 1 < N && arr[x + 1][y] == 0) {
					arr[++x][y] = cnt;
					cnt++;
				}
			} else if (y - 1 >= 0 && arr[x][y - 1] == 0) {
				while (y - 1 >= 0 && arr[x][y - 1] == 0) {
					arr[x][--y] = cnt;
					cnt++;
				}
			} else if (x - 1 >= 0 && arr[x - 1][y] == 0) {
				while (x - 1 >= 0 && arr[x - 1][y] == 0) {
					arr[--x][y] = cnt;
					cnt++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			move(arr, 0, 0, N, 1);
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}