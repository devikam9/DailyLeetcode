class Solution {
    public int[][] highFive(int[][] items) {

        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        

        for(int[] item : items){
            if(!map.containsKey(item[0])){
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(item[1]);
                map.put(item[0],pq);
            }else{
                PriorityQueue<Integer> pq = map.get(item[0]);
                pq.add(item[1]);
                while(pq.size() > 5){
                    pq.remove();
                }
                map.put(item[0],pq);
            }
        }

        int[][] res = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();
            int sum = 0;
            while(!pq.isEmpty()){
                sum += pq.remove();
            }
            int[] temp = new int[2];
            temp[0] = id;
            temp[1] = sum/5;
            res[index] = temp;
            index++;
        }
        return res;
    }
}