class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        // Tc - O(N), Sc - O(1)
        int left = 0, right = k , currSum = 0, count = 0;
        for(int i = 0; i < k; i++){
            currSum += arr[i];
        }
        if(currSum/k >= threshold) count++;

        while(right < arr.length){
            currSum = currSum - arr[left];
            left++;
            currSum += arr[right];
            if(currSum/k >= threshold)
                count++;
            right++;
        }
        return count;
    }
}