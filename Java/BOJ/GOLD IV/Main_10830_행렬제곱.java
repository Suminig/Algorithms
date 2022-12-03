import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int mod = 1000;
	private static int N;
	private static long B;
	private static int[][] arr, result;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int[][] pow(int[][] a, long exp) {
		if (exp == 1) {
			return a;
		}

		int[][] res = pow(a, exp / 2);
		res = multiply(res, res);

		if (exp % 2 == 1) {
			res = multiply(res, arr);
		}

		return res;
	}

	private static int[][] multiply(int[][] a1, int[][] a2) {
		int[][] res = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += a1[i][k] * a2[k][j];
					res[i][j] %= mod;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % mod;
			}
		}

		result = pow(arr, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}