class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums,target), last(nums,target)};
    }

    private int first(int[] nums, int t){
        int l=0,r=nums.length-1,ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]>=t){
                if(nums[m]==t) ans=m;
                r=m-1;
            } else l=m+1;
        }
        return ans;
    }

    private int last(int[] nums, int t){
        int l=0,r=nums.length-1,ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]<=t){
                if(nums[m]==t) ans=m;
                l=m+1;
            } else r=m-1;
        }
        return ans;
    }
}
