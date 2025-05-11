class Solution {
    public static int kthLargest(int[] arr, int k) {
        int[] p = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i) p[i + 1] = p[i] + arr[i];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++i)
            for (int j = i + 1; j <= arr.length; ++j) {
                q.add(p[j] - p[i]);
                if (q.size() > k) q.poll();
            }
        return q.peek();
    }
}
