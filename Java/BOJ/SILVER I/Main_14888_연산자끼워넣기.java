import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, plus, minus, multiply, divide, max, min;
	private static int[] nums, oprs;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void dfs(int cnt, int sum) {
		if(cnt == N - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(oprs[i] > 0) {
				oprs[i]--;
				int next = cnt + 1;
				if(i == 0) dfs(cnt+1, sum+nums[next]);
				if(i == 1) dfs(cnt+1, sum-nums[next]);
				if(i == 2) dfs(cnt+1, sum*nums[next]);
				if(i == 3) dfs(cnt+1, sum/nums[next]);
				oprs[i]++;				
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		nums = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		oprs = new int[4];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			oprs[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(0, nums[0]);
		sb.append(max).append("\n").append(min);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}