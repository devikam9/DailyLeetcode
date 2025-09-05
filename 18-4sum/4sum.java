class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int temp = i+1;
            for(int j = i+1; j < n - 2; j++){

                 if(j > temp && nums[j] == nums[j - 1]) continue;
                int low = j + 1, high = n - 1;

                while(low < high){
                    long sum = 0L + nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low] , nums[high]);                  
                        result.add(list);
                        low++;
                        high--;
                        while(low < high && nums[low] == nums[low-1]) low++;
                        while(low < high && nums[high] == nums[high+1]) high--;
                    }
                    else if(nums[i] + nums[j] + nums[low] + nums[high] < target){
                        low++;
                        
                    }else{
                        high--;
                        
                    }
                }

            }
        }

        return result;
        
    }
}