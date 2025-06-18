class Solution {
    public int findKthLargest(int[] nums, int k) {
        //create a prorityqueue (min heap) and add the values only till size k
        //2. if greater than k remove from pq
        //3. return pq.peek()

        PriorityQueue<Integer> largestEle = new PriorityQueue<>((a,b)->{
            if(a < b) return -1;
            else if( a > b) return 1;
            else return 0;
        });
        for(int i : nums){
            largestEle.add(i);
            if(largestEle.size() > k){
                largestEle.poll();
            }
        }

        return largestEle.peek();    
    }
}