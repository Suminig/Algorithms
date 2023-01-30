import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int cnt_rec, cnt_dp;
    private static StringBuilder sb = new StringBuilder();

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt_rec++;
            return 1;
        } else
            return fib(n - 1) + fib(n - 2);
    }

    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            cnt_dp++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());

        cnt_rec = cnt_dp = 0;

        fib(N);
        fibonacci(N);

        sb.append(cnt_rec).append(" ").append(cnt_dp);

        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }
}