class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //1. Use a hashmap and add it to the map if its not present.
        //2. if it's already present - check for the condition 
        //3. if condition doesn't satisfy then update the map with the current index
        //(as till this index it didnt satisfied so from the current index it may satisfy)

        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i]) - i) <= k){
                    return true;
                } 
                map.put(nums[i],i);
            }else{
                map.put(nums[i],i);
            }
        }

        return false;
    }
}