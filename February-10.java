class Solution {
    private int count = 0;

    public int sumK(Node root, int k) {
        count = 0;
        findKSumPaths(root, k, new ArrayList<>());
        return count;
    }

    private void findKSumPaths(Node node, int k, ArrayList<Integer> path) {
        if (node == null) return;

        // Add current node's value to the path
        path.add(node.data);

        // Check for all subarrays ending at this node
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                count++;
            }
        }

        // Recur for left and right subtree
        findKSumPaths(node.left, k, path);
        findKSumPaths(node.right, k, path);

        // Backtrack: Remove the last element to return to the previous state
        path.remove(path.size() - 1);
    }
}
