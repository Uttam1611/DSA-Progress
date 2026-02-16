class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for(char c: t.toCharArray()) count[c]++;

        int left=0,right=0,start=0,minLen=Integer.MAX_VALUE,needed=t.length();

        while(right<s.length()){
            if(count[s.charAt(right++)]-- >0) needed--;

            while(needed==0){
                if(right-left<minLen){
                    minLen=right-left;
                    start=left;
                }
                if(count[s.charAt(left++)]++==0) needed++;
            }
        }
        return minLen==Integer.MAX_VALUE? "": s.substring(start,start+minLen);
    }
}
