import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int N, minShuffle;
	private static int[] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static boolean isInOrder(int[] arr) {
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[idx++] != i)
				return false;
		}
		return true;
	}

	public static boolean isReverseOrder(int[] arr) {
		int idx= 0;
		for (int i = N; i > 0; i--) {
			if (arr[idx++] != i)
				return false;
		}
		return true;
	}

	public static int[] shuffle(int x, int[] arr) {
		int[] temp = new int[N];
		Queue<Integer> left = new ArrayDeque<>();
		Queue<Integer> right = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			if (i < N / 2)
				left.offer(arr[i]);
			else
				right.offer(arr[i]);
		}

		int y = N / 2;
		int idx = 0;
		while (true) {
			if (left.isEmpty() || right.isEmpty())
				break;

			if (y > x) {
				temp[idx++] = left.poll();
				y--;
			} else {
				temp[idx++] = right.poll();
				x--;
			}
		}
		while (!right.isEmpty()) 
			temp[idx++] = right.poll();

		while (!left.isEmpty()) 
			temp[idx++] = left.poll();

		return temp;
	}

	public static void dfs(int cnt, int[] arr) {
		if (cnt > 5 || cnt >= minShuffle)
			return;

		if (isInOrder(arr) || isReverseOrder(arr)) {
			minShuffle = Math.min(minShuffle, cnt);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			dfs(cnt + 1, shuffle(i, arr));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			minShuffle = Integer.MAX_VALUE;
			dfs(0, arr);

			minShuffle = minShuffle == Integer.MAX_VALUE ? -1 : minShuffle;

			sb.append("#").append(tc).append(" ").append(minShuffle).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}