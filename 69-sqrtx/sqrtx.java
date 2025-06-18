class Solution {
    public int mySqrt(int x) {

        // Tc - O(log 2 N), Sc - O(1)

        long low = 1, high = x;
        long ans = 0;

        while(low <= high){

            long mid = low + (high - low)/2;

            if( mid * mid <= x){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int)high;    
    }
}