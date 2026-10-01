// ["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]
// alice -> [{happy,1},{sad, 3}]
// 1,3,5,6  1
// l=0, h=3  -> mid=1 -> prev_timeStamp=3  -> h=mid-1
// l=0, h=0  -> mid=0 -> prev_timestamp=1  -> l=mid
public record Value(String val, int timeStamp) {}
class TimeMap {
    Map<String, List<Value>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)){
            hm.put(key, new ArrayList<>());
        }
        hm.get(key).add(new Value(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        List<Value> lst = hm.get(key);
        int l=0, h=lst.size()-1;
        int ans=-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(lst.get(mid).timeStamp()>timestamp){
                h = mid-1;
            }
            else{
                ans=mid;
                l=mid+1;
            }
        }
        return ans==-1?"":lst.get(ans).val();
    }
}
