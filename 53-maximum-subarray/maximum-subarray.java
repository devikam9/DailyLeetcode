class Solution {
    public int maxSubArray(int[] nums) {

        int max = nums[0], currMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            currMax = Math.max(currMax + nums[i],nums[i]);//9,8,15,23
            max = Math.max(currMax,max);//9,15,23
        }
        return max;
    }
}