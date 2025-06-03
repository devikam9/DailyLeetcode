public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i <= 31; i++){
            int k = n & 1;
            n = n >> 1;
            res = res | k << (31-i);
        }
        return res;    
    }  
}