class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int total = 0;

        prefix[0] = height[0];
        for(int i = 1; i < height.length; i++){
            prefix[i] = Math.max(prefix[i-1],height[i]);
        }

        suffix[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--){
            suffix[i] = Math.max(suffix[i+1],height[i]);
        }

        for(int i = 0; i < height.length; i++){
            total += Math.min(prefix[i],suffix[i]) - height[i];
        }


        return total;
        
    }
}