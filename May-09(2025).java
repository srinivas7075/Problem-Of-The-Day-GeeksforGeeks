class Solution {
    String ans;
    void r(char[] a, int k, int i) {
        if (k == 0 || i == a.length) return;
        char m = a[i];
        for (int j = i + 1; j < a.length; j++) if (a[j] > m) m = a[j];
        if (m != a[i]) {
            for (int j = a.length - 1; j >= i; j--) if (a[j] == m) {
                char t = a[i]; a[i] = a[j]; a[j] = t;
                String cur = new String(a);
                if (cur.compareTo(ans) > 0) ans = cur;
                r(a, k - 1, i + 1);
                a[j] = a[i]; a[i] = t;
            }
        } else r(a, k, i + 1);
    }
    public String findMaximumNum(String s, int k) {
        ans = s;
        r(s.toCharArray(), k, 0);
        return ans;
    }
}
