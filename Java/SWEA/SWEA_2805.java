import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(line.charAt(j) + "");
				}
			}

			int half = N / 2 + 1;
			int size = N / 2;
			int sum = 0;
			for (int i = 0; i < half; i++) {
				for (int j = size; j < N - size; j++) {
					sum += arr[i][j];
				}
				size--;
			}
			size = 1;
			for (int i = half; i < N; i++) {
				for (int j = size; j < N - size; j++) {
					sum += arr[i][j];
				}
				size++;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
