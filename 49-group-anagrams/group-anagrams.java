class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for(String string : strs){
            String freq = getFrequency(string);

            if(!map.containsKey(freq)){
                map.put(freq,new ArrayList<>());
            }
            List<String> list = map.get(freq);
            list.add(string);
            map.put(freq,list);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry :  map.entrySet()){
            result.add(entry.getValue());
        }
        
        
        // List<List<String>> result = new ArrayList<>(map.values());

        return result;
    }

    private String getFrequency(String str){

        int[] count = new int[26];

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            count[ch - 'a']++;
        }

        StringBuffer sb = new StringBuffer();

        for(int val : count){
            sb.append(val + ",");
        }

        return sb.toString();
    }
}