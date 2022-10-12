import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static int[][] arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void rotate(int[] arr, int dir) {
		if (dir == 1) {
			int temp = arr[7];
			for (int i = 7; i > 0; i--)
				arr[i] = arr[i - 1];
			arr[0] = temp;
		} else if (dir == -1) {
			int temp = arr[0];
			for (int i = 0; i < 7; i++)
				arr[i] = arr[i + 1];
			arr[7] = temp;
		}
	}

	public static void dfs(int[][] arr, int cur, int dir) {
		if (cur - 1 >= 1 && !visited[cur - 1] && arr[cur - 1][2] != arr[cur][6]) {
			visited[cur - 1] = true;
			dfs(arr, cur - 1, -dir);
		}
		if (cur + 1 <= 4 && !visited[cur + 1] && arr[cur + 1][6] != arr[cur][2]) {
			visited[cur + 1] = true;
			dfs(arr, cur + 1, -dir);
		}
		rotate(arr[cur], dir);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] arr = new int[5][8];
		for (int i = 1; i <= 4; i++) {
			String line = in.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(in.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			visited = new boolean[5];
			visited[num] = true;
			dfs(arr, num, dir);
		}

		int score = 0;
		score = arr[1][0] == 1 ? score + 1 : score;
		score = arr[2][0] == 1 ? score + 2 : score;
		score = arr[3][0] == 1 ? score + 4 : score;
		score = arr[4][0] == 1 ? score + 8 : score;

		sb.append(score);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}