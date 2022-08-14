import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static List<Integer> list = new ArrayList<>();

	private static boolean isPrime(int num) {
		if (num == 2)
			return true;

		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static void findMagicPrime(int num, int cnt, int N, int[] start, int[] concat) {
		if (!isPrime(num))
			return;

		if (cnt == N) {
			if (isPrime(num))
				list.add(num);
			return;
		}

		if (cnt == 0) {
			for (int i = 0; i < start.length; i++) {
				findMagicPrime(Integer.parseInt(num + "" + start[i]), cnt + 1, N, start, concat);
			}
		} else {
			for (int i = 0; i < concat.length; i++) {
				findMagicPrime(Integer.parseInt(num + "" + concat[i]), cnt + 1, N, start, concat);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int[] start = { 2, 3, 5, 7 };
		int[] concat = { 1, 3, 5, 7, 9 };

		findMagicPrime(0, 0, N, start, concat);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i != list.size() - 1)
				sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}