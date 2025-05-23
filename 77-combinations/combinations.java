class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();

        findCombinations(1,n,k,list);
        return result;    
    }

    private void findCombinations(int start, int n, int k, List<Integer> list){

        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i <= n; i++){
            list.add(i);
            findCombinations(i+1,n,k,list);
            list.remove(list.size() -1);
        }
    }
}