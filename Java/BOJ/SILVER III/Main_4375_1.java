import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N = 0;
			try {
				N = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				break;
			}
			long num = 1;
			int length = 1;
			while (true) {
				if (num % N == 0) {
					System.out.println(length);
					break;
				}
				num = (num * 10 + 1) % N;
				length++;
			}
		}
	}
}