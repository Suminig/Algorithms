class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int) (right - left + 1)];
        int idx = 0;
        
        for(long i = left; i <= right; i++){
            answer[idx++] = Math.max(i / n + 1, i % n + 1);
        }
        
        return answer;
    }
}