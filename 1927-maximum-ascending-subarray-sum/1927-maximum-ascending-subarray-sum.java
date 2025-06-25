import java.lang.Math;
class Solution {
    public int maxAscendingSum(int[] nums) {
        int s=nums[0];
        int fs=0;
        if(nums.length==1) return fs=nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                s += nums[i];
            }
            fs = Math.max(fs,s);
            if(i!=nums.length-1 && nums[i]<nums[i-1] || nums[i]==nums[i-1]){
                s=nums[i];
            }
        }
    return fs;
    }
}