class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length + nums2.length];


        int index1 = 0, index2 = 0, index = 0;

        while(index1 < nums1.length && index2 < nums2.length){

            if(nums1[index1] <= nums2[index2]){
                result[index] = nums1[index1];
                index1++;
                index++;
            }else{
                result[index] = nums2[index2];
                index2++;
                index++;
            }
        }
        
        while(index1 != nums1.length){
            result[index] = nums1[index1];
            index1++;
            index++;
        }

        while(index2 != nums2.length){
            result[index] = nums2[index2];
            index2++;
            index++;
        }

        if(result.length % 2 != 0){
            //odd
            int mid = (0 + result.length-1)/2;
            return (double)result[mid];
        }else{
            //even
            int mid = (0 + result.length-1)/2;
            return (double)(result[mid] + result[mid+1])/2;
        }
        
    }
}