class Solution {
    public boolean checkIfPangram(String sentence) {

        if(sentence.length() < 26) return false;

        int[] seen = new int[26];

        for(char c : sentence.toCharArray()){
            seen[c - 'a']++;
        }

        for(int i : seen){
            if(i == 0){
                return false;
            }
        }

        return true;
    }
}