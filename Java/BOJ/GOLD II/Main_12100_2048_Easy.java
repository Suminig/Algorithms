import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, max;
	private static int[] nums, dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[][] arr, newArr;
	private static boolean[][] merged;
	private static ArrayList<int[]> moves;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int[][] copyArr() {
		int[][] newArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		return newArr;
	}

	public static int getMax(int[][] arr) {
		int maxNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxNum = Math.max(maxNum, arr[i][j]);
			}
		}
		return maxNum;
	}

	public static void makeMoves(int cnt) {
		if (cnt == 5) {
			moves.add(nums.clone());
			return;
		}

		for (int i = 0; i < 4; i++) {
			nums[cnt] = i;
			makeMoves(cnt + 1);
		}
	}

	public static void dfs(int cnt, int[][] newArr, int[] move) {
		if (cnt == 5) {
			int temp = getMax(newArr);
			max = max < temp ? temp : max;
			return;
		}

		int dir = move[cnt];
		merged = new boolean[N][N];
		if (dir == 0 || dir == 2) {
			for (int i = 0; i < N; i++) {
				if (dir == 0) {
					for (int j = 0; j < N; j++) {
						if (newArr[j][i] > 0)
							move(j, i, dir, newArr);
					}
				} else {
					for (int j = N - 1; j >= 0; j--) {
						if (newArr[j][i] > 0)
							move(j, i, dir, newArr);
					}
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				if (dir == 1) {
					for (int j = N - 1; j >= 0; j--) {
						if (newArr[i][j] > 0)
							move(i, j, dir, newArr);
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (newArr[i][j] > 0)
							move(i, j, dir, newArr);
					}
				}
			}
		}

		dfs(cnt + 1, newArr, move);
	}

	public static void move(int x, int y, int d, int[][] arr) {
		int cur = arr[x][y];
		arr[x][y] = 0;
		int nx = x;
		int ny = y;

		while (true) {
			nx += dx[d];
			ny += dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				nx -= dx[d];
				ny -= dy[d];
				break;
			}

			if (arr[nx][ny] > 0)
				break;
		}

		if (arr[nx][ny] == 0) {
			arr[nx][ny] = cur;
		} else {
			if (arr[nx][ny] == cur) {
				if (!merged[nx][ny]) {
					arr[nx][ny] += cur;
					merged[nx][ny] = true;
				} else {
					nx -= dx[d];
					ny -= dy[d];
					arr[nx][ny] = cur;
				}
			} else {
				nx -= dx[d];
				ny -= dy[d];
				arr[nx][ny] = cur;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		nums = new int[5];
		moves = new ArrayList<>();
		makeMoves(0);
		max = 0;

		for (int[] move : moves) {
			newArr = copyArr();
			dfs(0, newArr, move);
		}

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}