import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
		int[] answer = new int[len];
		
		// 중복 신고 제거
		HashSet<String> reportSet = new HashSet<>(Arrays.asList(report)); 
		
		// 사용자 별 신고당한 횟수 카운트
		HashMap<String, Integer> reportCnt = new HashMap<>();
		for (String id : id_list) {
			reportCnt.put(id, 0);
		}
		
		// 각자 신고한 사람 리스트
		ArrayList<String>[] reported = new ArrayList[len];
		for (int i = 0; i < len; i++) {
			reported[i] = new ArrayList<>();
		}
		
		for (String str : reportSet) {
			String[] ids = str.split(" ");
			String reporter = ids[0];
			String reportee = ids[1];
			
			reported[Arrays.asList(id_list).indexOf(reporter)].add(reportee);
			reportCnt.put(reportee, reportCnt.get(reportee)+1);
		}
		
		for (int i = 0; i < len; i++) {
			for (String id : reported[i]) {
				if (reportCnt.get(id) >= k) {
					answer[i]++;
				}
			}
		}
        
        return answer;
    }
}