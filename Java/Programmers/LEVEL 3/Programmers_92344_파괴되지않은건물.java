class Solution {
	public int solution(int[][] board, int[][] skills) {
		int answer = 0;
		int n = board.length, m = board[0].length;
		int[][] sum = new int[n + 1][m + 1];

		for (int[] skill : skills) {
			int type = skill[0];
			int r1 = skill[1], c1 = skill[2], r2 = skill[3], c2 = skill[4];
			int degree = skill[5];

			if (type == 1)
				degree *= -1;

			sum[r1][c1] += degree;
			sum[r1][c2 + 1] -= degree;
			sum[r2 + 1][c1] -= degree;
			sum[r2 + 1][c2 + 1] += degree;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				sum[i][j] += sum[i][j - 1];
			}
		}

		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n; i++) {
				sum[i][j] += sum[i - 1][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] += sum[i][j];
				if (board[i][j] > 0)
					answer++;
			}
		}

		return answer;
	}
}