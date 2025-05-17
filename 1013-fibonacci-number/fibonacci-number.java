class Solution {
    public int fib(int n) {

        if( n <= 1){
            return n;
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        return fibMemo(n,res);
    }

    public int fibMemo(int n, int[] res){

        if(n <= 1) {
            return res[n];
        }
        if(res[n] != 0){
            return res[n];
        }
        res[n] = fibMemo(n - 1,res) + fibMemo(n - 2,res);
        return res[n];  
    }
}