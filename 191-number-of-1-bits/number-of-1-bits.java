class Solution {
    public int hammingWeight(int n) {

        
        // int res = 0;
        // while(n > 0){
        //     res += n % 2;
        //     n = n >> 1;
        // }
        // return res;

        // approach 2 
        //1. while n > 0 - and every bit with 1
        // right shift n
        //1&1 = 1
        // int res = 0;
        // while(n > 0){
        //     res += n & 1;
        //     n = n >> 1;
        // }
        // return res;

        //approach 3
        //1. n > 0 : n & n - 1
        //2. Increment res every time.

        int res = 0;
        while(n > 0){
            n = n & (n -1);
            res++;
        }
        return res;
    }
}