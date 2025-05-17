class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length, l = 0, r = n - 1, i = A >= 0 ? n - 1 : 0;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        while (l <= r) {
            int lv = A * arr[l] * arr[l] + B * arr[l] + C;
            int rv = A * arr[r] * arr[r] + B * arr[r] + C;
            if (A >= 0) {
                res.set(i--, lv > rv ? lv : rv);
                if (lv > rv) l++; else r--;
            } else {
                res.set(i++, lv < rv ? lv : rv);
                if (lv < rv) l++; else r--;
            }
        }
        return res;
    }
}
