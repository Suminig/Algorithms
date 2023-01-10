import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void change(int[][] arr, int x, int y) {
		if (x + 2 < N && y + 2 < M) {
			for (int i = x; i < x + 3; i++) {
				for (int j = y; j < y + 3; j++) {
					arr[i][j] = arr[i][j] == 0 ? 1 : 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][M];
		int[][] B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = line.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = line.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					change(A, i, j);
					cnt++;
				}
			}
		}

		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					flag = false;
					break;
				}
			}
		}

		sb.append(flag ? cnt : -1);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}