class Solution {

    public int findTheWinner(int n, int k) {
        //tc - adding elements - o(n) + add and remove ach element for k -1 times. we do this for n - 1 elements = (n - 1) * (k - 1) = O(n * k)
        // sc - O(n)
        // Initialize queue with n friends
        Queue<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Perform eliminations while more than 1 player remains
        while (circle.size() > 1) {
            // Process the first k-1 friends without eliminating them
            for (int i = 0; i < k - 1; i++) {
                circle.add(circle.remove());
            }
            // Eliminate the k-th friend
            circle.remove();
        }

        return circle.peek();
    }
}