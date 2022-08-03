import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(in.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            int x = 0, y = 0;
            // 맵 초기화
            for (int i = 0; i < H; i++) {
                String line = in.readLine();
                for (int j = 0; j < W; j++) {
                    char cur = line.charAt(j);
                    map[i][j] = cur;
                    if (cur == '^' || cur == 'v' || cur == '<' || cur == '>') {
                        x = i;
                        y = j;
                    }
                }
            }
 
            int N = Integer.parseInt(in.readLine());
            String cmds = in.readLine();
            for (int i = 0; i < N; i++) {
                char cmd = cmds.charAt(i);
                if (cmd == 'U') {
                    map[x][y] = '^';
                    if (x - 1 >= 0 && map[x - 1][y] == '.') {
                        map[x - 1][y] = map[x][y];
                        map[x][y] = '.';
                        x--;
                    }
                } else if (cmd == 'D') {
                    map[x][y] = 'v';
                    if (x + 1 < H && map[x + 1][y] == '.') {
                        map[x + 1][y] = map[x][y];
                        map[x][y] = '.';
                        x++;
                    }
                } else if (cmd == 'L') {
                    map[x][y] = '<';
                    if (y - 1 >= 0 && map[x][y - 1] == '.') {
                        map[x][y - 1] = map[x][y];
                        map[x][y] = '.';
                        y--;
                    }
                } else if (cmd == 'R') {
                    map[x][y] = '>';
                    if (y + 1 < W && map[x][y + 1] == '.') {
                        map[x][y + 1] = map[x][y];
                        map[x][y] = '.';
                        y++;
                    }
                } else {
                    int dx = 0, dy = 0;
                    switch (map[x][y]) {
                    case '^':
                        dx = -1;
                        break;
                    case 'v':
                        dx = 1;
                        break;
                    case '<':
                        dy = -1;
                        break;
                    case '>':
                        dy = 1;
                        break;
                    }
                    int nx = x, ny = y;
                    while (true) {
                        nx += dx;
                        ny += dy;
                         
                        if (nx <0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == '#') 
                            break;
                         
                        if (map[nx][ny] == '*') {
                            map[nx][ny] = '.';
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}