class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        // 1.After sorting, the strings that are most different will end up at the first and last positions.

        // 2.So the longest common prefix of the entire array will always be the prefix common to the first and last string.
        String first = strs[0];
        String last = strs[strs.length-1];
        int c =0;
        while(c<first.length()){
            if(first.charAt(c)==last.charAt(c)){
                c++;
            }else{
                break;
            }
        }
        return c==0 ?"":first.substring(0,c);
    }
}