import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int tc = 1; tc <= 10; tc++) {
            Queue<Integer> q = new ArrayDeque<>();
            sb.append("#").append(tc).append(" ");
            in.readLine();
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
 
            int remove = 1;
            int temp = 0;
            while (true) {
                temp = q.poll() - remove;
                if (temp <= 0) {
                    temp = 0;
                    q.add(temp);
                    break;
                }
                q.add(temp);
                remove++;
                remove = remove > 5 ? 1 : remove;
            }
             
            for (Integer x : q) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}