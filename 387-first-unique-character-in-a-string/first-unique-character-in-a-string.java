class Solution {
    public int firstUniqChar(String s) {
        // 1. traverse the array and at every index - 
        //2. compare it with all other elements.
        //3. if at any index - non repating character then return -1
        //4. else return the i
        int result = -1;
        
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            for(int j = 0; j < s.length(); j++){
                if(i!= j && s.charAt(i) == s.charAt(j)){
                    count++;
                    break;
                }
            }
            if(count == 0) return i;
        }
        return result;    
    }
}