import java.util.ArrayList;

class Solution {
	private long maxNum = 0;
	private String expression;
	private String[] opers = { "+", "-", "*" };

	public void dfs(int cnt, int flag, String priority) {
		if (cnt == 3) {
			maximize(priority);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			dfs(cnt + 1, flag | 1 << i, priority + opers[i]);
		}
	}

	public void maximize(String priority) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Long> numList = new ArrayList<>();
		ArrayList<String> operList = new ArrayList<>();

		for (int i = 0, size = expression.length(); i < size; i++) {
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
				numList.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
				operList.add(String.valueOf(expression.charAt(i)));
			} else {
				sb.append(expression.charAt(i));
			}
		}

		numList.add(Long.parseLong(sb.toString()));

		for (int i = 0; i < 3; i++) {
			String oper = String.valueOf(priority.charAt(i));

			while (!operList.isEmpty()) {
				int index = operList.indexOf(oper);

				if (index == -1)
					break;

				if (oper.equals("+"))
					numList.add(index, numList.get(index) + numList.get(index + 1));
				else if (oper.equals("-"))
					numList.add(index, numList.get(index) - numList.get(index + 1));
				else
					numList.add(index, numList.get(index) * numList.get(index + 1));

				numList.remove(index + 1);
				numList.remove(index + 1);
				operList.remove(index);
			}
		}
		maxNum = Math.max(maxNum, Math.abs(numList.get(0)));
	}

	public long solution(String expression) {
		this.expression = expression;
		dfs(0, 0, "");
		return maxNum;
	}
}