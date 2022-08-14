import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
		
			for (int i = 0; i < N; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			int diff = arr[99] - arr[0];
			sb.append("#").append(tc).append(" ").append(diff).append("\n");
		}
		System.out.println(sb);
	}
}
