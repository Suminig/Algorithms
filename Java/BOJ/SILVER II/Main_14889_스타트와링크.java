import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, minDiff;
	private static int[] team;
	private static int[][] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static boolean contains(int[] arr, int key) {
		for (int x : arr) {
			if (x == key)
				return true;
		}
		return false;
	}

	public static void comb(int cnt, int idx) {
		if (cnt == N / 2) {
			int[] start = team.clone();
			int[] link = new int[N / 2];
			for (int i = 0, index = 0; i < N; i++) {
				if (!contains(start, i))
					link[index++] = i;
			}

			int startScore = 0, linkScore = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					startScore += arr[start[i]][start[j]];
				}
			}

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					linkScore += arr[link[i]][link[j]];
				}
			}
			minDiff = Math.min(minDiff, Math.abs(startScore - linkScore));
			return;
		}

		for (int i = idx; i < N; i++) {
			team[cnt] = i;
			comb(cnt + 1, i + 1);
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

		team = new int[N / 2];
		minDiff = Integer.MAX_VALUE;
		comb(0, 0);
		sb.append(minDiff);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}