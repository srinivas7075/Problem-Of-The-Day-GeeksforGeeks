class Solution {
    int[] solve(Node r){
        if(r==null)return new int[]{0,0};
        int[] l=solve(r.left),r1=solve(r.right);
        return new int[]{r.data+l[1]+r1[1],Math.max(l[0],l[1])+Math.max(r1[0],r1[1])};
    }
    public int getMaxSum(Node r){
        int[] p=solve(r);
        return Math.max(p[0],p[1]);
    }
}
