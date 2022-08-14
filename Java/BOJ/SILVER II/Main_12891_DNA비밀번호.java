import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int num_A, num_C, num_G, num_T;
	private static int cnt_A = 0, cnt_C = 0, cnt_G = 0, cnt_T = 0;

	private static void countDNA(char c, int state) {
		switch (c) {
		case 'A':
			cnt_A = state == 1 ? cnt_A + 1 : cnt_A - 1;
			break;
		case 'C':
			cnt_C = state == 1 ? cnt_C + 1 : cnt_C - 1;
			break;
		case 'G':
			cnt_G = state == 1 ? cnt_G + 1 : cnt_G - 1;
			break;
		case 'T':
			cnt_T = state == 1 ? cnt_T + 1 : cnt_T - 1;
			break;
		}
	}

	private static boolean isValid() {
		if (num_A <= cnt_A && num_C <= cnt_C && num_G <= cnt_G && num_T <= cnt_T) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String DNA = in.readLine();
		st = new StringTokenizer(in.readLine(), " ");
		num_A = Integer.parseInt(st.nextToken());
		num_C = Integer.parseInt(st.nextToken());
		num_G = Integer.parseInt(st.nextToken());
		num_T = Integer.parseInt(st.nextToken());
		int res = 0;

		for (int i = 0; i < P; i++) {
			countDNA(DNA.charAt(i), 1);
		}
		if (isValid()) res++;
		
		for (int i = P; i < S; i++) {
			countDNA(DNA.charAt(i - P), -1);
			countDNA(DNA.charAt(i), 1);
			if (isValid()) res++;
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}