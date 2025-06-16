class Solution {
    public int myAtoi(String s) {

        int total = 0, index = 0, sign = 1;
            if(s.length() == 0) return 0;
            while(index < s.length() && s.charAt(index) == ' ') index++;
            //if u reached end of string
            if(s.length() == index) return 0;
            if(s.charAt(index) == '+' || s.charAt(index) == '-'){
                sign = s.charAt(index) == '+' ? 1 : -1;
                index++;
            }

            while(index < s.length()){
                int val = s.charAt(index) - '0';
                if(val < 0 || val > 9) break;
                if(Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE % 10 < val)){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                total = total * 10 + val;
                index++;
            }
            return total * sign;
        
    }
}