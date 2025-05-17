class Solution {
    public int tribonacci(int n) {

        if(n == 0 || n == 1) return n;       

        int prev = 1, prev1 = 1, prev2 = 0;

        for(int i = 3; i <= n; i++){

            int curr = prev + prev1 + prev2;
            prev2 = prev1;
            prev1 = prev;
            prev = curr;
        } 
        
        return prev;
    }
}