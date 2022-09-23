class Solution {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				dist[i][j] = 123456789;
			}
		}

		for (int[] fare : fares) {
			int c = fare[0], d = fare[1], f = fare[2];
			dist[c][d] = f;
			dist[d][c] = f;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
		}

		return answer;
	}
}