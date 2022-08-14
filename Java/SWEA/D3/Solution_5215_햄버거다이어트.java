import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static int N, L;
	private static int[] score, calorie;
	private static int maxScore;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void subset(int index, int tempScore, int tempCalorie) {
		if (index == N) {
			if (tempCalorie <= L) 
				maxScore = Math.max(maxScore, tempScore);				
			return;
		}

		if (tempCalorie > L)
			return;

		subset(index + 1, tempScore + score[index], tempCalorie + calorie[index]);
		subset(index + 1, tempScore, tempCalorie);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			calorie = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				score[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			maxScore = 0;
			subset(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}