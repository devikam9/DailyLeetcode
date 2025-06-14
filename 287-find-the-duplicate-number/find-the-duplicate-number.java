class Solution {
    public int findDuplicate(int[] nums) {

        //Tc - O(N), Sc - O(1)

        int slow = nums[0];
        int fast = nums[0];

       do{
        fast = nums[nums[fast]];
        slow = nums[slow];
       }while(fast != slow);

       slow = nums[0];
       while(slow != fast){
        slow = nums[slow];
        fast = nums[fast];
       }

       return slow;
        
    }
}