class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //1. sort both arrays
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length, n = s.length;
        //2. two pointer approach 
        int left = 0, right = 0;
        while(left < m && right < n){

            if(s[right] >= g[left]){
                left++;
            }
            right++;
        }
        return left;    
    }
}