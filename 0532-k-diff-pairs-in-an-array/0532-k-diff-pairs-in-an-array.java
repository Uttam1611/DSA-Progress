import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        Set<Integer> seen=new HashSet<>();
        Set<Integer> res=new HashSet<>();

        for(int n: nums){
            if(seen.contains(n-k)) res.add(n-k);
            if(seen.contains(n+k)) res.add(n);
            seen.add(n);
        }
        return res.size();
    }
}
