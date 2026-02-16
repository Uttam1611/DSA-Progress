import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if(words.length==0) return res;

        int wordLen=words[0].length();
        int totalLen=wordLen*words.length;

        Map<String,Integer> map=new HashMap<>();
        for(String w: words) map.put(w,map.getOrDefault(w,0)+1);

        for(int i=0;i<wordLen;i++){
            int left=i,count=0;
            Map<String,Integer> window=new HashMap<>();

            for(int j=i;j+wordLen<=s.length();j+=wordLen){
                String word=s.substring(j,j+wordLen);

                if(map.containsKey(word)){
                    window.put(word,window.getOrDefault(word,0)+1);
                    count++;

                    while(window.get(word)>map.get(word)){
                        String leftWord=s.substring(left,left+wordLen);
                        window.put(leftWord,window.get(leftWord)-1);
                        left+=wordLen;
                        count--;
                    }

                    if(count==words.length) res.add(left);
                } else {
                    window.clear();
                    count=0;
                    left=j+wordLen;
                }
            }
        }
        return res;
    }
}
