import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		for (int i = 2; i < ((int) Math.sqrt(n)) + 1; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		for (int i = M; i <= N; i++) {
			if (isPrime(i))
				System.out.println(i);
		}
	}

}
