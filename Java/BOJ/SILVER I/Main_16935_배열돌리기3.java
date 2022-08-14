import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, R;
	private static int[][] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static int[][] copyArr(int[][] arr, int N, int M) {
		int[][] copied = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				copied[i][j] = arr[i][j];
		}
		return copied;
	}

	private static void rotate(int mode) {
		int[][] temp = copyArr(arr, N, M);
		int swap;
		switch (mode) {
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = temp[N - 1 - i][j];
				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = temp[i][M - 1 - j];
				}
			}
			break;
		case 3:
			arr = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp[N - 1 - j][i];
				}
			}
			swap = N;
			N = M;
			M = swap;
			break;
		case 4:
			arr = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp[j][M - 1 - i];
				}
			}
			swap = N;
			N = M;
			M = swap;
			break;
		case 5:
			// 1
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					arr[i][j] = temp[i + N / 2][j];
				}
			}
			// 2
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j] = temp[i][j - M / 2];
				}
			}
			// 3
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j] = temp[i - N / 2][j];
				}
			}
			// 4
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					arr[i][j] = temp[i][j + M / 2];
				}
			}
			break;
		case 6:
			// 1
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					arr[i][j] = temp[i][j + M / 2];
				}
			}
			// 2
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j] = temp[i + N / 2][j];
				}
			}
			// 3
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					arr[i][j] = temp[i][j - M / 2];
				}
			}
			// 4
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					arr[i][j] = temp[i - N / 2][j];
				}
			}
			break;

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine(), " ");

		while (st.hasMoreElements()) {
			for (int i = 1; i <= R; i++) {
				rotate(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}