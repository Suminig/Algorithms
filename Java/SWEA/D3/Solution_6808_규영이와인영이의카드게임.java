import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    private static StringTokenizer st;
    private static int win, lose;
    private static StringBuilder sb = new StringBuilder();
 
    private static void perm(int cnt, int[] GY, int[] IY, boolean[] visited, int gy, int iy) {
        if (cnt == 9) {
            if (gy > iy)
                win++;
            else if (gy < iy)
                lose++;
            return;
        }
         
        for (int i = 0; i < 9; i++) {
            if (visited[i])
                continue;
 
            visited[i] = true;
            if (GY[cnt] > IY[i]) {
                perm(cnt + 1, GY, IY, visited, gy + GY[cnt] + IY[i], iy);
            } else {
                perm(cnt + 1, GY, IY, visited, gy, iy + GY[cnt] + IY[i]);
            }
            visited[i] = false;
        }
 
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            int[] total = new int[19];
            int[] GY = new int[9];
            int[] IY = new int[9];
            for (int i = 0; i < 9; i++) {
                GY[i] = Integer.parseInt(st.nextToken());
                total[GY[i]] = 1;
            }
            for (int i = 1, index = 0; i <= 18; i++) {
                if (total[i] == 0)
                    IY[index++] = i;
            }
            boolean[] visited = new boolean[19];
            win = 0;
            lose = 0;
            perm(0, GY, IY, visited, 0, 0);
 
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
 
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}