class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = prices[0];
        for(int i = 1; i < prices.length; i++){   
            if(prices[i] > min){
             int profit = prices[i] - min;
             max = Math.max(profit,max);
            } 
            min = Math.min(min,prices[i]);   
        }

        return max;
    }
}
