import java.util.*;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int day=0, eaten=0;

        while(day < apples.length || !pq.isEmpty()){
            if(day < apples.length && apples[day]>0)
                pq.add(new int[]{day+days[day], apples[day]});

            while(!pq.isEmpty() && pq.peek()[0] <= day) pq.poll();

            if(!pq.isEmpty()){
                pq.peek()[1]--;
                eaten++;
                if(pq.peek()[1]==0) pq.poll();
            }
            day++;
        }
        return eaten;
    }
}
