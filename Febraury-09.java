class Solution {
    private int maxSum = Integer.MIN_VALUE; // Global variable to store max path sum

    // Function to return maximum path sum from any node in the tree
    int findMaxSum(Node node) {
        maxGain(node);
        return maxSum;
    }

    private int maxGain(Node node) {
        if (node == null) {
            return 0;
        }

        // Calculate max sum from left and right subtrees, ignoring negative values
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Current path sum including both left and right children
        int currentPathSum = node.data + leftGain + rightGain;

        // Update global maxSum if currentPathSum is greater
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum path sum that includes the current node and at most one of its children
        return node.data + Math.max(leftGain, rightGain);
    }
}
