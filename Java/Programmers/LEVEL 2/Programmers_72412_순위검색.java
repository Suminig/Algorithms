import java.util.*;

class Solution {    
	public HashMap<String, ArrayList<Integer>> map;
    
    public void dfs(String str, int cnt, String[] arr) {
		if (cnt == 4) {
			int score = Integer.parseInt(arr[4]);
			if (map.containsKey(str)) {
				map.get(str).add(score);
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(score);
				map.put(str, temp);
			}
			return;
		}

		dfs(str + "-", cnt + 1, arr);
		dfs(str + arr[cnt], cnt + 1, arr);
	}
    
    public int binarySearch(String query, int score) {
        if(!map.containsKey(query)) return 0;
        
		ArrayList<Integer> scores = map.get(query);
		int left = 0, right = scores.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (score > scores.get(mid))
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		return scores.size() - left;
	}
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
		map = new HashMap<>();

		for (String applicant : info) {
			dfs("", 0, applicant.split(" "));
		}
        
        for (String key : map.keySet())
			Collections.sort(map.get(key));
        
		for (int i = 0, size = query.length; i < size; i++) {
			String str = query[i].replaceAll(" and ", "");
			String[] arr = str.split(" ");

			answer[i] = binarySearch(arr[0], Integer.parseInt(arr[1]));
		}
		return answer;
    }
}