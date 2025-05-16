class Solution {
    static class Node {
        int v, r, c;
        Node(int v, int r, int c) { this.v = v; this.r = r; this.c = c; }
    }
    public ArrayList<Integer> findSmallestRange(int[][] a) {
        int n = a.length, m = a[0].length, hi = Integer.MIN_VALUE, lo = 0, r = Integer.MAX_VALUE;
        PriorityQueue<Node> q = new PriorityQueue<>((x, y) -> x.v - y.v);
        for (int i = 0; i < n; i++) {
            q.add(new Node(a[i][0], i, 0));
            hi = Math.max(hi, a[i][0]);
        }
        while (true) {
            Node x = q.poll();
            if (hi - x.v < r - lo) { lo = x.v; r = hi; }
            if (x.c + 1 == m) break;
            int y = a[x.r][x.c + 1];
            q.add(new Node(y, x.r, x.c + 1));
            hi = Math.max(hi, y);
        }
        return new ArrayList<>(Arrays.asList(lo, r));
    }
}
