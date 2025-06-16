class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0);    
    }

    private int helper(String s, int index){

        if(index >= s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(dp[index] != -1) return dp[index];
        int oneDigit = 0, twoDigit = 0;
        int num1 = Integer.parseInt(s.substring(index,index+1));
        if(num1 >= 1 && num1 <= 26){
            oneDigit = helper(s,index+1);
        }

        if(index+2 <= s.length()){
            int num2 = Integer.parseInt(s.substring(index,index+2));
            if(num2 >= 10 && num2 <= 26){
                twoDigit = helper(s,index+2);
            }
        }
        

        return dp[index] = oneDigit + twoDigit;
    }
}