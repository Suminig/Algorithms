import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Solution {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    private static class Pair {
        int x, y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    private static class BC implements Comparable<BC> {
        int x, y, c, p;
 
        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
 
        @Override
        public int compareTo(BC bc) {
            return bc.p - this.p;
        }
 
    }
 
    private static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
 
    private static void move(Pair user, int mode) {
        switch (mode) {
        case 0:
            break;
        case 1:
            user.x -= 1;
            break;
        case 2:
            user.y += 1;
            break;
        case 3:
            user.x += 1;
            break;
        case 4:
            user.y -= 1;
            break;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int[] pathA = new int[M + 1], pathB = new int[M + 1];
            ArrayList<BC> list = new ArrayList<>();
 
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 1; i <= M; i++) {
                pathA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 1; i <= M; i++) {
                pathB[i] = Integer.parseInt(st.nextToken());
            }
 
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
 
                list.add(new BC(x, y, c, p));
            }
 
            Collections.sort(list);
            Pair userA = new Pair(1, 1), userB = new Pair(10, 10);
            int sum = 0;
            for (int i = 0; i <= M; i++) {
                move(userA, pathA[i]);
                move(userB, pathB[i]);
                BC bcA = null, bcB = null;
                int chargedA = 0, chargedB = 0;
                int numA = 0, numB = 0;
 
                for (int j = 0; j < A; j++) {
                    BC cur = list.get(j);
                    if (dist(userA.x, userA.y, cur.x, cur.y) <= cur.c) {
                        chargedA = cur.p;
                        bcA = cur;
                        numA = j;
                        break;
                    }
                }
 
                for (int j = 0; j < A; j++) {
                    BC cur = list.get(j);
                    if (dist(userB.x, userB.y, cur.x, cur.y) <= cur.c) {
                        chargedB = cur.p;
                        bcB = cur;
                        numB = j;
                        break;
                    }
                }
 
                if (bcA != null && bcB == null) {
                    sum += chargedA;
                } else if (bcA == null && bcB != null) {
                    sum += chargedB;
                } else if (bcA == null && bcB == null) {
                    continue;
                } else {
                    if (chargedA == chargedB && bcA.equals(bcB)) {
                        int tempA = 0, tempB = 0;
                        for (int j = numA + 1; j < A; j++) {
                            BC cur = list.get(j);
                            if (dist(userA.x, userA.y, cur.x, cur.y) <= cur.c) {
                                tempA = cur.p;
                                break;
                            }
                        }
 
                        for (int j = numB + 1; j < A; j++) {
                            BC cur = list.get(j);
                            if (dist(userB.x, userB.y, cur.x, cur.y) <= cur.c) {
                                tempB = cur.p;
                                break;
                            }
                        }
 
                        if (tempA == 0 && tempB == 0) {
                            sum += chargedA;
                        } else {
                            sum += Math.max((tempA + chargedB), (chargedA + tempB));
                        }
                    } else {
                        sum += (chargedA + chargedB);
                    }
                }
 
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
 
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}