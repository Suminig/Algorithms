import java.util.*;

class Solution {
    private int n, max = -1;
    private int[] info, ryan;
    private Queue<int[]> answers;
    
    public void dfs(int cnt, int idx){
        if(cnt == n){
            int scoreApeach = 0, scoreRyan = 0;
            for(int i = 0; i < 11; i++){
                if(ryan[i] == 0 && info[i] == 0)
                    continue;
                    
                if(ryan[i] > info[i])
                    scoreRyan += (10-i);
                else
                    scoreApeach += (10-i);
            }
            
            if(scoreRyan <= scoreApeach || scoreRyan - scoreApeach < max)
                return;
            
            if(scoreRyan - scoreApeach > max){
                max = scoreRyan - scoreApeach;
                answers.clear();
            }
            answers.add(ryan.clone());
            return;
        }
        
        for(int i = idx; i < 11; i++){
            ryan[i]++;
            dfs(cnt + 1, i);
            ryan[i]--;
        }
    }
    
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        ryan = new int[11];
        answers = new PriorityQueue<>((o1, o2) -> {
            for(int i = 10; i >= 0; i--){
                if(o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        
        dfs(0, 0);
        
        return answers.isEmpty() ? new int[]{-1} : answers.poll();
    }
}
