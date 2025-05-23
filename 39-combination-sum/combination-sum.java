class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        findCombo(candidates,target,0,list);   
        return result;
    }

    private void findCombo(int[] candidates, int target,int start,List<Integer> list){

        if(sum(list) == target){
            result.add(new ArrayList<>(list));
            return;
        }

        if(sum(list) > target){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            findCombo(candidates,target,i,list);
            list.remove(list.size()-1);
        }
    }

    private int sum(List<Integer> list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }
}