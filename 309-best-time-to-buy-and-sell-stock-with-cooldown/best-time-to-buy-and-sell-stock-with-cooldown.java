class Solution {
    int profit;
    int[][] dp;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        dp = new int[len][2];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return helper(prices,0,1);
        
    }

    private int helper(int[] prices, int index, int buy){

        //base cases
        if(index >= prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];

        if(buy == 1){

            profit = Math.max(-prices[index] + helper(prices,index+1,0), 0 + helper(prices,index+1,1));
        }else{
            //index+2?
            profit = Math.max(prices[index] + helper(prices,index+2,1), 0 + helper(prices,index+1,0));
        }

        return dp[index][buy] = profit;
    }
}