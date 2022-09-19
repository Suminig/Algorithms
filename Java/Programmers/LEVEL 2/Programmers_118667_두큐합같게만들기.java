import java.util.*;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		int n = queue1.length;
		long sum1 = 0;
		long sum2 = 0;
		ArrayDeque<Integer> q1 = new ArrayDeque<>();
		ArrayDeque<Integer> q2 = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			q1.offer(queue1[i]);
			sum1 += queue1[i];
			q2.offer(queue2[i]);
			sum2 += queue2[i];
		}

		while (sum1 != sum2) {
			if (answer > 4 * n) {
				answer = -1;
				break;
			}

			if (sum1 > sum2) {
				sum1 -= q1.peek();
				sum2 += q1.peek();
				q2.offer(q1.poll());
			} else if (sum1 < sum2) {
				sum1 += q2.peek();
				sum2 -= q2.peek();
				q1.offer(q2.poll());
			}

			answer++;
		}

		return answer;
	}
}