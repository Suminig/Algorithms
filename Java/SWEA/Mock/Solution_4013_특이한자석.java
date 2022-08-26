import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    private static ArrayList<Integer>[] magnets;
    private static boolean[] visited;
    private static int[] point = { 0, 1, 2, 4, 8 };
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    public static void rotate(int cur, int dir) {
        ArrayList<Integer> curList = magnets[cur];
        int left = cur - 1;
        int right = cur + 1;
 
        if (left > 0 && !visited[left]) {
            ArrayList<Integer> leftList = magnets[left];
            if (curList.get(6) != leftList.get(2)) {
                visited[left] = true;
                rotate(left, dir * -1);
            }
        }
        if (right < 5 && !visited[right]) {
            ArrayList<Integer> rightList = magnets[right];
            if (curList.get(2) != rightList.get(6)) {
                visited[right] = true;
                rotate(right, dir * -1);
            }
        }
        move(curList, dir);
    }
 
    public static void move(ArrayList<Integer> list, int dir) {
        if (dir == 1) {
            list.add(0, list.remove(7));
        } else {
            list.add(list.remove(0));
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(in.readLine());
            magnets = new ArrayList[5];
            for (int i = 1; i < 5; i++) {
                magnets[i] = new ArrayList<>();
            }
 
            for (int i = 1; i < 5; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < 8; j++) {
                    magnets[i].add(Integer.parseInt(st.nextToken()));
                }
            }
 
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                visited = new boolean[5];
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                visited[num] = true;
                rotate(num, dir);
            }
 
            int sum = 0;
            for (int i = 1; i < 5; i++) {
                if (magnets[i].get(0) == 1) {
                    sum += point[i];
                }
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
 
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}