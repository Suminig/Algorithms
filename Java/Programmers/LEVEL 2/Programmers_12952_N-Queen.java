class Solution {
    private int n, answer;
    private int[] cols;
    
    public boolean isAvailable(int rowNo) {
        for(int i = 1; i < rowNo; i++) {
            if(cols[i] == cols[rowNo] || rowNo - i == Math.abs(cols[rowNo] - cols[i]))
                return false;
        }
        return true;
    }
    
    public void nQueen(int rowNo) {
        if(!isAvailable(rowNo - 1))
            return;
        
        if(rowNo > n){
            answer++;
            return;
        }
        
        for(int i = 1; i <= n; i++) {
            cols[rowNo] = i;
            nQueen(rowNo + 1);
        }
    }
    
    public int solution(int n) {
        this.n = n;
        answer = 0;
        cols = new int[n + 1];
        
        nQueen(1);
        
        return answer;
    }
}