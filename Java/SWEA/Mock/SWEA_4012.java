import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
    private static int N;
    private static int min;
    private static int[] index;
    private static int[][] synergy;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    private static void comb(int left, int start, int[] selected) {
        if (left == 0) {
            ArrayList<Integer> notSelected = new ArrayList<>();
            for (int i = 0; i < N; i++)
                notSelected.add(i);
            for (int i = N / 2 - 1; i >= 0; i--)
                notSelected.remove(selected[i]);
 
            int food1 = 0, food2 = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    food1 = food1 + synergy[selected[i]][selected[j]] + synergy[selected[j]][selected[i]];
                }
            }
            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    food2 = food2 + synergy[notSelected.get(i)][notSelected.get(j)]
                            + synergy[notSelected.get(j)][notSelected.get(i)];
                }
            }
            min = Math.min(min, Math.abs(food1 - food2));
            return;
        }
        for (int i = start; i < N; i++) {
            selected[selected.length - left] = index[i];
            comb(left - 1, i + 1, selected);
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            synergy = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            index = new int[N];
            for (int i = 0; i < N; i++) {
                index[i] = i;
            }
            min = Integer.MAX_VALUE;
            comb(N / 2, 0, new int[N / 2]);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
         
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}