class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // TC - O(N), SC - O(1)

        int start = 0, end = numbers.length - 1;

        while(start <= end){
            if(numbers[start] + numbers[end] == target){
                return new int[]{start + 1, end + 1};
            }else if(numbers[start] + numbers[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return new int[]{-1,-1};    
    }
}