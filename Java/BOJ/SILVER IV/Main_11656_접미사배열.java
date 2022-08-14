
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		String[] arr = new String[S.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = S.substring(i);
		}

		Arrays.sort(arr);

		for (String a : arr) {
			System.out.println(a);
		}
	}
}