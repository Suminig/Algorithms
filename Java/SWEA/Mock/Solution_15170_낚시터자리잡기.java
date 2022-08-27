import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int[] fishSpot;
	private static int[] gateNum = { 0, 1, 2 };
	private static ArrayList<int[]> lists;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Gate {
		int pos, left;

		public Gate(int pos, int left) {
			super();
			this.pos = pos;
			this.left = left;
		}
	}

	public static void perm(int cnt, int flag, int[] nums) {
		if (cnt == 3) {
			lists.add(nums);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			int[] temp = nums.clone();
			temp[cnt] = gateNum[i];
			perm(cnt + 1, flag | 1 << i, temp);
		}
	}

	public static void placeFisherL(int x, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] tempVisited = new boolean[N + 1];
		q.offer(new int[] { x, cnt });
		tempVisited[x] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curPos = cur[0];
			int curCnt = cur[1];
			
			if (fishSpot[curPos] == 0) {
				fishSpot[curPos] = curCnt;
				break;
			} else {
				int left = curPos - 1;
				if (left >= 1 && !tempVisited[left]) {
					tempVisited[left] = true;
					q.offer(new int[] { left, curCnt + 1 });
				}
				
				int right = curPos + 1;
				if (right <= N && !tempVisited[right] ) {
					tempVisited[right] = true;
					q.offer(new int[] { right, curCnt + 1 });
				}
			}
		}
	}
	
	public static void placeFisherR(int x, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] tempVisited = new boolean[N + 1];
		q.offer(new int[] { x, cnt });
		tempVisited[x] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curPos = cur[0];
			int curCnt = cur[1];

			if (fishSpot[curPos] == 0) {
				fishSpot[curPos] = curCnt;
				break;
			} else {
				int right = curPos + 1;
				if (right <= N && !tempVisited[right] ) {
					tempVisited[right] = true;
					q.offer(new int[] { right, curCnt + 1 });
				}
				
				int left = curPos - 1;
				if (left >= 1 && !tempVisited[left]) {
					tempVisited[left] = true;
					q.offer(new int[] { left, curCnt + 1 });
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		lists = new ArrayList<>();
		perm(0, 0, new int[3]);

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			Gate[] gates = new Gate[3];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int pos = Integer.parseInt(st.nextToken());
				int left = Integer.parseInt(st.nextToken());
				gates[i] = new Gate(pos, left);
			}

			int min = Integer.MAX_VALUE;

			for (int[] list : lists) {
				fishSpot = new int[N + 1];
				for (int i = 0; i < 3; i++) {
					int gatePos = gates[list[i]].pos;
					int gateLeft = gates[list[i]].left;
					while (gateLeft > 0) {
						placeFisherL(gatePos, 1);
						gateLeft--;
					}
				}
				int cnt = 0;
				for (int i = 1; i <= N; i++) {
					cnt += fishSpot[i];
				}
				min = Math.min(min, cnt);
				
				fishSpot = new int[N + 1];
				for (int i = 0; i < 3; i++) {
					int gatePos = gates[list[i]].pos;
					int gateLeft = gates[list[i]].left;
					while (gateLeft > 0) {
						placeFisherR(gatePos, 1);
						gateLeft--;
					}
				}
				cnt = 0;
				for (int i = 1; i <= N; i++) {
					cnt += fishSpot[i];
				}
				min = Math.min(min, cnt);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}