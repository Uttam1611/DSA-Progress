class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r=nums[nums.length-1]-nums[0];

        while(l<r){
            int m=(l+r)/2;
            if(count(nums,m) >= k) r=m;
            else l=m+1;
        }
        return l;
    }

    private int count(int[] nums, int dist){
        int count=0,left=0;
        for(int right=0; right<nums.length; right++){
            while(nums[right]-nums[left] > dist) left++;
            count += right-left;
        }
        return count;
    }
}
