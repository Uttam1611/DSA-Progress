class Solution {
    int[] prefix;
    int total=0;

    public Solution(int[] w) {
        prefix=new int[w.length];
        for(int i=0;i<w.length;i++){
            total+=w[i];
            prefix[i]=total;
        }
    }

    public int pickIndex() {
        int target=(int)(Math.random()*total)+1;
        int l=0,r=prefix.length-1;

        while(l<r){
            int m=(l+r)/2;
            if(prefix[m]<target) l=m+1;
            else r=m;
        }
        return l;
    }
}
