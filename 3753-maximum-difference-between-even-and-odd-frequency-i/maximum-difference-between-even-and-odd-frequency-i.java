class Solution {
    public int maxDifference(String s) {

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(count[i] > 0){
                if(count[i] % 2 !=0) {
                maxOdd = Math.max(maxOdd, count[i]);
            } else{
                minEven = Math.min(minEven, count[i]);
        }
            }
            
        }
         

        return maxOdd-minEven;
        
    }
}