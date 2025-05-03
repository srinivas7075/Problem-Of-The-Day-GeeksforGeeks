class Solution {
    Node primeList(Node h) {
        int m = 0;
        for (Node p = h; p != null; p = p.next) m = Math.max(m, p.val);
        boolean[] s = new boolean[2*m+1];
        Arrays.fill(s, true);
        s[0] = s[1] = false;
        for (int i = 2; i*i <= 2*m; i++)
            if (s[i])
                for (int j = i*i; j <= 2*m; j += i) s[j] = false;
        for (Node p = h; p != null; p = p.next) {
            int x = p.val, d = 0;
            while (true) {
                if (x-d > 1 && s[x-d]) { p.val = x-d; break; }
                if (x+d <= 2*m && s[x+d]) { p.val = x+d; break; }
                d++;
            }
        }
        return h;
    }
}
