import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, M;
	private static int[] delta = { 0, -1, 1, 1, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Shark implements Comparable<Shark> {
		int x, y, speed, dir, size;

		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public int compareTo(Shark s) {
			return this.y == s.y ? this.x == s.x ? this.size - s.size : this.x - s.x : this.y - s.y;
		}
	}

	private static void move(Shark shark) {
		if (shark.dir == 1 || shark.dir == 2) {
			int dist = shark.speed % ((R - 1) * 2);
			while (dist > 0) {
				if (shark.x + delta[shark.dir] < 1)
					shark.dir = 2;
				if (shark.x + delta[shark.dir] > R)
					shark.dir = 1;
				shark.x += delta[shark.dir];
				dist--;
			}
		} else if (shark.dir == 3 || shark.dir == 4) {
			int dist = shark.speed % ((C - 1) * 2);
			while (dist > 0) {
				if (shark.y + delta[shark.dir] < 1)
					shark.dir = 3;
				if (shark.y + delta[shark.dir] > C)
					shark.dir = 4;
				shark.y += delta[shark.dir];
				dist--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int total = 0;
		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Shark> sharks = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharks.add(new Shark(r, c, s, d, z));
		}

		for (int i = 1; i <= C; i++) {
			Collections.sort(sharks);
			for (int j = 0; j < sharks.size(); j++) {
				if (sharks.get(j).y == i) {
					total += sharks.get(j).size;
					sharks.remove(j);
					break;
				}
			}

			for (Shark shark : sharks) {
				move(shark);
			}

			Collections.sort(sharks);
			for (int j = sharks.size() - 2; j >= 0; j--) {
				Shark cur = sharks.get(j);
				Shark next = sharks.get(j + 1);
				if (cur.x == next.x && cur.y == next.y) {
					sharks.remove(j);
				}
			}
		}

		sb.append(total);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}