import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length<=2) return points.length;
        int max=0;

        for(int i=0;i<points.length;i++){
            Map<String,Integer> map=new HashMap<>();
            int dup=1;

            for(int j=i+1;j<points.length;j++){
                int dx=points[j][0]-points[i][0];
                int dy=points[j][1]-points[i][1];

                if(dx==0 && dy==0){ dup++; continue; }

                int g=gcd(dx,dy);
                dx/=g; dy/=g;

                String key=dx+","+dy;
                map.put(key,map.getOrDefault(key,0)+1);
            }

            int local=0;
            for(int v: map.values()) local=Math.max(local,v);

            max=Math.max(max,local+dup);
        }
        return max;
    }

    private int gcd(int a,int b){
        return b==0? a: gcd(b,a%b);
    }
}
