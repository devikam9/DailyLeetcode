import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Check if current temperature is warmer than the one at stack top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // days waited
            }
            stack.push(i); // add current day index
        }

        // Default values remain 0 for days with no warmer future
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] t1 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(sol.dailyTemperatures(t1))); 
        // [1, 1, 4, 2, 1, 1, 0, 0]

        int[] t2 = {30,40,50,60};
        System.out.println(Arrays.toString(sol.dailyTemperatures(t2))); 
        // [1, 1, 1, 0]

        int[] t3 = {30,60,90};
        System.out.println(Arrays.toString(sol.dailyTemperatures(t3))); 
        // [1, 1, 0]
    }
}
