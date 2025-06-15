class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s == null) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0;

        for(int i = 0; i < s.length();i++){

            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}