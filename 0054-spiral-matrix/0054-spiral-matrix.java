import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> res=new ArrayList<>();
        int top=0,bottom=m.length-1,left=0,right=m[0].length-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++) res.add(m[top][i]);
            top++;

            for(int i=top;i<=bottom;i++) res.add(m[i][right]);
            right--;

            if(top<=bottom){
                for(int i=right;i>=left;i--) res.add(m[bottom][i]);
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--) res.add(m[i][left]);
                left++;
            }
        }
        return res;
    }
}
