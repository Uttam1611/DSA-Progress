import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums) map.put(n,map.getOrDefault(n,0)+1);

        List<Integer>[] bucket = new List[nums.length+1];
        for(int key: map.keySet()){
            int freq=map.get(key);
            if(bucket[freq]==null) bucket[freq]=new ArrayList<>();
            bucket[freq].add(key);
        }

        List<Integer> res=new ArrayList<>();
        for(int i=bucket.length-1;i>=0 && res.size()<k;i--)
            if(bucket[i]!=null) res.addAll(bucket[i]);

        return res.stream().mapToInt(i->i).toArray();
    }
}
