import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (N > 1) {
			int[][] newMap = new int[N / 2][N / 2];
			int x = 0;
			for (int i = 0; i < N; i = i + 2) {
				int y = 0;
				for (int j = 0; j < N; j = j + 2) {
					int[] temp = { map[i][j], map[i][j + 1], map[i + 1][j], map[i + 1][j + 1] };
					Arrays.sort(temp);
					newMap[x][y] = temp[2];
					y++;
				}
				x++;
			}
			map = newMap;
			N /= 2;
		}
		System.out.println(map[0][0]);
	}
}