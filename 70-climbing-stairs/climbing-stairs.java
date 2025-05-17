class Solution {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        return distinctWays(n,res);    
    }

    public int distinctWays(int n, int[] res){
        if(n == 0 || n == 1){
            return 1;
        }
        if(res[n] != 0){
            return res[n];
        }
        res[n] = distinctWays(n - 1,res) + distinctWays(n - 2,res);
        return res[n];
    }
}