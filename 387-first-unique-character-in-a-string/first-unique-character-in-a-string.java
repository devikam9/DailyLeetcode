class Solution {
    public int firstUniqChar(String s) {
        //1. created a freq array to store the count
        //2. iterate the string s to find the character == 1
        //3. return it else return -1

      int[] freq = new int[26];
      for(int i = 0; i < s.length(); i++){
        freq[s.charAt(i) - 'a']++;
      }  

      for(int i = 0; i < s.length(); i++){
        if(freq[s.charAt(i) - 'a'] == 1){
            return i;
        }
      }
        return -1;
    }
}