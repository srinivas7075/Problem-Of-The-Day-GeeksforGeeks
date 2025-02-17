class Solution {
    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    // Function to add left boundary (excluding leaf nodes)
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) result.add(curr.data);
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    // Function to add leaf nodes (left to right)
    private void addLeafNodes(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        addLeafNodes(node.left, result);
        addLeafNodes(node.right, result);
    }

    // Function to add right boundary (excluding leaf nodes, in reverse order)
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);
            curr = (curr.right != null) ? curr.right : curr.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        // Add root (only if it's not a leaf)
        if (!isLeaf(node)) result.add(node.data);

        // Add left boundary
        addLeftBoundary(node, result);

        // Add leaf nodes
        addLeafNodes(node, result);

        // Add right boundary
        addRightBoundary(node, result);

        return result;
    }
}
