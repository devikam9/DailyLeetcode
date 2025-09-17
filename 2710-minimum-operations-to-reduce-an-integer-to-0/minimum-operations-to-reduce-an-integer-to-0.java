class Solution {
    public int minOperations(int n) {
       int ops = 0;

        while (n > 0) {
            // Case 1: if n is already a power of 2
            if ((n & (n - 1)) == 0) {
                ops++;
                break;
            }

            // Find nearest powers of 2
            int low = Integer.highestOneBit(n);   // largest power of 2 <= n
            int high = low << 1;                  // next power of 2 > n

            // Decide whether to move up or down
            if (n - low <= high - n) {
                n = n - low;   // subtract
            } else {
                n = high - n;  // add
            }
            ops++;
        }

        return ops; 
    }
}