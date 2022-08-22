import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int L, C;
	private static char[] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void password(int cnt, int start, String word) {
		if (cnt == L) {
			int vowel = 0, nonvowel = 0;
			for (int i = 0; i < cnt; i++) {
				if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
					vowel++;
				else
					nonvowel++;
			}
			
			if (vowel >= 1 && nonvowel >= 2) 
				sb.append(word).append("\n");
			
			return;
		}

		for (int i = start; i < C; i++) {
			password(cnt + 1, i+1, new String(word + arr[i]));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		password(0, 0, "");

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}