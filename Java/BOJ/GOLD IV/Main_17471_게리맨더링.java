import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] temp, nums, pops;
	private static List<Integer>[] adjList;
	private static List<int[]> combs;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static int sum(int[] arr) {
		int sum = 0;
		for (int x : arr) {
			sum += pops[x];
		}
		return sum;
	}

	public static boolean contains(int[] arr, int x) {
		for (int i = 0, size = arr.length; i < size; i++) {
			if (arr[i] == x)
				return true;
		}
		return false;
	}

	public static boolean isConnected(int[] arr) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(arr[0]);
		visited[arr[0]] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Integer x : adjList[cur]) {
				if (!visited[x] && contains(arr, x)) {
					visited[x] = true;
					q.offer(x);
				}
			}
		}

		for (int x : arr) {
			if (!visited[x])
				return false;
		}
		return true;
	}

	public static void comb(int cnt, int idx, int target) {
		if (cnt == target) {
			combs.add(temp.clone());
			return;
		}

		for (int i = idx; i <= N; i++) {
			temp[cnt] = nums[i];
			comb(cnt + 1, i + 1, target);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		pops = new int[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			pops[i] = Integer.parseInt(st.nextToken());
		}

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
			st = new StringTokenizer(in.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		nums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = i;
		}

		combs = new ArrayList<>();
		for (int i = 1; i <= N / 2; i++) {
			temp = new int[i];
			comb(0, 1, i);
		}

		int min = Integer.MAX_VALUE;
		for (int[] comb : combs) {
			int[] other = new int[N - comb.length];
			for (int i = 1, idx = 0; i <= N; i++) {
				if (!contains(comb, i))
					other[idx++] = i;
			}

			if (isConnected(comb) && isConnected(other)) {
				min = Math.min(min, Math.abs(sum(comb) - sum(other)));
			}
		}

		sb.append(min == Integer.MAX_VALUE ? -1 : min);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}