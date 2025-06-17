class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return helper(coins, amount, coins.length-1) == Integer.MAX_VALUE ? -1: helper(coins, amount, coins.length-1);
        
    }

    private int helper(int[] coins, int amount, int index) {
    
        if(index < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }

        if(amount == 0) return 0;
        if(dp[index][amount] != -1) return dp[index][amount];
       int pick = helper(coins, amount - coins[index], index);
       if(pick != Integer.MAX_VALUE)
        pick += 1;
       int noPick = helper(coins, amount, index-1);

       return dp[index][amount] = Math.min(pick, noPick); 
    }
}