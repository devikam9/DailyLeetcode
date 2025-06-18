class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        //TC - O(2N), SC - O(1)
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < asteroids.length; i++){

            if(asteroids[i] > 0){
                //add positives to list
                list.add(asteroids[i]);
            }else{

                while(!list.isEmpty() && list.get(list.size() - 1) > 0 && list.get(list.size() - 1) < Math.abs(asteroids[i])){
                    //-ve is greater than +ve , you remove positive from list
                    list.remove(list.size() - 1);
                }

                if(!list.isEmpty() && list.get(list.size() - 1) == Math.abs(asteroids[i])){
                    //both are equal, remove positive from list
                    list.remove(list.size() - 1);
                }
                else if(list.isEmpty() || list.get(list.size() - 1) < 0){
                    // if prev is -ve then you add the present element to list
                    list.add(asteroids[i]);
                }
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result; 
    }
}