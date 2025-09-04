class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //1. create a map and store the freq of each string
        //2. add to the resultant array all the lists.


        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String freq = getFreq(str.toCharArray());

            if(!map.containsKey(freq)){
                map.put(freq, new ArrayList<String>());
            }
            map.get(freq).add(str);
        }
        List<List<String>> result = new ArrayList<>(map.values());

        return result;
    }

    private String getFreq(char[] ch){
        int[] charCount = new int[26];

        for(char c : ch){
            charCount[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : charCount){
            sb.append(i + ",");
        }

        return sb.toString();
    }
}