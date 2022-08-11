import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K;
	private static int[][] arr, cmd;
	private static int min = Integer.MAX_VALUE;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static int arrayValue(int[][] arr) {
		int min = Integer.MAX_VALUE;
		int temp;
		for (int i = 0; i < arr.length; i++) {
			temp = 0;
			for (int j = 0; j < arr[0].length; j++) {
				temp += arr[i][j];
			}
			min = Math.min(min, temp);
		}
		return min;
	}

	private static int[][] rotate(int[][] arr, int r, int c, int s) {
		int[][] map = copyArr(arr);
		int x = r - s - 1;
		int y = c - s - 1;
		int h = r + s - 1;
		int w = c + s - 1;

		for (int i = 0; i < s; i++) {
			int temp = map[x + i][y + i];
			// 왼
			for (int j = x + i; j < h - i; j++) {
				map[j][y + i] = map[j + 1][y + i];
			}
			// 하
			for (int j = y + i; j < w - i; j++) {
				map[h - i][j] = map[h - i][j + 1];
			}
			// 오
			for (int j = h - i; j > x + i; j--) {
				map[j][w - i] = map[j - 1][w - i];
			}
			// 상
			for (int j = w - i; j > y + i + 1; j--) {
				map[x + i][j] = map[x + i][j - 1];
			}
			map[x + i][y + i + 1] = temp;
		}
		return map;
	}

	private static int[][] copyArr(int[][] arr) {
		int[][] tempArr = new int[arr.length][arr[0].length];
		for (int i = 0; i < tempArr.length; i++) {
			for (int j = 0; j < tempArr[0].length; j++) {
				tempArr[i][j] = arr[i][j];
			}
		}
		return tempArr;
	}

	private static void perm(int[][] arr, int cnt, boolean[] visited) {
		if (cnt == K) {
			min = Math.min(min, arrayValue(arr));
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			perm(rotate(copyArr(arr), cmd[i][0], cmd[i][1], cmd[i][2]), cnt + 1, visited);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		cmd = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cmd[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(copyArr(arr), 0, new boolean[K]);

		sb.append(min);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}