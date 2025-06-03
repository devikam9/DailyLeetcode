class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        boolean[] seen = new boolean[n+1];

        for(int num : nums){
            if(num > 0 && num <= n){
                seen[num] = true;
            }
        }
        // if it's not in seen then return that index - which is the missing number
        for(int i = 1; i <= n; i++){
            if(!seen[i]){
                return i;
            }
        }
        // if it contains all elements then n+1 is missing
        return n + 1;
        
    }
}