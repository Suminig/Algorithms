import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, minSpace;
	private static int[][] arr;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static ArrayList<int[]> cctvs;
	private static ArrayList<int[][]> directions;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static int[][] copyArr(int[][] arr) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	private static int countSpace(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void dfs(int[][] arr, int depth) {
		if (depth == cctvs.size()) {
			minSpace = Math.min(minSpace, countSpace(arr));
			return;
		}

		int[][] tempArr = copyArr(arr);
		int[] cur = cctvs.get(depth);
		int x = cur[0];
		int y = cur[1];
		int mode = cur[2];

		for (int i = 0, size = directions.get(mode).length; i < size; i++) {
			fill(x, y, directions.get(mode)[i], tempArr);
			dfs(tempArr, depth + 1);
			tempArr = copyArr(arr);
		}
	}

	private static void fill(int x, int y, int[] dir, int[][] arr) {
		for (int i = 0, size = dir.length; i < size; i++) {
			int nx = x, ny = y;
			while (true) {
				nx = nx + dx[dir[i]];
				ny = ny + dy[dir[i]];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 6)
					break;

				if (arr[nx][ny] == 0)
					arr[nx][ny] = -1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minSpace = Integer.MAX_VALUE;
		arr = new int[N][M];
		cctvs = new ArrayList<>();
		directions = new ArrayList<>();
		directions.add(new int[][] { {} });
		directions.add(new int[][] { { 0 }, { 1 }, { 2 }, { 3 } });
		directions.add(new int[][] { { 0, 2 }, { 1, 3 } });
		directions.add(new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } });
		directions.add(new int[][] { { 3, 0, 1 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } });
		directions.add(new int[][] { { 0, 1, 2, 3 } });

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5)
					cctvs.add(new int[] { i, j, arr[i][j] });
			}
		}

		dfs(arr, 0);
		sb.append(minSpace);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}