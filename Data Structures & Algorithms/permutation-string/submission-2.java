// s2.substring.len == s1.len && all char freq of s1 should match s2.substring freq
// 01234567
// lecabee
// i=0,j=0
// a-1
// b-1
// c-1
// l=-1
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char c: s1.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        int i=0,j=0, counter=hm.size();
        while(j<s2.length()){
            hm.put(s2.charAt(j), hm.getOrDefault(s2.charAt(j),0)-1);
            if(hm.get(s2.charAt(j++))==0) counter--;
            if(counter==0) return true;
            if(j-i==s1.length()){
                hm.put(s2.charAt(i), hm.get(s2.charAt(i))+1);
                if(hm.get(s2.charAt(i++))==1) counter++;
            }
        }
        return false;
    }
}
