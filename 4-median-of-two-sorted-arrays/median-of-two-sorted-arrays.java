class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length , n2 = nums2.length;
        int n = n1 + n2;

        int count = 0, indEle2 = -1 , indEle1 = -1 ,ind1 = n/2 - 1, ind2 = n/2;
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                if(count == ind1) indEle1 = nums1[i];
                if(count == ind2) indEle2 = nums1[i];
                count++;
                i++;
            }else{
                if(count == ind1) indEle1 = nums2[j];
                if(count == ind2) indEle2 = nums2[j];
                count++;
                j++;
            }
            
        }

        while(i < n1){
            if(count == ind1) indEle1 = nums1[i];
            if(count == ind2) indEle2 = nums1[i];
            count++;
            i++;
        }

        while(j < n2){
            if(count == ind1) indEle1 = nums2[j];
            if(count == ind2) indEle2 = nums2[j];
            count++;
            j++;
        }

        if(n%2 == 1){
            return indEle2;
        }

        return (double)((indEle1 + indEle2)/2.0);

    }
}