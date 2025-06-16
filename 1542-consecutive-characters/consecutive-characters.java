class Solution {
    public int maxPower(String s) {
        //left = a[0], iterate the s and prev = current then increment max else prev = curr element
        //Tc - O(N),Sc - O(1)

        char left = s.charAt(0);
        int max = 1, currMax = 1;

        for(int i = 1; i < s.length(); i++){
            if(left == s.charAt(i)){
                currMax++;
                max = Math.max(currMax,max);
            }else{
                currMax = 1;
            }
            left = s.charAt(i);
            
        }
        return max;
    }
}