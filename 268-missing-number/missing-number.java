class Solution {
    public int missingNumber(int[] nums) {

        int sum = 0, total_sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            total_sum += (i+1);
        }
        return total_sum - sum;
    }
}