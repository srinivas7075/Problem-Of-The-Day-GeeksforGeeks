class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean rightToLeft = true; // even levels start right to left

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (rightToLeft) {
                    level.add(0, curr.data); // insert at beginning
                } else {
                    level.add(curr.data); // insert at end
                }

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            result.addAll(level);
            rightToLeft = !rightToLeft; // alternate direction
        }

        return result;
    }
}
