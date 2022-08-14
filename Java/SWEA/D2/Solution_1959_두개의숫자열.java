import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] a = new int[n];
			int[] b = new int[m];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			for (int i = 0; i < m; i++)
				b[i] = sc.nextInt();

			int max = 0;

			if (n < m) {
				for (int i = 0; i < m - n + 1; i++) {
					int temp = 0;
					for (int j = 0; j < n; j++) {
						temp += a[j] * b[i + j];
					}
					max = Math.max(max, temp);
				}

			} else {
				for (int i = 0; i < n - m + 1; i++) {
					int temp = 0;
					for (int j = 0; j < m; j++) {
						temp += a[i + j] * b[j];
					}
					max = Math.max(max, temp);
				}
			}
			System.out.printf("#%d %d", t, max);
			System.out.println("");
		}
	}
}