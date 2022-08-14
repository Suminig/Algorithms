import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] bits = in.readLine().toCharArray();
			char bit = '0';
			int cnt = 0;
			
			for (int i = 0; i < bits.length; i++) {
				if (bits[i] != bit) {
					if (bit == '1') bit = '0';
					else if (bit == '0') bit = '1';
					cnt++;
				} 
			}
			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb);
		in.close();
	}
}
