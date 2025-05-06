class Solution {
    ArrayList<Integer> leftView(Node root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node cur = q.poll();
                if (i == 0) res.add(cur.data);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return res;
    }
}
