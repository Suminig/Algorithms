class Solution {
    public boolean isPrime(long n) {
        if (n < 2)
            return false;
        else if (n == 2)
            return true;
        else {
            for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

    public int solution(int n, int k) {
        int cnt = 0;

        String k_num = Integer.toString(n, k);
        String[] nums = k_num.split("0");

        for (String num : nums) {
            if (num.equals(""))
                continue;

            if (isPrime(Long.parseLong(num)))
                cnt++;
        }
        return cnt;
    }
}