import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = 9;
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);

		int tempSum = 0;
		int not1 = 0;
		int not2 = 0;
		for (int i = 0; i < N; i++) {
			tempSum = sum;
			not1 = arr[i];
			tempSum -= not1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				not2 = arr[j];
				tempSum -= not2;
				if (tempSum == 100)
					break;
				else
					tempSum += not2;
			}
			if (tempSum == 100)
				break;
		}
		for (int x : arr) {
			if (x == not1 || x == not2)
				continue;
			sb.append(x).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}