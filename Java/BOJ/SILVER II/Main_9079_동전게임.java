import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int min = Integer.MAX_VALUE;
	private static boolean[] isSelected = new boolean[8];
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static boolean isflipped(char[][] arr) {
		char check = arr[0][0];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] != check)
					return false;
			}
		}
		return true;
	}

	private static char[][] flipCoin(char[][] arr, int mode) {
		switch (mode) {
		case 0:
			for (int i = 0; i < 3; i++) {
				arr[0][i] = arr[0][i] == 'H' ? 'T' : 'H';
			}
			break;
		case 1:
			for (int i = 0; i < 3; i++) {
				arr[1][i] = arr[1][i] == 'H' ? 'T' : 'H';
			}
			break;
		case 2:
			for (int i = 0; i < 3; i++) {
				arr[2][i] = arr[2][i] == 'H' ? 'T' : 'H';
			}
			break;
		case 3:
			for (int i = 0; i < 3; i++) {
				arr[i][0] = arr[i][0] == 'H' ? 'T' : 'H';
			}
			break;
		case 4:
			for (int i = 0; i < 3; i++) {
				arr[i][1] = arr[i][1] == 'H' ? 'T' : 'H';
			}
			break;
		case 5:
			for (int i = 0; i < 3; i++) {
				arr[i][2] = arr[i][2] == 'H' ? 'T' : 'H';
			}
			break;
		case 6:
			for (int i = 0; i < 3; i++) {
				arr[i][i] = arr[i][i] == 'H' ? 'T' : 'H';
			}
			break;
		case 7:
			for (int i = 0; i < 3; i++) {
				arr[i][2 - i] = arr[i][2 - i] == 'H' ? 'T' : 'H';
			}
			break;
		}
		return arr;
	}

	private static void flip(char[][] arr, int index, int cnt) {
		if (isflipped(arr)) {
			min = cnt < min ? cnt : min;
			return;
		}
		
		if (index == 8) {
			return;
		}
		
		isSelected[index] = true;
		arr = flipCoin(arr, index);
		flip(arr, index+1, cnt+1);
		isSelected[index] = false;
		arr = flipCoin(arr, index);
		flip(arr, index+1, cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			char[][] coin = new char[3][3];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					coin[i][j] = st.nextToken().charAt(0);
				}

			}
			
			flip(coin, 0, 0);
			
			if (min == Integer.MAX_VALUE) {
				sb.append(-1);
			}else {
				sb.append(min);
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}