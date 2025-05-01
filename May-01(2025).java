class Solution {
    public ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row=new ArrayList<>();
        long v=1;
        for(int i=0;i<n;++i){
            row.add((int)v);
            v=v*(n-1-i)/(i+1);
        }
        return row;
    }
}
