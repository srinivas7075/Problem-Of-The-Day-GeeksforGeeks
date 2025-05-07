class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node r) {
        var res = new ArrayList<ArrayList<Integer>>();
        var curr = new ArrayList<Integer>();
        dfs(r, res, curr);
        return res;
    }
    static void dfs(Node n, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr) {
        if (n == null) return;
        curr.add(n.data);
        if (n.left == null && n.right == null) res.add(new ArrayList<>(curr));
        else {
            dfs(n.left, res, curr);
            dfs(n.right, res, curr);
        }
        curr.remove(curr.size() - 1);
    }
}
