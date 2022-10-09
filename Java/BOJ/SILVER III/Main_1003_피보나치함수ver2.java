import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  private static int[] zero, one;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    zero = new int[41];
    one = new int[41];
    zero[0] = 1;
    one[1] = 1;

    for (int i = 2; i < 41; i++) {
      zero[i] = zero[i - 1] + zero[i - 2];
      one[i] = one[i - 1] + one[i - 2];
    }

    int T = Integer.parseInt(in.readLine());
    for (int tc = 0; tc < T; tc++) {
      int N = Integer.parseInt(in.readLine());
      sb.append(zero[N]).append(" ").append(one[N]).append("\n");
    }

    out.write(sb.toString());
    out.flush();
    out.close();
    in.close();
  }
}