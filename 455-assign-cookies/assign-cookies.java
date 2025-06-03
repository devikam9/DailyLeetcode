class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        int max = 0;
        for(int i = 0; i < g.length; i++){
            // int index = 0;
            for(int j = 0; j < s.length; j++){

                if(s[j] >= g[i]){
                    s[j] = 0;
                    max++;
                    break;
                }
            }
        }
        return max;    
    }
}