class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int len = nums.length;

        int[] newInt = new int[len + 2];
        newInt[0] = 1;
        newInt[newInt.length - 1] = 1;

        for(int i = 0; i < nums.length; i++){
            newInt[i+1] = nums[i];
        }
        dp = new int[len+2][len+2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return helper(newInt,1,len);   
    }
    private int helper(int[] newInt, int index,int end){
        if(index > end) return 0;
        if(dp[index][end] != -1) return dp[index][end];
        int max = Integer.MIN_VALUE;
        for(int i = index; i <= end; i++){
            int cost = newInt[index-1] * newInt[i] * newInt[end+1] + helper(newInt,index,i-1) + helper(newInt,i+1,end);
            max = Math.max(cost,max);
        }
        return dp[index][end] = max;
    }
}