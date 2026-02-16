import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,res=0;

        for(int n: nums){
            sum+=n;
            int rem=((sum%k)+k)%k;
            res+=map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return res;
    }
}
