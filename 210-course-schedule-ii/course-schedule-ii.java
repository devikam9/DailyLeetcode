class Solution {
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        

        for(int[] i : prerequisites){
            if(!map.containsKey(i[0])){
                List<Integer> list = new ArrayList<>();
                list.add(i[1]);
                map.put(i[0],list);
            }else{
                List<Integer> list = map.get(i[0]);
                list.add(i[1]);
                map.put(i[0],list);
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(isCycle(i,map,visited,visiting)){
               return new int[]{};
            }
        }
        int[] result = new int[stack.size()];
        int index = result.length - 1;

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            result[index--] = stack.pop();
        }
        return result;
    }

    private boolean isCycle(int index, Map<Integer,List<Integer>> map,boolean[] visiting,boolean[] visited){

        // if(!map.containsKey(index)){
        //     stack.push(index);
        //     visited[index] = true;
        //     return false;
        // } 

        
        if(visiting[index]) return true;
        if(visited[index]) return false;

        visiting[index] = true;

        List<Integer> list = map.get(index);
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if(isCycle(list.get(i),map,visiting,visited)){
                    return true;
                }
            }
        }
        

        visiting[index] = false;
        visited[index] = true;

        stack.push(index);

        return false;
    }
}