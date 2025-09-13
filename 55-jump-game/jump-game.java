class Solution {
    int[] memo;
    public boolean canJump(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo,-1);

        return helper(0,nums);    
    }
    private boolean helper(int index, int[] nums){

        if(index >= nums.length - 1) return true;

        if(memo[index] != -1) return memo[index] == 1;
        int val = nums[index];

        for(int i = 1; i <= val; i++){
            if(helper(index+i,nums) == true) {
                memo[index] = 1;
                return true;
            } 
        }
        memo[index] = 0;
        return false;
        
    }
}