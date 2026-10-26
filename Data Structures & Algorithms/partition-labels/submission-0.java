class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq= new int[26];
        s.chars().forEach(c-> freq[c-'a']++);
        Map<Character, Integer> hm = new HashMap<>();
        int partitionCurrSz = 0;
        List<Integer> partitionLst = new ArrayList<>();
        for(char c:s.toCharArray()){
            hm.put((char)c, hm.getOrDefault((char)c,0)+1);
            partitionCurrSz++;
            if(hm.get(c)==freq[c-'a']) hm.remove(c);
            if(hm.size()==0){
                partitionLst.add(partitionCurrSz);
                partitionCurrSz=0;
            }
        }
        return partitionLst;
    }
}