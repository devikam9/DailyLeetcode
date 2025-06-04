class Solution {
    public boolean canJump(int[] nums) {

        int max = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
            // any point we reaches n-1 or n 
            if(max > nums.length - 1) return true;
        }
        return true;
    }
}