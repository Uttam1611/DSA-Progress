import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();

        for(int n: nums){
            int idx=Math.abs(n)-1;
            if(nums[idx]<0) res.add(idx+1);
            nums[idx]*=-1;
        }
        return res;
    }
}
