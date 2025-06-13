class Solution {
    int profit;
    int[][] dp;
    public int maxProfit(int[] prices) {
       
       int len = prices.length;
       dp = new int[len][2];
       for(int[] row : dp)
            Arrays.fill(row,-1);
       

       return findProfit(prices,0,1);    
    }

    private int findProfit(int[] prices, int index, int buy){

        if(index >= prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1){
            //sell
            profit = Math.max(-prices[index] + findProfit(prices,index+1,0) , 0 + findProfit(prices,index+1,1));

        }else{
            //buy
            profit = Math.max(+prices[index] + findProfit(prices,index+1,1) , 0 + findProfit(prices,index+1,0));
        }

        return dp[index][buy] = profit;
    }
}