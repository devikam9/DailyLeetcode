class Solution {
    int profit = 0;
    int[][][] dp;
    public int maxProfit(int[] prices) {

        int len = prices.length;
        dp = new int[len][2][3];
        for(int[][] row : dp){
            for(int[] col : row){
                Arrays.fill(col,-1);
            }
        }

            
        return helper(prices,0,1,2);
        
    }

    private int helper(int[] prices,int index, int buy, int capacity){

        if(capacity == 0 || index == prices.length) return 0;

        if(dp[index][buy][capacity] != -1) return dp[index][buy][capacity];
        if(buy == 1){
            profit = Math.max(-prices[index] + helper(prices,index+1,0,capacity), 0 + helper(prices,index+1,1,capacity));
        }else{
            profit = Math.max(prices[index] + helper(prices,index+1,1,capacity-1), 0 + helper(prices,index+1,0,capacity));
        }

        return dp[index][buy][capacity] = profit;
    }
}