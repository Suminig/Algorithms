import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
  private static Map<Long, Long> memo;
  private static StringBuilder sb = new StringBuilder();

  public static long fibonacci(long num) {
    // 도가뉴 항등식 (d'Ocagne's identity)
    // 짝수: F2n = Fn*(Fn + 2*Fn−1)
    // 홀수: F2n+1 = Fn+1^2 + Fn^2
    if (!memo.containsKey(num)) {
      if (num % 2 == 0) {
        long fn = fibonacci(num / 2);
        long fnMinus1 = fibonacci(num / 2 - 1);

        memo.put(num, (fn * (fn + 2 * fnMinus1)) % 1_000_000_007);
      } else {
        long fn = fibonacci(num / 2);
        long fnPlus1 = fibonacci(num / 2 + 1);

        memo.put(num, (fnPlus1 * fnPlus1 + fn * fn) % 1_000_000_007);
      }
    }

    return memo.get(num);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    memo = new HashMap<>();
    memo.put(Long.valueOf(0), Long.valueOf(0));
    memo.put(Long.valueOf(1), Long.valueOf(1));
    long N = Long.parseLong(in.readLine());

    sb.append(fibonacci(N));

    out.write(sb.toString());
    out.flush();
    out.close();
    in.close();
  }
}